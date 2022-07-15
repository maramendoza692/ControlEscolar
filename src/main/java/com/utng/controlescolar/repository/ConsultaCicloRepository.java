package com.utng.controlescolar.repository;

import java.sql.Date;
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

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.model.Response;

@Repository
public class ConsultaCicloRepository implements IConsultaCicloRepository{
	
	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<Ciclo> busquedaCiclo(CicloFiltroRequest filtro) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		// <Materia> retornar materia
		CriteriaQuery<Ciclo> cq = cb.createQuery(Ciclo.class);

		Root<Ciclo> root = cq.from(Ciclo.class);
		// Predicate es como un where, es decir, condicicón.
		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getTxt_clave() != null && !filtro.getTxt_clave().isEmpty()) {
			// campo que vamos a validar y valor
			predicados.add(cb.like(root.get("clave"), "%" + filtro.getTxt_clave() + "%"));
		}

		if (filtro.getTxt_desc_ciclo() != null && !filtro.getTxt_desc_ciclo().isEmpty()) {
			predicados.add(cb.like(root.get("nombre"), "%" + filtro.getTxt_desc_ciclo() + "%"));
			// cq.select(root).where(predicados.toArray(new Predicate[predicados.size()]));
		}
		if (filtro.getYear() != null && !filtro.getYear().isEmpty()) {
			String fechaEnero = filtro.getYear() + "-01-01";
			String fechaDiciembre = filtro.getYear() + "-12-31";
			Date fechaEn = Date.valueOf(fechaEnero);
			Date fechaDic = Date.valueOf(fechaDiciembre);

			predicados.add(cb.between(root.get("dat_fecha_inicio"), fechaEn, fechaDic));
		}

		if (!predicados.isEmpty()) {
			Predicate[] pr = new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}

		cq.orderBy(cb.desc(root.get("pk_ciclo")));

		CriteriaQuery<Ciclo> select = cq.select(root);

		TypedQuery<Ciclo> typedQuery = em.createQuery(select);

		List<Ciclo> lista = typedQuery.getResultList();
		Response<Ciclo> response = new Response<Ciclo>();
		if (!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		} else {
			response.setStatus("ERROR");
			response.setMessage("Consulta fallida");
		}

		return response;
	}

}
