package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "REL_TBL_GRUPO_MATERIA")
public class GrupoMateria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758222377978623282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_GR_MT")
	private Integer pk_gr_mt;
	
	
	@Column(name= "FK_GRUPO")
	private Grupo fk_grupo;
	

	@Column(name= "FK_MATERIA")
	private Materia fk_materia;
}
