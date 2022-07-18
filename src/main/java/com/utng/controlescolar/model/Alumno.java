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
	private Integer pk_alumno;
	
	@Column(name = "TXT_EXPEDIENTE")
	private String txt_expediente;
	
	@Column(name = "TXT_NOMBRE")
	private String txt_nombre;
	
	@Column(name = "TXT_APE_PATERNO")
	private String txt_ape_paterno;
	
	@Column(name = "TXT_APE_MATERNO")
	private String txt_ape_materno;
	
	@Column(name = "TXT_CURP")
	private String txt_curp;

	@Column(name = "TXT_SEXO")
	private String txt_sexo;
	
	@Column(name = "TXT_CORREO")
	private String txt_correo;
	
	//@Column(name = "PHO_FOTO")
	//private Blob pho_foto;
	
	//@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "FK_STATUS")
	private Integer fk_status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_GRUPO")
	private Grupo fk_grupo;
	
}

