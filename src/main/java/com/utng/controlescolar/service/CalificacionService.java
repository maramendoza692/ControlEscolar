package com.utng.controlescolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificaciones;

import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.CalificacionesRepository;

@Service
public class CalificacionService implements ICalificacionesService{

	@Autowired
	private CalificacionesRepository calificacionesRepository;
	
	@Override
	public Response<Calificaciones> guardarCalificacion(Calificaciones calificacion) {
		Response<Calificaciones> response = new Response<Calificaciones>();
		Calificaciones calificacionesNuevo =  calificacionesRepository.save(calificacion);
		
		response.setMessage("Guardado correctamente");
		response.setStatus("OK");
		response.setData(calificacionesNuevo);
	
		return response;
	}

	@Override
	public Response<Calificaciones> actualizarCalificacion(Calificaciones calificacion) {
		Response<Calificaciones> response = new Response<Calificaciones>();
		Calificaciones CalificacionesNuevo =  calificacionesRepository.save(calificacion);
		
		response.setMessage("Actualizado correctamente");
		response.setStatus("OK");
		response.setData(CalificacionesNuevo);
		
		return response;
	}
	
	@Override
	public Response<Calificaciones> buscarCalificacionesId(Integer pk_calificacion) {
		Response<Calificaciones> response = new Response<Calificaciones>();

		Calificaciones calificaciones = null;

		Optional<Calificaciones> optional = calificacionesRepository.findById(pk_calificacion); // optional es una capsula para saber si regreso o
																		// no un registro
		if (optional.isPresent()) {

			calificaciones = optional.get();
			calificaciones = optional.get();
			response.setStatus("OK");
			response.setMessage("Busqueda correcta");
			response.setData(calificaciones);

		} else {

			response.setMessage("Sin resultados");
			response.setData(null);

		}

		return response;
	}


}
