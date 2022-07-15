package com.utng.controlescolar.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Ciclo;
//import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.service.IDinamicoService;

@RestController
@RequestMapping("/dinamico")
public class DinamicoController {

	@Autowired
	private IDinamicoService dinamicoService;
	
	@GetMapping(path = "/buscarCicloDinamico/{nombre}/{clave}", //esto hacee referencia a que solo uno
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ciclo> consultarCicloPorNombreClave (@PathVariable("nombre") Set<String> nombre , @PathVariable("clave")Set<String> clave){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		List<Ciclo> response = dinamicoService.consultaDinamica(nombre, clave);
		
		return response;
		
	}
	
}
