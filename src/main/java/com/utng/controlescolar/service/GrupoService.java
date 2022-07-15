package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.GrupoRepository;

@Service
public class GrupoService implements IGrupoService{

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CicloRepository cicloRepository;
	
	@Override
	public Response<Grupo> consultarTodos() {
		Response<Grupo> response = new Response<Grupo>();
		List<Grupo> lista = grupoRepository.findAll();
		
		if(lista.isEmpty()) {
			response.setMessage("No hay resultados");
			
		}else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}

	@Override
	public Response<Grupo> guardarGrupo(GrupoRequest grupo) {
		Response<Grupo> response = new Response<Grupo>();
		
		Optional <Ciclo> optionalCiclo = cicloRepository.findById(grupo.getFk_ciclo());
		Ciclo ciclo = null;
		Grupo grupo1 = null;
		Grupo grupo2 = null;
		
		if (optionalCiclo.isPresent()) {
			ciclo = optionalCiclo.get();
			grupo1 = new Grupo();
			grupo1.setTxt_desc_grupo(grupo.getTxt_desc_grupo());
			grupo1.setFk_ciclo(ciclo);
			grupo1.setFk_status(grupo.getFk_status());
			grupo2 = grupoRepository.save(grupo1);
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(grupo2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El ciclo no existe");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public Response<Grupo> buscarGrupoId(Integer idGrupo) {
		Response<Grupo> response = new Response<Grupo>();
		Grupo grupo = null;
		Optional<Grupo> optional = grupoRepository.findById(idGrupo);
		
		if(optional.isPresent()) {
			grupo = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(grupo);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Integer> eliminarGrupo(Integer idGrupo) {
		Response<Integer> response = new Response<Integer>();
		grupoRepository.deleteById(idGrupo);
		
		response.setMessage("Eliminado correctamente");
		response.setStatus("OK");
		response.setData(idGrupo);
		
		return response;
	}

	@Override
	public Response<Grupo> buscarPorNombre(String txt_desc_grupo) {
		Response<Grupo> response = new Response<Grupo>();
		Grupo grupo = null;
		Optional<Grupo> optional = grupoRepository.consultarGrupo(txt_desc_grupo);
		
		if(optional.isPresent()) {
			grupo = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(grupo);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Grupo> actualizarGrupo(GrupoRequest grupo) {
		Response<Grupo> response = new Response<Grupo>();
		
		Optional <Ciclo> optionalCiclo = cicloRepository.findById(grupo.getFk_ciclo());
		Ciclo ciclo = null;
		Grupo grupo1 = null;
		Grupo grupo2 = null;
		
		if (optionalCiclo.isPresent()) {
			ciclo = optionalCiclo.get();
			grupo1 = new Grupo();
			grupo1.setPk_grupo(grupo.getPk_grupo());
			grupo1.setTxt_desc_grupo(grupo.getTxt_desc_grupo());
			grupo1.setFk_ciclo(ciclo);
			grupo1.setFk_status(grupo.getFk_status());
			grupo2 = grupoRepository.save(grupo1);
			response.setStatus("OK");
			response.setMessage("Actualizado correctamente");
			response.setData(grupo2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("No fue posible actualizar");
			response.setData(null);
		}
		
		return response;
	}
	
	/*@Override
	public Response<Grupo> actualizarGrupo(Grupo grupo) {
		Response<Grupo> response = new Response<Grupo>();
		Grupo grupoNuevo =  grupoRepository.save(grupo);
		
		response.setMessage("Actualizado correctamente");
		response.setStatus("OK");
		response.setData(grupoNuevo);
		
		return response;
	}*/
}

