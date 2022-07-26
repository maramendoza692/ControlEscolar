package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorRequest {
private Integer pk_profesor;
	

	private String txt_clave;
	
	private String txt_nombre;
	
	private String txt_ape_paterno;
	
	private String txt_ape_materno;
	
	private String txt_correo;
	
	//private Integer fk_gr_mt;
}
