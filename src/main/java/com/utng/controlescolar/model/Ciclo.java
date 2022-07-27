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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MASTER_TBL_CICLO_ESCOLAR")
public class Ciclo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583460689462715838L;

	/*ID_CICLO int(11) NOT NULL AUTO_INCREMENT,
  CLAVE varchar(12) DEFAULT NULL,
  NOMBRE varchar(30) DEFAULT NULL,
  ESTATUS int(11) DEFAULT NULL,
  PERIODO int(11) DEFAULT NULL,
  FECHA_INICIO date DEFAULT NULL,
  FECHA_FIN date DEFAULT NULL,
  PRIMARY KEY (ID_CICLO)*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_CICLO")
	private Integer idCiclo;
	
	@Column(name= "TXT_CLAVE")
	private String clave;
	
	@Column(name= "TXT_DESC_CICLO")
	private String descCiclo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_STATUS")
	private Status status;
	
	@Column(name= "DAT_FECHA_INICIO")
	private Date dat_fecha_inicio;
	
	@Column(name= "DAT_FECHA_FIN")
	private Date dat_fecha_fin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "FK_PERIODO")
	private Periodo fk_periodo;

	
	
}
