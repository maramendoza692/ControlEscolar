package com.utng.controlescolar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table(name = "REL_TBL_ALUMNO_MATERIA")
public class AlumnoMateria implements Serializable{

	private static final long serialVersionUID = 3551560747148432178L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_AL_MT")
	private Integer pk_al_mt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_MATERIA")
	private List<Materia> fk_materia;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ALUMNO")
	private List<Alumno> fk_alumno;
}