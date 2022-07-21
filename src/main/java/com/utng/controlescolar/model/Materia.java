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
@Table(name = "MASTER_TBL_MATERIA")
public class Materia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1621629549106251392L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_MATERIA")
	private Integer pk_materia;
	
	@Column(name= "TXT_CLAVE")
	private String txt_clave;
	
	@Column(name= "DESC_MATERIA")
	private String des_materia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_STATUS")
	private Status fk_status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "ID_CICLO")
	private Ciclo ciclo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_PROMEDIO")
	private Calificaciones fk_promedio;
	
	
}
