package com.api.rest.curso.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.curso.dtos.CursoDto;
import com.api.rest.curso.entidades.Curso;
import com.api.rest.curso.repositorios.CursoRepository;
import com.api.rest.curso.servicios.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<CursoDto> obtenerCursos() {
		List<CursoDto> cursos=new ArrayList<CursoDto>(); 
		for (Curso curso:cursoRepository.findAll()) cursos.add(convertirADto(curso));
		return cursos;
	}

	@Override
	public CursoDto obtenerCursoPorId(Long id) {
		CursoDto cursoDto=convertirADto(cursoRepository.findById(id).orElseThrow());
		if (cursoDto != null) return cursoDto;
		return null;
	}

	@Override
	public CursoDto crearCurso(CursoDto cursoDto) {
		Curso curso=cursoRepository.findCursoByNombre(cursoDto.getNombre());
		if (curso == null) {
			cursoRepository.save(convertirAEntidad(cursoDto));
			return cursoDto;
		}
		return null;
	}

	@Override
	public CursoDto actualizarCurso(Long id, CursoDto cursoDto) {
		Curso curso=cursoRepository.findById(id).orElseThrow();
		if (curso != null) {
			curso.setId(cursoDto.getId());
			curso.setNombre(cursoDto.getNombre());
			curso.setUbicacion(curso.getUbicacion());
			curso.setFechaInicio(cursoDto.getFechaInicio());
			curso.setFechaFin(curso.getFechaFin());
			curso.setEstudiantes(curso.getEstudiantes());
			cursoRepository.save(curso);
			return cursoDto;
		}
		return null;
	}

	@Override
	public CursoDto eliminarCursoPorId(Long id) {
		Curso curso=cursoRepository.findById(id).orElseThrow();
		if (curso != null) {
			cursoRepository.delete(curso);
			return convertirADto(curso);
		}
		return null;
	}
	
	private CursoDto convertirADto(Curso curso) {
		CursoDto cursoDto=new CursoDto();
		cursoDto.setId(curso.getId()); 
		cursoDto.setNombre(curso.getNombre());
		cursoDto.setUbicacion(curso.getUbicacion());
		cursoDto.setFechaInicio(curso.getFechaInicio()); 
		cursoDto.setFechaFin(curso.getFechaFin());
		cursoDto.setEstudiantes(curso.getEstudiantes());
		return cursoDto;
	}
	
	private Curso convertirAEntidad(CursoDto cursoDto) {
		Curso curso=new Curso();
		curso.setId(cursoDto.getId()); 
		curso.setNombre(cursoDto.getNombre());
		curso.setUbicacion(cursoDto.getUbicacion());
		curso.setFechaInicio(cursoDto.getFechaInicio()); 
		curso.setFechaFin(cursoDto.getFechaFin());
		curso.setEstudiantes(cursoDto.getEstudiantes());
		return curso;
	}
	
	
}
