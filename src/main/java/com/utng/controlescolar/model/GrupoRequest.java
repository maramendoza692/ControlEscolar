package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoRequest {
	
	private Integer idGrupo;
	
	private String descGrupo;
	
	private Status status;
	
	private Integer idCiclo;
}
