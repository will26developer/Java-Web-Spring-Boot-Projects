package com.api.rest.curso.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.curso.dtos.AsignaturaDto;
import com.api.rest.curso.entidades.Asignatura;
import com.api.rest.curso.repositorios.AsignaturaRepository;
import com.api.rest.curso.servicios.AsignaturaService;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	public List<AsignaturaDto> obtenerAsignaturas() {
		List<AsignaturaDto> asignaturas=new ArrayList<AsignaturaDto>();
		for (Asignatura asignatura:asignaturaRepository.findAll()) asignaturas.add(convertirADto(asignatura)); 
		return asignaturas;
	}

	@Override
	public AsignaturaDto obtenerAsignaturaPorId(Long id) {
		AsignaturaDto asignaturaDto=convertirADto(asignaturaRepository.findById(id).orElseThrow());
		if (asignaturaDto != null) return asignaturaDto;
		return null;
	}

	@Override
	public AsignaturaDto crearAsignatura(AsignaturaDto asignaturaDto) {
		asignaturaRepository.save(convertirAEntidad(asignaturaDto));
		return asignaturaDto;
	}

	@Override
	public AsignaturaDto actualizarAsignatura(Long id, AsignaturaDto asignaturaDto) { 
		Asignatura asignatura=asignaturaRepository.findById(id).orElseThrow();
		if (asignatura != null) {
			asignatura.setId(asignaturaDto.getId());
			asignatura.setNombre(asignaturaDto.getNombre());
			asignatura.setEstudiantes(asignaturaDto.getEstudiantes());
			asignaturaRepository.save(asignatura);
		}
		return null;
	}

	@Override
	public AsignaturaDto eliminarAsignaturaPorId(Long id) {
		Asignatura asignatura=asignaturaRepository.findById(id).orElseThrow(); 
		if (asignatura != null) {
			asignaturaRepository.delete(asignatura);
			return convertirADto(asignatura);
		}
		return null;
	}
	
	private AsignaturaDto convertirADto(Asignatura asignatura) {
		AsignaturaDto asignaturaDto=new AsignaturaDto();
		asignaturaDto.setId(asignatura.getId());
		asignaturaDto.setNombre(asignatura.getNombre());
		asignaturaDto.setEstudiantes(asignatura.getEstudiantes());
		return asignaturaDto;
	}
	
	private Asignatura convertirAEntidad(AsignaturaDto asignaturaDto) {
		Asignatura asignatura=new Asignatura();
		asignatura.setId(asignaturaDto.getId());
		asignatura.setNombre(asignaturaDto.getNombre());
		asignatura.setEstudiantes(asignaturaDto.getEstudiantes());
		return asignatura;
	}
	
}
