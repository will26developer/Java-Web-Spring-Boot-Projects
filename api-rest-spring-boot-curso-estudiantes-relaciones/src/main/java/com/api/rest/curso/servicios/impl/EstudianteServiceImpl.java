package com.api.rest.curso.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.curso.dtos.EstudianteDto;
import com.api.rest.curso.entidades.Asignatura;
import com.api.rest.curso.entidades.Estudiante;
import com.api.rest.curso.repositorios.AsignaturaRepository;
import com.api.rest.curso.repositorios.EstudianteRepository;
import com.api.rest.curso.servicios.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	public List<EstudianteDto> obtenerEstudiantes() {
		List<EstudianteDto> estudiantes=new ArrayList<EstudianteDto>(); 
		for (Estudiante estudiante:estudianteRepository.findAll()) estudiantes.add(convertirADto(estudiante));
		return estudiantes;
	}

	@Override
	public EstudianteDto obtenerEstudiantePorId(Long id) {
		EstudianteDto estudianteDto=convertirADto(estudianteRepository.findById(id).orElseThrow());
		if (estudianteDto != null) return estudianteDto;
		return null;
	}

	@Override
	public EstudianteDto crearEstudiante(EstudianteDto estudianteDto) {
		Estudiante estudiante=estudianteRepository.findEstudianteByNif(estudianteDto.getNif());
		if (estudiante == null) {
			estudianteRepository.save(convertirAEntidad(estudianteDto));
			return estudianteDto;
		}
		return null;
	}

	@Override
	public EstudianteDto actualizarEstudiante(Long id, EstudianteDto estudianteDto) {
		Estudiante estudiante=estudianteRepository.findById(id).orElseThrow(); 
		if (estudiante != null) {
			estudiante.setId(estudianteDto.getId());
			estudiante.setNombre(estudiante.getNombre());
			estudiante.setApellidos(estudiante.getApellidos());
			estudiante.setEdad(estudiante.getEdad());
			estudiante.setNif(estudianteDto.getNif());
			estudiante.setEmail(estudianteDto.getEmail());
			estudiante.setCurso(estudianteDto.getCurso());
			estudiante.setAsignaturas(estudianteDto.getAsignaturas());
			estudianteRepository.save(estudiante);
			return estudianteDto;
		}
		return null;
	}

	@Override
	public EstudianteDto eliminarEstudiantePorId(Long id) {
		Estudiante estudiante=estudianteRepository.findById(id).orElseThrow();
		if (estudiante != null) {
			estudianteRepository.delete(estudiante);
			return convertirADto(estudiante);
		}
		return null;
	} 
	
	@Override
	public EstudianteDto matricularAsignatura(String nif,String nombre) {
		Estudiante estudiante=estudianteRepository.findEstudianteByNif(nif); 
		Asignatura asignatura=asignaturaRepository.findAsignaturaByNombre(nombre);
		if (estudiante != null && asignatura != null) {
			estudiante.getAsignaturas().add(asignatura);  
			estudianteRepository.save(estudiante);
			return convertirADto(estudiante);
		}
		return null;
	}
	
	private EstudianteDto convertirADto(Estudiante estudiante) {
		EstudianteDto estudianteDto=new EstudianteDto(); 
		estudianteDto.setId(estudiante.getId());
		estudianteDto.setNombre(estudiante.getNombre());
		estudianteDto.setApellidos(estudiante.getApellidos());
		estudianteDto.setEdad(estudiante.getEdad());
		estudianteDto.setEmail(estudiante.getEmail());
		estudianteDto.setNif(estudiante.getNif());
		estudianteDto.setCurso(estudiante.getCurso());
		estudianteDto.setAsignaturas(estudiante.getAsignaturas());
		return estudianteDto;
	}
	
	private Estudiante convertirAEntidad(EstudianteDto estudianteDto) {
		Estudiante estudiante=new Estudiante();
		estudiante.setId(estudianteDto.getId());
		estudiante.setNombre(estudianteDto.getNombre());
		estudiante.setApellidos(estudianteDto.getApellidos());
		estudiante.setEdad(estudianteDto.getEdad());
		estudiante.setEmail(estudianteDto.getEmail());
		estudiante.setNif(estudianteDto.getNif());
		estudiante.setCurso(estudianteDto.getCurso());
		estudiante.setAsignaturas(estudianteDto.getAsignaturas());
		return estudiante;
	}
	
}
