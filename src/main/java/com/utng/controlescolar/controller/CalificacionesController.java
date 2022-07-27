package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificaciones;

import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.ICalificacionesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calificaciones")
public class CalificacionesController {
	@Autowired
	private ICalificacionesService calificacionesService;

	@PostMapping(path = "/guardarCalificaciones",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Calificaciones>> guardarCiclo (@RequestBody Calificaciones calificacion){
												//Guardar un JSON, seleccioanar import de spring y no de swagger
		Response<Calificaciones> calificacionesNuevo = calificacionesService.guardarCalificacion(calificacion);
		return new ResponseEntity<Response <Calificaciones>>(calificacionesNuevo, HttpStatus.OK);
	}
	@PutMapping(path = "/actualizarCalificaciones",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Calificaciones>> actualizarCiclo (@RequestBody Calificaciones calificacion){
			
			Response<Calificaciones> calificacionesModificado = calificacionesService.actualizarCalificacion(calificacion);
			return new ResponseEntity<Response <Calificaciones>>(calificacionesModificado, HttpStatus.OK);
		}
	

	@GetMapping(path = "/consultarCalificacionesId/{pk_calificaciones}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Calificaciones>> consultarCalificacionesPorID (@PathVariable("pk_calificacion") Integer pk_calificacion){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Calificaciones> response = calificacionesService.buscarCalificacionesId(pk_calificacion);
		
		return new ResponseEntity<Response<Calificaciones>> (response,HttpStatus.OK);
		
	}
}
