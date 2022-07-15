package com.utng.controlescolar.controller;

//import java.util.List;

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

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.model.CicloRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.ICicloService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ciclo")
public class CicloController {
	
	@Autowired
	private ICicloService cicloService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarTodos(){
		
		
		Response<Ciclo> response = cicloService.consultarTodos();
		
		return new ResponseEntity<Response<Ciclo>> (response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/guardarCiclo",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> guardarCiclo (@RequestBody Ciclo ciclo){
												//Guardar un JSON, seleccioanar import de spring y no de swagger
		Response<Ciclo> cicloNuevo = cicloService.guardarCiclo(ciclo);
		return new ResponseEntity<Response <Ciclo>>(cicloNuevo, HttpStatus.OK);
	}
	
	@PostMapping(path = "/consultarPorNombreClave2",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarPorNombreClave2(
			@RequestBody CicloRequest ciclo){
		Response<Ciclo> cicloNuevo = cicloService.buscarPorNombreClave(
				ciclo.getTxt_desc_ciclo(), ciclo.getTxt_clave());
		return new ResponseEntity<Response <Ciclo>>(cicloNuevo, HttpStatus.OK);
		
	}
	
	
	@GetMapping(path = "/consultarCicloPorId/{idCiclo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarCicloPorId (@PathVariable("idCiclo") Integer idCiclo){
														//Buscar una  variable
		Response<Ciclo> ciclo = cicloService.buscarCicloId(idCiclo);
		return new ResponseEntity<Response <Ciclo>>(ciclo, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/borrarCicloPorId/{idCiclo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarCicloPorId (@PathVariable("idCiclo") Integer idCiclo){
														//Buscar una  variable
		Response<Integer> id = cicloService.eliminarCiclo(idCiclo);
		return new ResponseEntity<Response <Integer>>(id, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarCiclo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> actualizarCiclo (@RequestBody Ciclo ciclo){
			
			Response<Ciclo> cicloModificado = cicloService.actualizarCiclo(ciclo);
			return new ResponseEntity<Response <Ciclo>>(cicloModificado, HttpStatus.OK);
		}
	
	@GetMapping(path = "/consultarPorNombreClave/{nombre}/{clave}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> consultarPorNombreClave (
			@PathVariable("nombre") String nombre,
			@PathVariable("clave") String clave){
														
		Response<Ciclo> ciclo = cicloService.buscarPorNombreClave(nombre, clave);
		return new ResponseEntity<Response <Ciclo>>(ciclo, HttpStatus.OK);
	} 
	
	@PostMapping(path = "/buscarCiclo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Ciclo>> buscarCiclo (
			@RequestBody CicloFiltroRequest filtro){
				
				Response<Ciclo> response = cicloService.buscarCiclo(filtro);
				
				return new ResponseEntity<Response<Ciclo>>(response,HttpStatus.OK);
			
	} 
	
}
