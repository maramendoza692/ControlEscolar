package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.model.MateriaFiltroRequest;
import com.utng.controlescolar.model.MateriaRequest;
import com.utng.controlescolar.model.Response;
import com.utng.controlescolar.repository.CicloRepository;
import com.utng.controlescolar.repository.ConsultaMateriaRepository;
import com.utng.controlescolar.repository.MateriaRepository;


@Service
public class MateriaService implements IMateriaService{

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private CicloRepository cicloRepository;
	
	@Autowired
	private ConsultaMateriaRepository consultaMateriaRepository;
	
	@Override
	public Response<Materia> consultarTodos() {
		Response<Materia> response = new Response<Materia>();
		List<Materia> lista = materiaRepository.findAll();
		
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
	public Response<Materia> guardarMateria(MateriaRequest materia) {
		Response<Materia> response = new Response<Materia>();
		
		Optional <Ciclo> optionalCiclo = cicloRepository.findById(materia.getCicloNombre());
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;
		
		if (optionalCiclo.isPresent()) {
			ciclo = optionalCiclo.get();
			materia1 = new Materia();
			materia1.setClave(materia.getTxt_clave());
			materia1.setIdCiclo(ciclo);
			materia1.setStatus(materia.getFk_status());
			materia1.setDescMateria(materia.getDes_materia());
			
			materia2 = materiaRepository.save(materia1);//Meter en el objeto materia2, ya con el Id pq va alrepository y guarda materia1, 
			
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(materia2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El ciclo no existe");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public Response<Materia> buscarMateriaId(Integer idMateria) {
		Response<Materia> response = new Response<Materia>();
		Materia materia = null;
		Optional<Materia> optional = materiaRepository.findById(idMateria);
		
		if(optional.isPresent()) {
			materia = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(materia);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Integer> eliminarMateria(Integer idMateria) {
		Response<Integer> response = new Response<Integer>();
		materiaRepository.deleteById(idMateria);
		
		response.setMessage("Eliminado correctamente");
		response.setStatus("OK");
		response.setData(idMateria);
		
		return response;
	}

	@Override
	public Response<Materia> actualizarMateria(MateriaRequest materia) {
		Response<Materia> response = new Response<Materia>();
		
		Optional <Ciclo> optionalCiclo = cicloRepository.findById(materia.getCicloNombre());
		Ciclo ciclo = null;
		Materia materia1 = null;
		Materia materia2 = null;
		
		if (optionalCiclo.isPresent()) {
			ciclo = optionalCiclo.get();
			materia1 = new Materia();
			materia1.setIdMateria(materia.getPk_materia());
			materia1.setClave(materia.getTxt_clave());
			materia1.setIdCiclo(ciclo);
			materia1.setStatus(materia.getFk_status());
			materia1.setDescMateria(materia.getDes_materia());
			materia2 = materiaRepository.save(materia1);
			response.setStatus("OK");
			response.setMessage("Actualizado correctamente");
			response.setData(materia2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("No fue posible actualizar");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public Response<Materia> buscarPorNombre2(String nombre, String clave) {
		Response<Materia> response = new Response<Materia>();
		Materia materia = null;
		Optional<Materia> optional = materiaRepository.consultarPorNombre2(nombre, clave);
		
		if(optional.isPresent()) {
			materia = optional.get();
			response.setMessage("Búsqueda correcta");
			response.setData(materia);
		}else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");
		
		return response;
	}

	@Override
	public Response<Materia> buscarPorNombre(String nombre) {

		Response<Materia> response = new Response<Materia>();

		Materia materia = null;
		Optional<Materia> optional = materiaRepository.consultarPorNombre(nombre);
		if (optional.isPresent()) {
			materia = optional.get();
			response.setData(materia);
			response.setMessage("Búsqueda correcta");
		} else {
			response.setData(null);
			response.setMessage("Sin resultados");
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Materia> buscarMateriaFiltro(MateriaFiltroRequest materia) {
		
		Optional<Ciclo> optional = cicloRepository.consultarPorNombre2(materia.getCicloNombre());
		Ciclo ciclo = null;
		
		if (optional.isPresent()) {
			ciclo = optional.get();
			materia.setIdCiclo(ciclo);
		}
		
		Response<Materia> response= new Response<Materia>();
		
		response=consultaMateriaRepository.busquedaMateria(materia);
		
		return response;
	}

	@Override
	public Response<Materia> buscarMateria(MateriaFiltroRequest materia) {
		// TODO Auto-generated method stub
		return null;
	}
}
