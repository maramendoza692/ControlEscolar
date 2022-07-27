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
		
		if(filtro.getExpediente() != null && !filtro.getExpediente().isEmpty()) {
									//campo que vamos a validar y valor
			predicados.add(cb.like(root.get("expediente"), "%"+ filtro.getExpediente() + "%"));
		}
		
		if(filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
			predicados.add(cb.like(root.get("nombre"), "%" + filtro.getNombre() + "%"));
		}
		
		if(filtro.getApeMaterno() != null && !filtro.getApeMaterno().isEmpty()) {
			predicados.add(cb.like(root.get("apeMaterno"), "%" + filtro.getApeMaterno() + "%"));
		}
		if(filtro.getApePaterno() != null && !filtro.getApePaterno().isEmpty()) {
			predicados.add(cb.like(root.get("apePaterno"), "%" + filtro.getApePaterno() + "%"));
		}
		
		if(filtro.getCorreo() != null && !filtro.getCorreo().isEmpty()) {
			predicados.add(cb.like(root.get("correo"), "%" + filtro.getCorreo() + "%"));
		}
		
		if(filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {
			predicados.add(cb.like(root.get("curp"), "%" + filtro.getCurp() + "%"));
		}
		
		if (filtro.getIdGrupo() != null ) {
			
			predicados.add(cb.equal(root.get("idGrupo"), filtro.getIdGrupo()));
		}
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		cq.orderBy(cb.asc(root.get("idAlumno")));
		
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
