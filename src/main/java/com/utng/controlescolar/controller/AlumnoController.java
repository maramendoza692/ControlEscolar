package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

@CrossOrigin(origins = "*")
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
	
	@PostMapping(path = "/guardarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Alumno>> guardarAlumno (@RequestBody AlumnoRequest alumno){
	
		Response<Alumno> response = alumnoService.guardarAlumno(alumno);
		return new ResponseEntity<Response<Alumno>> (response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/borrarAlumnoPorId/{pk_alumno}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarAlumnoPorId (@PathVariable("pk_alumno") Integer idAlumno){
		Response<Integer> pk = alumnoService.elimianarAlumno(idAlumno);
		return new ResponseEntity<Response <Integer>>(pk, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Alumno>> actualizarAlumno (@RequestBody AlumnoRequest alumno){
	
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
	
	@GetMapping(path = "/consultarAlumnoPorID/{pk_alumno}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Alumno>> consultarAlumnoPorID (@PathVariable("pk_alumno") Integer pk_alumno){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Alumno> response = alumnoService.buscarAlumnoId(pk_alumno);
		
		return new ResponseEntity<Response<Alumno>> (response,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/consultarMateriasAlumno/{pk_alumno}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Object[]>> mostrarMateriasAlumnoId (@PathVariable("pk_alumno") Integer pk_alumno){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Object[]> response = alumnoService.mostrarMateriasAlumnoId(pk_alumno);
		
		return new ResponseEntity<Response<Object[]>> (response,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/detallesAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Object[]>> detallesAlumno(){
		
		Response<Object[]> lista = alumnoService.detallesAlumno();
		
		return new ResponseEntity<Response<Object[]>> (lista, HttpStatus.OK);
		
	}

}
