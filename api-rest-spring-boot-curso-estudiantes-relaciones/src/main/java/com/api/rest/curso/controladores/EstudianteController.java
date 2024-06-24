package com.api.rest.curso.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.curso.dtos.EstudianteDto;
import com.api.rest.curso.servicios.EstudianteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public ResponseEntity<List<EstudianteDto>> obtenerEstudiantes() {
		return new ResponseEntity<>(estudianteService.obtenerEstudiantes(),HttpStatus.OK);
	}
	
	@GetMapping("/obtenerporid/{id}")
	public ResponseEntity<EstudianteDto> obtenerEstudiantePorId(@PathVariable Long id) {
		EstudianteDto estudianteDto=estudianteService.obtenerEstudiantePorId(id);
		if (estudianteDto != null) return new ResponseEntity<>(estudianteDto,HttpStatus.OK); 
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<EstudianteDto> crearEstudiante(@Valid @RequestBody EstudianteDto estudianteDto) {
		EstudianteDto estudianteDto2=estudianteService.crearEstudiante(estudianteDto);
		if (estudianteDto2 != null) return new ResponseEntity<>(estudianteDto2,HttpStatus.CREATED);
		return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@PutMapping("/actualizarporid/{id}")
	public ResponseEntity<EstudianteDto> actualizarEstudiantePorId(@PathVariable Long id,@Valid @RequestBody EstudianteDto estudianteDto) {
		EstudianteDto estudianteDto2=estudianteService.actualizarEstudiante(id, estudianteDto);
		if (estudianteDto2 != null) return new ResponseEntity<>(estudianteDto2,HttpStatus.ACCEPTED);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminarporid/{id}")
	public ResponseEntity<EstudianteDto> eliminarEstudiantePorId(@PathVariable Long id) {
		EstudianteDto estudianteDto=estudianteService.eliminarEstudiantePorId(id);
		if (estudianteDto != null) return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/estudiante/{nif}/asignatura/{nombre}")
	public ResponseEntity<EstudianteDto> insertarMatricula(@PathVariable String nif,@PathVariable String nombre) {
		EstudianteDto estudianteDto=estudianteService.matricularAsignatura(nif, nombre);
		if (estudianteDto != null) return new ResponseEntity<>(estudianteDto,HttpStatus.ACCEPTED);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}


}
