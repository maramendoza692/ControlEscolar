package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Profesor;
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
	
	@PostMapping(path = "/guardarProfesor",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Profesor>> guardarProfesor (@RequestBody ProfesorRequest profesor){
	
		Response<Profesor> response =iProfesorService.agregar(profesor);
		return new ResponseEntity<Response<Profesor>> (response, HttpStatus.OK);
	}
}
