package com.utng.controlescolar.model;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer pk_profesor;
	

	private String txt_clave;
	
	private String txt_nombre;
	
	private String txt_ape_paterno;
	
	private Integer txt_ape_materno;
	
	private String txt_correo;
	
	private GrupoMateria fk_gr_mt;

//	public ProfesorDTO(Profesor profe) {
//		this.pk_profesor = profe.getPk_profesor();
//		this.txt_clave =profe.getTxt_ape_paterno();
//		this.txt_nombre = profe.getTxt_nombre();
//		this.txt_ape_paterno = profe.getTxt_ape_paterno();
//		this.txt_ape_materno = profe.getTxt_ape_materno();
//		this.txt_correo = profe.getTxt_correo();
//		this.fk_gr_mt = profe.getFk_gr_mt();
//	}
	
	
	
}
