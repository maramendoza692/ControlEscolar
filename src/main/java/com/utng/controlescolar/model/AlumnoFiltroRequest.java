package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlumnoFiltroRequest {

	private String txt_expediente;
	
	private String txt_nombre;
	
	private String txt_curp;
	
	private String txt_correo;
	
	//private String grupoClave;
	
	private Integer fk_grupo;
	
	
}
