package com.utng.controlescolar.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.GrupoMateria;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.ProfesorDTO;
import com.utng.controlescolar.model.ProfesorRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.IProfesorRepository;

@Service
public class ProfesorService implements IProfesorService{

	@Autowired
	private IProfesorRepository iProfesorRepository;
//	@Autowired
//	private IGrupoMateriaRepository grupoMateriaRepository;

	@Override
	public Response<ProfesorDTO> agregar(ProfesorRequest profesor) {
//		Optional<GrupoMateria> optional=grupoMateriaRepository.findById(profesor.getFk_gr_mt());
		Response<ProfesorDTO> response=new Response<ProfesorDTO>();
		GrupoMateria grupoM=null;
		Profesor profesor1=null;
		Profesor profesor2=null;
		ProfesorDTO profesorDto=null;
		
//		if (optional.isPresent()) {
//			grupoM=optional.get();
			profesor1= new Profesor();
//			profesor1.setFk_gr_mt(grupoM);
			//profesor1.setPk_profesor(null);
			profesor1.setTxt_ape_materno(profesor.getTxt_ape_materno());
			profesor1.setTxt_ape_paterno(profesor.getTxt_ape_paterno());
			profesor1.setTxt_clave(profesor.getTxt_clave());
			profesor1.setTxt_correo(profesor.getTxt_correo());
			profesor1.setTxt_nombre(profesor.getTxt_nombre());
			
			profesor2=iProfesorRepository.save(profesor1);
			profesorDto=new ProfesorDTO(profesor2);
			response.setData(profesorDto);
			response.setMessage("Exito");
			
//		}
		return response;
	}

	@Override
	public Response<Profesor> editar(Profesor profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Profesor> eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<ProfesorDTO> consultarTodos() {
		Response<ProfesorDTO> response=new Response<ProfesorDTO>();
		List<Profesor> lista= iProfesorRepository.findAll();
		
		List<ProfesorDTO> listaDto=new ArrayList<ProfesorDTO>();
		/*
		 * Funcion: Convierte una lista de profesores a una lista de profesores DTO
		 */
		for(Profesor profesorList: lista) {
			listaDto.add(new ProfesorDTO(profesorList));
		}
		
		response.setList(listaDto);
		response.setCount(listaDto.size());
		response.setMessage("Consulta correcta");
		response.setStatus("OK");
		
		
		return response;
	}
	
	
	


}
