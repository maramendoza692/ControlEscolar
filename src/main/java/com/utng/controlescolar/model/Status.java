package com.utng.controlescolar.model;

import java.io.Serializable;
//import java.sql.Blob;

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
@Table(name = "CAT_TBL_STATUS")
public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3317153483568963934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "PK_STATUS")
	private Integer pk_status;
	
	@Column(name= "TXT_STATUS")
	private String txt_status;
}
