package com.utng.controlescolar.service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriasAluRequest;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.Response;

public interface IAlumnoService {

	Response<Alumno> consultarTodos();
	
	Response<Alumno> buscarAlumno(AlumnoFiltroRequest filtro);
	
	Response<Alumno> guardarAlumno(AlumnoRequest alumno);
	
	Response<Integer> elimianarAlumno(Integer pk_alumno);
	
	Response<Alumno> actualizarAlumno(AlumnoRequest alumno);

	Response<Object[]> buscarAlumnoId(Integer pk_alumno);

	Response<Object[]> detallesAlumno();

	


}

