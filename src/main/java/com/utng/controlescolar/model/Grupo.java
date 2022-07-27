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
import javax.persistence.OneToOne;
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

	/*ID_GRUPO int(11) NOT NULL AUTO_INCREMENT,
  GRUPO varchar(50) DEFAULT NULL,
  ESTATUS int(11) DEFAULT NULL,
  ID_CICLO int(11) DEFAULT NULL,
  PRIMARY KEY (ID_GRUPO),
  FOREIGN KEY (ID_CICLO) REFERENCES TBL_CICLO_ESCOLAR(ID_CICLO)*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_GRUPO")
	private Integer idGrupo;
	
	@Column(name= "TXT_DESC_GRUPO")
	private String descGrupo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_STATUS")
	private Status status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_CICLO")
	private Ciclo idCiclo;

}
