package com.utng.controlescolar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.DinamicoImplRepository;

@Service
public class DinamicoService implements IDinamicoService {

	@Autowired
	private DinamicoImplRepository dinamicoImplRepository;

	
	@Override
	public List<Ciclo> consultaDinamica(Set<String> nombre, Set<String> clave) {
		
		Response<Ciclo> response = new Response<Ciclo>();
		
		List<Ciclo> lista = dinamicoImplRepository.consultaDinamica(nombre, clave);
		
		response.setCount(lista.size());
		response.setList(lista);
		response.setStatus("OK");
		response.setMessage("Consulta correcta :3");
		
		return lista;
	}

	
	
}
