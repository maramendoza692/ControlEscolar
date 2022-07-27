package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequest {

	private Integer idAlumno;

	private String expediente;

	private String nombre;
	
	private String apePaterno;
	
	private String apeMaterno;

	private String curp;

	private String sexo;

	private String correo;
	
	//private Integer grupoClave;
	
	private Integer idStatus;

	private String status;

	//private Grupo pk_grupo;
	
	private String descGrupo;
	
}
