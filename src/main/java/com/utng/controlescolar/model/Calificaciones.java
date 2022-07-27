package com.utng.controlescolar.model;

import java.io.Serializable;

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
@Table(name = "AUX_TBL_CALIFICACIONES")
public class Calificaciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2437113779874596113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_CALIFICACION")
	private Integer pk_calificacion;
	
	@Column(name= "NUM_CAL_UNIDAD_UNO")
	private Integer num_cal_unidad_uno;
	
	@Column(name= "NUM_CAL_2_UNIDAD_DOS")
	private Integer num_cal_unidad_dos;
	
	@Column(name= "NUM_CAL_UNIDAD_TRES")
	private Integer num_cal_unidad_tres;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_ALUMNO")
	private Alumno fk_alumno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_MATERIA")
	private Materia fk_materia;
	
}