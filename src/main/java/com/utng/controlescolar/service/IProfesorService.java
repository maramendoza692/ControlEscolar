package com.utng.controlescolar.service;

import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.ProfesorDTO;
import com.utng.controlescolar.model.ProfesorRequest;
import com.utng.controlescolar.model.Response;

public interface IProfesorService {
	public Response<Profesor> agregar(ProfesorRequest profesor);
	
	public Response<Profesor> editar(Profesor profesor);
	
	public Response<Profesor> eliminar(Integer id);
}
