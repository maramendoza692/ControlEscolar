package com.utng.controlescolar.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer>{
	
	@Query("Select a from Materia a where a.des_materia = ?1 ")
	Optional<Materia> consultarPorNombre(String nombre);
	
	@Query("Select a from Materia a where a.des_materia = :des_materia and a.txt_clave = :txt_clave")
	Optional<Materia> consultarPorNombre2(@Param("des_materia") String des_materia, @Param("txt_clave") String txt_clave);

}

