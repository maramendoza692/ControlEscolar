package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoRequest {
	
	private Integer pk_grupo;
	
	private String txt_desc_grupo;
	
	private Status fk_status;
	
	private Integer fk_ciclo;
}
