package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.AlumnoRepository;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.ConsultaAlumnoRepository;
import com.utng.controlescolar.repository.GrupoRepository;

@Service
public class AlumnoService  implements IAlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private ConsultaAlumnoRepository consultaAlumnoRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Override
	public Response<Alumno> consultarTodos() {
		
		Response<Alumno> response = new Response<Alumno>();
		List<Alumno> lista = alumnoRepository.findAll();
		
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
	public Response<Alumno> buscarAlumno(AlumnoFiltroRequest alumno) {
		
		Optional<Grupo> optional = grupoRepository.consultarPorNombre2(alumno.getTxt_desc_grupo());
		Grupo grupo = null;
		
		if (optional.isPresent()) {
			grupo = optional.get();
			alumno.setPk_grupo(grupo);
		}
		
		Response<Alumno> response = new Response<Alumno>();
		response = consultaAlumnoRepository.busquedaAlumno(alumno);
		
		return response;
	}


	/*@Override
	public Response<Alumno> guardarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Alumno alumnoGuardar = alumnoRepository.save(alumno);
		response.setMessage("Guardado correctamente");
			response.setData(alumno);
			
		return response;
	}*/
	
	public Response<Alumno> guardarAlumno(AlumnoRequest alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Optional <Grupo> optionalGrupo = grupoRepository.consultarPorNombre2(alumno.getTxt_desc_grupo());
		Grupo grupo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;
		
		if (optionalGrupo.isPresent()) {
			grupo = optionalGrupo.get();
			alumno1 = new Alumno();
			alumno1.setTxt_expediente(alumno.getTxt_expediente());
			alumno1.setPk_grupo(grupo);
			alumno1.setTxt_nombre(alumno.getTxt_nombre());
			alumno1.setTxt_ape_paterno(alumno.getTxt_ape_paterno());
			alumno1.setTxt_ape_materno(alumno.getTxt_ape_materno());
			alumno1.setTxt_sexo(alumno.getTxt_sexo());
			alumno1.setFk_status(alumno.getFk_status());
			alumno1.setTxt_correo(alumno.getTxt_correo());
			alumno1.setTxt_curp(alumno.getTxt_curp());
			
			
			alumno2 = alumnoRepository.save(alumno1);//Meter en el objeto materia2, ya con el Id pq va alrepository y guarda materia1, 
			
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(alumno2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El grupo no existe");
			response.setData(null);
		}
		
		return response;
	}


	@Override
	public Response<Integer> elimianarAlumno(Integer pk_alumno) {
		Response<Integer> response = new Response<Integer>();
		alumnoRepository.deleteById(pk_alumno);
		
		response.setMessage("Eliminado correctamente");
		response.setStatus("OK");
		response.setData(pk_alumno);
		
		return response;
	}


	@Override
	public Response<Alumno> actualizarAlumno(AlumnoRequest alumno) {
Response<Alumno> response = new Response<Alumno>();
		
		Optional <Grupo> optionalGrupo = grupoRepository.consultarPorNombre2(alumno.getTxt_desc_grupo());
		Grupo grupo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;
		
		if (optionalGrupo.isPresent()) {
			grupo = optionalGrupo.get();
			alumno1 = new Alumno();
			alumno1.setTxt_expediente(alumno.getTxt_expediente());
			alumno1.setPk_alumno(alumno.getPk_alumno());
			alumno1.setPk_grupo(grupo);
			alumno1.setTxt_nombre(alumno.getTxt_nombre());
			alumno1.setTxt_ape_paterno(alumno.getTxt_ape_paterno());
			alumno1.setTxt_ape_materno(alumno.getTxt_ape_materno());
			alumno1.setTxt_sexo(alumno.getTxt_sexo());
			alumno1.setFk_status(alumno.getFk_status());
			alumno1.setTxt_correo(alumno.getTxt_correo());
			alumno1.setTxt_curp(alumno.getTxt_curp());
			
			
			alumno2 = alumnoRepository.save(alumno1);//Meter en el objeto materia2, ya con el Id pq va alrepository y guarda materia1, 
			
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(alumno2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El grupo no existe");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public Response<Object[]> buscarAlumnoId(Integer pk_alumno) {
		Response<Object[]> response = new Response<Object[]>();

		List<Object[]> lista = alumnoRepository.mostrarDetallesAlumnoID(pk_alumno);
		
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
	public Response<Object[]> detallesAlumno() {
		
		Response<Object[]> response = new Response<Object[]>();
		List<Object[]> lista = alumnoRepository.mostrarDetallesAlumno();
		
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
	

}



