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

import com.utng.controlescolar.model.ProfesorDTO;
import com.utng.controlescolar.model.ProfesorRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.IProfesorService;

@RestController
@RequestMapping("/profesor")
@CrossOrigin("*")
public class ProfesorController {

	@Autowired
	private IProfesorService iProfesorService;
	
	/*
	 * Metodo para agregar nuevos maestros
	 */
	@PostMapping(path = "/guardarProfesor",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <ProfesorDTO>> guardarProfesor (@RequestBody ProfesorRequest profesor){
	
		Response<ProfesorDTO> response =iProfesorService.agregar(profesor);
		return new ResponseEntity<Response<ProfesorDTO>> (response, HttpStatus.OK);
	}
	/*
	 * Metodo para conultar todos los registroa que se encuentra en la base de datos
	 */
	@GetMapping("/consultar-todos")
	public ResponseEntity<Response<ProfesorDTO>> consultarTodos(){
		Response<ProfesorDTO> response=iProfesorService.consultarTodos();
		return new ResponseEntity<Response<ProfesorDTO>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/actualizarProfesor")
	public ResponseEntity <Response<ProfesorDTO>>actualizar(@RequestBody ProfesorRequest profesor){
		Response<ProfesorDTO> actualizarProfesor =  iProfesorService.editar(profesor);
		return new ResponseEntity<Response<ProfesorDTO>>(actualizarProfesor, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarProfesor/{id}")
	public ResponseEntity <Response<Integer>> eliminarProfesor(@PathVariable Integer id){
		Response<Integer> eliminarProfesor =  iProfesorService.eliminar(id);
		return new ResponseEntity<Response<Integer>>(eliminarProfesor, HttpStatus.OK);
		
	}
	
	
}
