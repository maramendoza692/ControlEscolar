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

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.IMateriaService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/materia")
public class MateriaController {
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response<Materia>> consultarTodos(){
		

		Response<Materia> response = materiaService.consultarTodos();
		
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Materia>> guardarMateria (@RequestBody MateriaRequest materia){
	
		Response<Materia> response = materiaService.guardarMateria(materia);
		return new ResponseEntity<Response<Materia>> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/consultarMateriaPorId/{idMateria}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarMateriaPorId (@PathVariable("idMateria") Integer idMateria){
																	//Buscar una  variable
		Response<Materia> materia = materiaService.buscarMateriaId(idMateria);
		return new ResponseEntity<Response <Materia>>(materia, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/borrarMateriaPorId/{idMateria}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarMateriaPorId (@PathVariable("idMateria") Integer idMateria){
		Response<Integer> id = materiaService.eliminarMateria(idMateria);
		return new ResponseEntity<Response <Integer>>(id, HttpStatus.OK);
	}
	
	@GetMapping(path = "/consultarPorNombreClave/{nombre}/{clave}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarPorNombreClave (
			@PathVariable("nombre") String nombre,
			@PathVariable("clave") String clave){
														
		Response<Materia> materia = materiaService.buscarPorNombre2(nombre, clave);
		return new ResponseEntity<Response <Materia>>(materia, HttpStatus.OK);
	} 
	
	@PutMapping(path = "/actualizarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Materia>> actualizarMateria (@RequestBody MateriaRequest materia){
	
		Response<Materia> materiaModificada = materiaService.actualizarMateria(materia);
		return new ResponseEntity<Response<Materia>> (materiaModificada, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarPorNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> consultarPorNombre(@PathVariable("nombre") String nombre) {
		Response<Materia> response = materiaService.buscarPorNombre(nombre);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/buscarMateriaFiltro", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Materia>> guardarMateria(
			@RequestBody MateriaFiltroRequest filtro) {
		Response<Materia> response = materiaService.buscarMateriaFiltro(filtro);
		return new ResponseEntity<Response<Materia>>(response, HttpStatus.OK);
	}

	
	
}
