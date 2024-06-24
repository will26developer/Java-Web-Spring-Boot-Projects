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

import com.api.rest.curso.dtos.AsignaturaDto;
import com.api.rest.curso.servicios.AsignaturaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping
	public ResponseEntity<List<AsignaturaDto>> obtenerAsignatura() {
		return ResponseEntity.ok(asignaturaService.obtenerAsignaturas());
	}
	
	@GetMapping("/obtenerporid/{id}")
	public ResponseEntity<AsignaturaDto> obtenerAsignaturaPorId(@PathVariable Long id) {
		AsignaturaDto asignaturaDto=asignaturaService.obtenerAsignaturaPorId(id);
		if (asignaturaDto != null) return ResponseEntity.ok(asignaturaDto);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AsignaturaDto> crearAsignatura(@Valid @RequestBody AsignaturaDto asignaturaDto) {
		AsignaturaDto asignaturaDto2=asignaturaService.crearAsignatura(asignaturaDto);
		if (asignaturaDto2 != null) {
			URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(asignaturaDto2).toUri();
			return ResponseEntity.created(locationUri).body(asignaturaDto2);
		}
		return ResponseEntity.unprocessableEntity().build();
	} 
	
	@PutMapping("/actualizarporid/{id}")
	public ResponseEntity<AsignaturaDto> actualizarAsignaturaPorId(@PathVariable Long id,@Valid @RequestBody AsignaturaDto asignaturaDto) {
		AsignaturaDto asignaturaDto2=asignaturaService.obtenerAsignaturaPorId(id);
		if (asignaturaDto2 != null) return ResponseEntity.accepted().build();
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/eliminarporid/{id}")
	public ResponseEntity<AsignaturaDto> eliminarAsignaturaPorId(@PathVariable Long id) {
		AsignaturaDto asignaturaDto=asignaturaService.eliminarAsignaturaPorId(id);
		if (asignaturaDto != null) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
}
