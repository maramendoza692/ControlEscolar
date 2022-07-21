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
@Table(name = "MASTER_TBL_GRUPO")
public class Grupo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583460689462715838L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_GRUPO")
	private Integer pk_grupo;
	
	@Column(name= "TXT_DESC_GRUPO")
	private String txt_desc_grupo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_STATUS")
	private Status fk_status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_CICLO")
	private Ciclo fk_ciclo;

}
