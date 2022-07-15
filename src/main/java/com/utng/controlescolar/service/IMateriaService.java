package com.utng.controlescolar.service;

//import java.util.List;

import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.model.Response;

public interface IMateriaService {

	Response<Materia> consultarTodos();

	Response<Materia> guardarMateria(MateriaRequest materia);
	
	Response<Materia> buscarMateriaId(Integer idMateria);
	
	Response<Integer> eliminarMateria(Integer idMateria);
	
	Response<Materia> buscarPorNombre(String des_nombre);
	
	Response<Materia> buscarPorNombre2(String des_manetia,String txt_clave);

	Response<Materia> actualizarMateria(MateriaRequest materia);
	
	Response<Materia> buscarMateria(MateriaFiltroRequest materia);

	Response<Materia> buscarMateriaFiltro(MateriaFiltroRequest materia);
}
