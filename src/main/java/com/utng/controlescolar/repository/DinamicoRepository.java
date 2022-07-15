package com.utng.controlescolar.repository;

import java.util.Optional;
import java.util.Set;


import com.utng.controlescolar.model.Ciclo;

public interface DinamicoRepository  {

	Optional<Ciclo> dinamicoCiclo(Set<String> nombre);
	
}
