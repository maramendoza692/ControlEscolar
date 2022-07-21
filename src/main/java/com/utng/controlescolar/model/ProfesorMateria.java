package com.utng.controlescolar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "REL_TBL_PROFESOR_MATERIA")

public class ProfesorMateria implements Serializable{
	
	private static final long serialVersionUID = 2984357382136212513L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_PR_MT")
	private Integer pk_pr_mt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "FK_PROFESOR")
	private List<Profesor> fk_profesor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "FK_MATERIA")
	private List<Materia> fk_materia;
}
