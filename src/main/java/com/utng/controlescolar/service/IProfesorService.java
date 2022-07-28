package com.utng.controlescolar.service;

import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.ProfesorDTO;
import com.utng.controlescolar.model.ProfesorRequest;
import com.utng.controlescolar.model.Response;

public interface IProfesorService {
	public Response<ProfesorDTO> agregar(ProfesorRequest profesor);
	
	public Response<ProfesorDTO> editar(ProfesorRequest profesor);
	
	public Response<Integer> eliminar(Integer id);
	
	public Response<ProfesorDTO> consultarTodos();
}
