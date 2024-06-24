package com.api.rest.curso.servicios;

import java.util.List;

import com.api.rest.curso.dtos.CursoDto;

public interface CursoService {
	List<CursoDto> obtenerCursos();
	CursoDto obtenerCursoPorId(Long id);
	CursoDto crearCurso(CursoDto cursoDto);
	CursoDto actualizarCurso(Long id,CursoDto cursoDto);
	CursoDto eliminarCursoPorId(Long id);
}
