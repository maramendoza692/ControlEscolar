package com.utng.controlescolar.service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.model.Response;

public interface IAlumnoService {

	Response<Alumno> consultarTodos();
	
	Response<Alumno> buscarAlumno(AlumnoFiltroRequest filtro);
	
	Response<Alumno> guardarAlumno(Alumno alumno);
	
	Response<Integer> elimianarAlumno(Integer idAlumno);
	
	Response<Alumno> actualizarAlumno(Alumno alumno);

	Response<Alumno> buscarAlumnoId(Integer idAlumno);

	


}

