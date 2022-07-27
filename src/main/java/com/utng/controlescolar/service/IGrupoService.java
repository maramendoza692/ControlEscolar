package com.utng.controlescolar.service;

import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.model.Response;

public interface IGrupoService {

	Response<Grupo> consultarTodos();
	
	Response<Grupo> guardarGrupo(GrupoRequest grupo);
	
	Response<Grupo> buscarGrupoId(Integer idGrupo);
	
	Response<Integer> eliminarGrupo (Integer idGrupo); 
	
	Response<Grupo> actualizarGrupo(GrupoRequest grupo);
	
	Response<Grupo> buscarPorNombre(String descGrupo);
}
