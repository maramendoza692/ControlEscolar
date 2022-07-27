package com.utng.controlescolar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	     
	@Query("Select a from Grupo a where a.descGrupo = ?1 ")
	Optional<Grupo> consultarGrupo(String descGrupo);

	@Query("select a from Grupo a where a.descGrupo = ?1")
	Optional<Grupo> consultarPorNombre2(@Param("descGrupo") String descGrupo);
}
