package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
}
