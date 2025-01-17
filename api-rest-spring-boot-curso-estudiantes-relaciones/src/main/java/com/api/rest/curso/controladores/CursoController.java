package com.api.rest.curso.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.curso.dtos.CursoDto;
import com.api.rest.curso.servicios.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<CursoDto>> obtenerCursos() {
		return ResponseEntity.ok(cursoService.obtenerCursos());
	}
	
	@GetMapping("/obtenerporid/{id}")
	public ResponseEntity<CursoDto> obtenerCursoPorId(@PathVariable Long id) {
		CursoDto cursoDto=cursoService.obtenerCursoPorId(id);
		if (cursoDto != null) return ResponseEntity.ok(cursoDto); 
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CursoDto> crearCurso(@Valid @RequestBody CursoDto cursoDto) {
		CursoDto cursoDto2=cursoService.crearCurso(cursoDto);
		if (cursoDto2 != null) {
			URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoDto2).toUri();
			return ResponseEntity.created(locationUri).body(cursoDto2);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@PutMapping("/actualizarporid/{id}")
	public ResponseEntity<CursoDto> actualizarCursoPorId(@PathVariable Long id,@Valid @RequestBody CursoDto cursoDto) {
		CursoDto cursoDto2=cursoService.actualizarCurso(id, cursoDto);
		if (cursoDto2 != null) return ResponseEntity.accepted().build();
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/borrarporid/{id}")
	public ResponseEntity<CursoDto> eliminarCursoPorId(@PathVariable Long id) {
		CursoDto cursoDto=cursoService.eliminarCursoPorId(id);
		if (cursoDto != null) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
}
