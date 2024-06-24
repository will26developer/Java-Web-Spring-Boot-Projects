package com.api.rest.curso.servicios;

import java.util.List;

import com.api.rest.curso.dtos.EstudianteDto;

public interface EstudianteService {
	List<EstudianteDto> obtenerEstudiantes();
	EstudianteDto obtenerEstudiantePorId(Long id); 
	EstudianteDto crearEstudiante(EstudianteDto estudianteDto);
	EstudianteDto actualizarEstudiante(Long id,EstudianteDto estudianteDto);
	EstudianteDto eliminarEstudiantePorId(Long id);
	EstudianteDto matricularAsignatura(String nif,String nombre); 
}
