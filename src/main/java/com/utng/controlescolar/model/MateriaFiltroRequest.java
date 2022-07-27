package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaFiltroRequest {

	private String clave;
	
	private String descMateria;
	
	private String cicloNombre;
	
	private Ciclo idCiclo;
}
