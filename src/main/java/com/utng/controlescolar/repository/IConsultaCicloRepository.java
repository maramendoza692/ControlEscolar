package com.utng.controlescolar.repository;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.model.Response;

public interface IConsultaCicloRepository {
	Response<Ciclo> busquedaCiclo(CicloFiltroRequest filtro);
}
