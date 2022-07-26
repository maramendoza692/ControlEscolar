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
		//Response<Profesor> response= null;
		
		
		
		//Profesor pro=iProfesorRepository.save(profesor);
		//Profesor profesor=new Profesor(profesor);
		//response.setData(pro);
		return response;
	}
	//RespoAlumnoumno> response = new Response<Alumno>();
//	
//	Optional <Grupo> optionalGrupo = grupoRepository.consultarPorNombre2(alumno.getTxt_desc_grupo());
//	Grupo grupo = null;
//	Alumno alumno1 = null;
//	Alumno alumno2 = null;
//	
//	if (optionalGrupo.isPresent()) {
//		grupo = optionalGrupo.get();
//		alumno1 = new Alumno();
//		alumno1.setTxt_expediente(alumno.getTxt_expediente());
//		alumno1.setPk_grupo(grupo);
//		alumno1.setTxt_nombre(alumno.getTxt_nombre());
//		alumno1.setTxt_ape_paterno(alumno.getTxt_ape_paterno());
//		alumno1.setTxt_ape_materno(alumno.getTxt_ape_materno());
//		alumno1.setTxt_sexo(alumno.getTxt_sexo());
//		alumno1.setFk_status(alumno.getFk_status());
//		alumno1.setTxt_correo(alumno.getTxt_correo());
//		alumno1.setTxt_curp(alumno.getTxt_curp());
//		
//		
//		alumno2 = alumnoRepository.save(alumno1);//Meter en el objeto materia2, ya con el Id pq va alrepository y guarda materia1, 
//		
//		response.setStatus("OK");
//		response.setMessage("Guardado correctamente");
//		response.setData(alumno2);
//	}else {
//		response.setStatus("ERROR");
//		response.setMessage("El grupo no existe");
//		response.setData(null);
//	}
//	
//	return response;

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
