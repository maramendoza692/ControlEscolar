package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequest {

	private Integer pk_alumno;

	private String txt_expediente;

	private String txt_nombre;
	
	private String txt_ape_paterno;
	
	private String txt_ape_materno;

	private String txt_curp;

	private String txt_sexo;

	private String correo;
	
	//private Integer grupoClave;
	
	private Integer fk_status;

	private Integer fk_grupo;
	
}
