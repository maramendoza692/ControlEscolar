package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.CicloFiltroRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.ConsultaCicloRepository;

@Service
public class CicloService implements ICicloService {
	
	/*@PersistenceContext
    private EntityManager entityManager;*/

	@Autowired
	private CicloRepository cicloRepository;
	
	@Autowired
	private ConsultaCicloRepository consultaCicloRepository;
	
	/*@Override
	public Response<Ciclo> buscarPrueba(String nombre, String clave) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Ciclo").();
	}*/
	
	@Override
	public Response<Ciclo> consultarTodos() {
		Response<Ciclo> response = new Response<Ciclo>();
		List<Ciclo> lista = cicloRepository.findAll();
		
		if(lista.isEmpty()) {
			response.setMessage("No hay resultados");
			
		}else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}

	@Override
	public Response<Ciclo> guardarCiclo(Ciclo ciclo) {
		Response<Ciclo> response = new Response<Ciclo>();
		Ciclo cicloNuevo =  cicloRepository.save(ciclo);
		
		response.setMessage("Guardado correctamente");
		response.setStatus("OK");
		response.setData(cicloNuevo);
	
		return response;
	}

	@Override
	public Response<Ciclo> buscarCicloId(Integer idCiclo) {
		Response<Ciclo> response = new Response<Ciclo>();
		Ciclo ciclo = null;
		Optional<Ciclo> optional = cicloRepository.findById(idCiclo);
		
		if(optional.isPresent()) {
			ciclo = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(ciclo);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Integer> eliminarCiclo(Integer idCiclo) {
		Response<Integer> response = new Response<Integer>();
		cicloRepository.deleteById(idCiclo);
		
		response.setMessage("Eliminado correctamente");
		response.setStatus("OK");
		response.setData(idCiclo);
		
		return response;
	}

	@Override
	public Response<Ciclo> actualizarCiclo(Ciclo ciclo) {
		Response<Ciclo> response = new Response<Ciclo>();
		Ciclo cicloNuevo =  cicloRepository.save(ciclo);
		
		response.setMessage("Actualizado correctamente");
		response.setStatus("OK");
		response.setData(cicloNuevo);
		
		return response;
	}

	@Override
	public Response<Ciclo> buscarPorNombreClave(String txt_desc_ciclo, String txt_clave) {
		Response<Ciclo> response = new Response<Ciclo>();
		Ciclo ciclo = null;
		Optional<Ciclo> optional = cicloRepository.consultarPorNombre(txt_desc_ciclo, txt_clave);
		
		if(optional.isPresent()) {
			ciclo = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(ciclo);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}
	
	@Override
	public Response<Ciclo> buscarCiclo(CicloFiltroRequest ciclo) {
		Response<Ciclo> response = new Response<Ciclo>();
		
		response = consultaCicloRepository.busquedaCiclo(ciclo);
		
		return response;
	}

	
}
