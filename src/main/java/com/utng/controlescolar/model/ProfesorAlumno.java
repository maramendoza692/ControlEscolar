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
@Table(name = "REL_TBL_PROFESOR_ALUMNO")
public class ProfesorAlumno implements Serializable{

	private static final long serialVersionUID = 1087657834819993719L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_PR_AL")
	private Integer pk_pr_al;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "FK_PROFESOR")
	private List<Profesor> fk_profesor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "FK_ALUMNO")
	private List<Alumno> fk_alumno;
}
