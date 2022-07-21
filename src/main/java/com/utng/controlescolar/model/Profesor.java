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
@Table(name = "MASTER_TBL_PROFESOR")
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758222377978623282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_PROFESOR")
	private Integer pk_profesor;
	
	@Column(name= "TXT_CLAVE")
	private String txt_clave;
	
	@Column(name= "TXT_NOMBRE")
	private String txt_nombre;
	
	@Column(name= "TXT_APE_PATERNO")
	private String txt_ape_paterno;
	
	@Column(name= "TXT_APE_MATERNO")
	private Integer txt_ape_materno;
	
	@Column(name= "TXT_CORREO")
	private String txt_correo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_GR_MT")
	private GrupoMateria fk_gr_mt;

}
