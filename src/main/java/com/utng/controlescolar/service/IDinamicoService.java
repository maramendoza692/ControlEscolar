package com.utng.controlescolar.service;


import java.util.List;
import java.util.Set;

import com.utng.controlescolar.model.Ciclo;
//import com.utng.controlescolar.repository.Response;

public interface IDinamicoService {

	List<Ciclo> consultaDinamica(Set<String> nombre , Set<String> clave);
	
}
