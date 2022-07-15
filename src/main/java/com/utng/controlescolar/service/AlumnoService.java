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
		Response<Alumno> response = new Response<Alumno>();
		
		response = consultaAlumnoRepository.busquedaAlumno(alumno);
		
		return response;
	}


	@Override
	public Response<Alumno> guardarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Alumno alumnoGuardar = alumnoRepository.save(alumno);
		response.setMessage("Guardado correctamente");
			response.setData(alumno);
			
		return response;
	}


	@Override
	public Response<Integer> elimianarAlumno(Integer idAlumno) {
		Response<Integer> response = new Response<Integer>();
		alumnoRepository.deleteById(idAlumno);
		
		response.setMessage("Eliminado correctamente");
		response.setStatus("OK");
		response.setData(idAlumno);
		
		return response;
	}


	@Override
	public Response<Alumno> actualizarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		 Alumno alumnoAct = alumnoRepository.save(alumno);
		 response.setMessage("Guardado correctamente");
			response.setData(alumno);
		
		return response;
	}

	@Override
	public Response<Alumno> buscarAlumnoId(Integer idAlumno) {
		Response<Alumno> response = new Response<Alumno>();

		Alumno alumno = null;

		Optional<Alumno> optional = alumnoRepository.findById(idAlumno); // optional es una capsula para saber si regreso o
																		// no un registro
		if (optional.isPresent()) {

			alumno = optional.get();
			alumno = optional.get();
			response.setStatus("OK");
			response.setMessage("Busqueda correcta");
			response.setData(alumno);

		} else {

			response.setMessage("Sin resultados");
			response.setData(null);

		}

		return response;
	}
	

}



