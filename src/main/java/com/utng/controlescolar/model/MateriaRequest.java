package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaRequest {

	private Integer pk_materia;
	
	private String txt_clave;
	
	private String des_materia;
	
	private Status fk_status;

	private Integer cicloNombre;
}
