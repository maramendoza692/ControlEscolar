package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.Response;

@Repository
public class ConsultaAlumnoRepository implements IConsultaAlumnoRepository{

	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
					//<Alumno> retornar Alumno
		CriteriaQuery<Alumno> cq = cb.createQuery(Alumno.class);
	
		Root<Alumno> root = cq.from(Alumno.class);
		//Predicate es como un where, es decir, condicicón.
		List<Predicate> predicados = new ArrayList<Predicate>();
		
		if(filtro.getTxt_expediente() != null && !filtro.getTxt_expediente().isEmpty()) {
									//campo que vamos a validar y valor
			predicados.add(cb.like(root.get("txt_expediente"), "%"+ filtro.getTxt_expediente() + "%"));
		}
		
		if(filtro.getTxt_nombre() != null && !filtro.getTxt_nombre().isEmpty()) {
			predicados.add(cb.like(root.get("txt_nombre"), "%" + filtro.getTxt_nombre() + "%"));
		}
		
		if(filtro.getTxt_ape_paterno() != null && !filtro.getTxt_ape_paterno().isEmpty()) {
			predicados.add(cb.like(root.get("txt_ape_paterno"), "%" + filtro.getTxt_ape_paterno() + "%"));
		}
		if(filtro.getTxt_ape_materno() != null && !filtro.getTxt_ape_materno().isEmpty()) {
			predicados.add(cb.like(root.get("txt_ape_materno"), "%" + filtro.getTxt_ape_materno() + "%"));
		}
		
		if(filtro.getTxt_correo() != null && !filtro.getTxt_correo().isEmpty()) {
			predicados.add(cb.like(root.get("txt_correo"), "%" + filtro.getTxt_correo() + "%"));
		}
		
		if(filtro.getTxt_curp() != null && !filtro.getTxt_curp().isEmpty()) {
			predicados.add(cb.like(root.get("txt_curp"), "%" + filtro.getTxt_curp() + "%"));
		}
		
		if (filtro.getPk_grupo() != null ) {
			
			predicados.add(cb.equal(root.get("pk_grupo"), filtro.getPk_grupo()));
		}
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		cq.orderBy(cb.asc(root.get("pk_alumno")));
		
		CriteriaQuery<Alumno> select= cq.select(root);
		
		TypedQuery<Alumno> typedQuery= em.createQuery(select);
		
		List<Alumno> lista= typedQuery.getResultList();
		
		Response<Alumno> response= new Response<Alumno>();
		
		if (!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		}else {
			response.setMessage("Sin resultados");
			response.setStatus("OK");
		}
				
		return response;
	}
}
