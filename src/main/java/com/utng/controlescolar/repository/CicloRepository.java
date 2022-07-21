package com.utng.controlescolar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Ciclo;

public interface CicloRepository extends JpaRepository<Ciclo, Integer>{

	@Query("Select a from Ciclo a where a.txt_desc_ciclo = ?1 and a.txt_clave = ?2")
	Optional<Ciclo> consultarPorNombre(String txt_desc_ciclo, String txt_clave);
	
	@Query("select a from Ciclo a where a.txt_desc_ciclo = ?1")
	Optional<Ciclo> consultarPorNombre2(@Param("txt_desc_ciclo") String txt_desc_ciclo);

	

}
