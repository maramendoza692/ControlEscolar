package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.AlumnoFiltroRequest;
import com.utng.controlescolar.model.AlumnoRequest;

import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.IAlumnoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultartodos(){
		
		Response<Alumno> lista = alumnoService.consultarTodos();
		
		return new ResponseEntity<Response<Alumno>> (lista, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/buscarAlumnoPorID/{idAlumno}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultarAlumnoPorID (@PathVariable("idAlumno") Integer idAlumno){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Alumno> response = alumnoService.buscarAlumnoId(idAlumno);
		
		return new ResponseEntity<Response<Alumno>> (response,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Alumno>> guardarAlumno (@RequestBody Alumno alumno){
	
		Response<Alumno> response = alumnoService.guardarAlumno(alumno);
		return new ResponseEntity<Response<Alumno>> (response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/borrarAlumnoPorId/{idAlumno}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarAlumnoPorId (@PathVariable("idAlumno") Integer idAlumno){
		Response<Integer> id = alumnoService.elimianarAlumno(idAlumno);
		return new ResponseEntity<Response <Integer>>(id, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Alumno>> actualizarAlumno (@RequestBody Alumno alumno){
	
		Response<Alumno> materiaModificada = alumnoService.actualizarAlumno(alumno);
		return new ResponseEntity<Response<Alumno>> (materiaModificada, HttpStatus.OK);
	}

	@PostMapping(path = "/buscarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> buscarAlumno (
			@RequestBody AlumnoFiltroRequest filtro){
		
				Response<Alumno> response = alumnoService.buscarAlumno(filtro);
				
				return new ResponseEntity<Response<Alumno>>(response,HttpStatus.OK);
	}

}