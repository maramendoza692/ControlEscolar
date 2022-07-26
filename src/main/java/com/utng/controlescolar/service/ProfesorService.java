package com.utng.controlescolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.GrupoMateria;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.ProfesorDTO;
import com.utng.controlescolar.model.ProfesorRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.IGrupoMateriaRepository;
import com.utng.controlescolar.repository.IProfesorRepository;

@Service
public class ProfesorService implements IProfesorService{

	@Autowired
	private IProfesorRepository iProfesorRepository;
	@Autowired
	private IGrupoMateriaRepository grupoMateriaRepository;

	@Override
	public Response<Profesor> agregar(ProfesorRequest profesor) {
		Optional<GrupoMateria> optional=grupoMateriaRepository.findById(profesor.getFk_gr_mt());
		Response<Profesor> response=new Response<Profesor>();
		GrupoMateria grupoM=null;
		Profesor profesor1=null;
		Profesor profesor2=null;
		
		if (optional.isPresent()) {
			grupoM=optional.get();
			profesor1.setFk_gr_mt(grupoM);
			//profesor1.setPk_profesor(null);
			profesor1.setTxt_ape_materno(profesor.getTxt_ape_materno());
			profesor1.setTxt_ape_paterno(profesor.getTxt_ape_paterno());
			profesor1.setTxt_clave(profesor.getTxt_clave());
			profesor1.setTxt_correo(profesor.getTxt_correo());
			profesor1.setTxt_nombre(profesor.getTxt_nombre());
			
			profesor2=iProfesorRepository.save(profesor1);
			
			response.setData(profesor2);
			response.setMessage("Exito");
			
		}
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
	
	
	


}
