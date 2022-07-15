package com.utng.controlescolar.repository;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.Response;

public interface IConsultaAlumnoRepository {

	Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro);
}
