package com.utng.controlescolar.service;


import com.utng.controlescolar.model.Calificaciones;
import com.utng.controlescolar.model.Response;

public interface ICalificacionesService {
	
	
	Response<Calificaciones> guardarCalificacion(Calificaciones calificacion);

	Response<Calificaciones> actualizarCalificacion(Calificaciones calificacion);
	
	Response<Calificaciones> buscarCalificacionesId(Integer pk_calificacion);

}
