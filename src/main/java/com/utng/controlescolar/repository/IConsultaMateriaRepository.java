package com.utng.controlescolar.repository;

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.Response;



public interface IConsultaMateriaRepository {

	Response<Materia> busquedaMateria(MateriaFiltroRequest filtro);
}
