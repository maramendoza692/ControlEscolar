package com.utng.controlescolar.service;

//import java.util.List;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.model.Response;

public interface ICicloService {

	Response<Ciclo> consultarTodos();
	
	Response<Ciclo> guardarCiclo(Ciclo ciclo);
	
	Response<Ciclo> buscarCicloId(Integer idCiclo);
	
	Response<Integer> eliminarCiclo (Integer idCiclo); 
	
	Response<Ciclo> actualizarCiclo(Ciclo ciclo);
	
	Response<Ciclo> buscarPorNombreClave(String txt_desc_ciclo, String txt_clave);

	Response<Ciclo> buscarCiclo(CicloFiltroRequest ciclo);
	
	//Response<Ciclo> buscarPrueba(String nombre, String clave);
}
