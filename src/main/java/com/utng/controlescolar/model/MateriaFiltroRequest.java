package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaFiltroRequest {

	private String txt_clave;
	
	private String desc_materia;
	
	private String cicloNombre;
	
	private Ciclo fk_ciclo;
}
