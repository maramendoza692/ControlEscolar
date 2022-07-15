package com.utng.controlescolar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CAT_TBL_CICLO_PROMEDIO")
public class Promedio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2437113779874596113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_PROMEDIO")
	private Integer pk_promedio;
	
	@Column(name= "NUM_CAL_1")
	private Integer num_cal_1;
	
	@Column(name= "NUM_CAL_2")
	private Integer num_cal_2;
	
	@Column(name= "NUM_CAL_3")
	private Integer num_cal_3;
	
	@Column(name= "NUM_PROMEDIO")
	private Integer num_promedio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_ALUMNO")
	private Alumno fk_alumno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_MATERIA")
	private Materia fk_materia;
	
}
