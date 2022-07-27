package com.utng.controlescolar.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer>{
	
	@Query("Select a from Materia a where a.descMateria = ?1 ")
	Optional<Materia> consultarPorNombre(String nombre);
	
	@Query("Select a from Materia a where a.descMateria = :descMateria and a.clave = :clave")
	Optional<Materia> consultarPorNombre2(@Param("descMateria") String descMateria, @Param("clave") String clave);

}

