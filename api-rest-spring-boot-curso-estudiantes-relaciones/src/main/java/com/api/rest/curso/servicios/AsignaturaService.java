package com.api.rest.curso.servicios;

import java.util.List;

import com.api.rest.curso.dtos.AsignaturaDto;

public interface AsignaturaService {
	List<AsignaturaDto> obtenerAsignaturas();
	AsignaturaDto obtenerAsignaturaPorId(Long id);
	AsignaturaDto crearAsignatura(AsignaturaDto asignaturaDto);
	AsignaturaDto actualizarAsignatura(Long id,AsignaturaDto asignaturaDto); 
	AsignaturaDto eliminarAsignaturaPorId(Long id);
}
