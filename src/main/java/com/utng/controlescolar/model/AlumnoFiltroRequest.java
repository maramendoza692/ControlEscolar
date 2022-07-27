package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlumnoFiltroRequest {

	private String expediente;
	
	private String nombre;
	
	private String apePaterno;
	
	private String apeMaterno;
	
	private String curp;
	
	private String correo;
	
	private String descGrupo;
	
	private Grupo idGrupo;
	
}
