package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table(name = "CAT_TBL_PERIODO")
public class Periodo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7123593405598528623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_PERIODO")
	private Integer pk_periodo;
	
	@Column(name= "TXT_DESC_PERIODO")
	private String txt_desc_periodo;
	
	
}
