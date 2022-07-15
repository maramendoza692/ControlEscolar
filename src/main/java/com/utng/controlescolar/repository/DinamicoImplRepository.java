package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.service.IDinamicoService;


@Repository
public class DinamicoImplRepository implements IDinamicoService  {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Ciclo> consultaDinamica(Set<String> nombres, Set<String> claves) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ciclo> query = cb.createQuery(Ciclo.class);
        Root<Ciclo> ciclo = query.from(Ciclo.class);
        
        //Path para obtener los campos nombre y clave.
        Path<String> nombrePath = ciclo.get("nombre");
        Path<String> clavePath = ciclo.get("clave");
        

        List<Predicate> predicates = new ArrayList<>();
        for (String nombre : nombres) {
            predicates.add(cb.like(nombrePath, nombre));
        }
        
        for (String clave : claves) {
            predicates.add(cb.like(clavePath, clave));
        }
        
        query.select(ciclo)
            .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        
        	List<Ciclo> lista = entityManager.createQuery(query)
            .getResultList();
        
        
        	return lista;
	}

}
