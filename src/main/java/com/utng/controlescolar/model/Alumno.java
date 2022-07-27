package com.utng.controlescolar.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.type.BlobType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table(name = "MASTER_TBL_ALUMNO")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 3551560747148432178L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_ALUMNO")
	private Integer idAlumno;
	
	@Column(name = "TXT_EXPEDIENTE")
	private String expediente;
	
	@Column(name = "TXT_NOMBRE")
	private String nombre;
	
	@Column(name = "TXT_APE_PATERNO")
	private String apePaterno;
	
	@Column(name = "TXT_APE_MATERNO")
	private String apeMaterno;
	
	@Column(name = "TXT_CURP")
	private String curp;

	@Column(name = "TXT_SEXO")
	private String sexo;
	
	@Column(name = "TXT_CORREO")
	private String correo;
	
	//@Column(name = "PHO_FOTO")
	//private Blob pho_foto;
	
	//@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "FK_STATUS")
	private Integer idStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_GRUPO")
	private Grupo idGrupo;
	
}

