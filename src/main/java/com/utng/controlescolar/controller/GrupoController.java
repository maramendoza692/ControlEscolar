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

import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.model.GrupoRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.IGrupoService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/grupo")
public class GrupoController {
	@Autowired
	private IGrupoService grupoService;
	
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Response<Grupo>> consultarTodos(){
		
		Response<Grupo> response = grupoService.consultarTodos();
		
		return new ResponseEntity<Response<Grupo>> (response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarGrupo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> guardarGrupo (@RequestBody GrupoRequest grupo){
			Response<Grupo> response = grupoService.guardarGrupo(grupo);
			return new ResponseEntity<Response <Grupo>>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/consultarGrupoPorId/{idGrupo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarGrupoPorId (@PathVariable("idGrupo") Integer idGrupo){
														//Buscar una  variable
		Response<Grupo> grupo = grupoService.buscarGrupoId(idGrupo);
		return new ResponseEntity<Response <Grupo>>(grupo, HttpStatus.OK);
	}
	@DeleteMapping(path = "/borrarGrupoPorId/{idGrupo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarGrupoPorId (@PathVariable("idGrupo") Integer idGrupo){
														//Buscar una  variable
		Response<Integer> id = grupoService.eliminarGrupo(idGrupo);
		return new ResponseEntity<Response <Integer>>(id, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarGrupo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> actualizarGrupo (@RequestBody GrupoRequest grupo){
			
			Response<Grupo> response = grupoService.actualizarGrupo(grupo);
			return new ResponseEntity<Response <Grupo>>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/consultarGrupo/{nomGrupo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Grupo>> consultarGrupo(
			@PathVariable("nomGrupo") String nomGrupo){
														
		Response<Grupo> grupo = grupoService.buscarPorNombre(nomGrupo);
		return new ResponseEntity<Response <Grupo>>(grupo, HttpStatus.OK);
	} 
	
//	@PostMapping(path = "/consultarGrupo2",
//			produces = MediaType.APPLICATION_JSON_VALUE,
//			consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Response<Grupo>> consultarGrupo2(
//			@RequestBody GrupoRequest grupo){
//		Response<Grupo> txt_desc_grupo = grupoService.buscarPorNombre(
//				grupo.getPk_grupo());
//		return new ResponseEntity<Response <Grupo>>(txt_desc_grupo, HttpStatus.OK);
//		
//	}
	
}
