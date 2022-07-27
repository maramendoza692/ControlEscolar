package com.utng.controlescolar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Ciclo;

public interface CicloRepository extends JpaRepository<Ciclo, Integer>{

	@Query("Select a from Ciclo a where a.descCiclo = ?1 and a.clave = ?2")
	Optional<Ciclo> consultarPorNombre(String descCiclo, String clave);
	
	@Query("select a from Ciclo a where a.descCiclo = ?1")
	Optional<Ciclo> consultarPorNombre2(@Param("descCiclo") String descCiclo);

	

}
