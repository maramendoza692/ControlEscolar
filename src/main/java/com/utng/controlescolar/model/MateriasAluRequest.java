package com.utng.controlescolar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriasAluRequest {

	/*private Materia pk_materia;
	
	private Profesor pk_profesor;
	
	private Calificaciones pk_promedio;*/
	private Materia txt_clave;
	
	private Materia des_materia;
	
	private Profesor txt_nombre;
	
	private Profesor txt_ape_paterno;
	
	private Profesor txt_ape_materno;
	
	private Calificaciones num_cal_1;
	
	private Calificaciones num_cal_2;
	
	private Calificaciones num_cal_3;
}
