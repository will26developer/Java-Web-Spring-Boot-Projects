package com.api.rest.biblioteca.controladores;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.api.rest.biblioteca.entidades.Biblioteca;
import com.api.rest.biblioteca.repositorios.BibliotecaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	@GetMapping
	public ResponseEntity<List<Biblioteca>> obtenerBibliotecas() {
		return ResponseEntity.ok(bibliotecaRepository.findAll()); 
	}
	
	@GetMapping("obtenerporid/{id}")
	public ResponseEntity<Biblioteca> obtenerBibliotecaPorId(@PathVariable Long id) {
		Optional<Biblioteca> bibliotecaOpt=bibliotecaRepository.findById(id);
		if (bibliotecaOpt.isPresent()) return ResponseEntity.ok(bibliotecaOpt.get());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Biblioteca> nuevaBiblioteca(@Valid @RequestBody Biblioteca biblioteca) {
		Biblioteca bibliotecaOpt=bibliotecaRepository.findBibliotecaByNombre(biblioteca.getNombre());
		if(bibliotecaOpt == null) {
			bibliotecaRepository.save(biblioteca);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(biblioteca).toUri();
			return ResponseEntity.created(location).body(biblioteca);
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	@PutMapping("/actualizarporid/{id}")
	public ResponseEntity<Biblioteca> actualizarBiblioteca(@PathVariable Long id,@Valid @RequestBody Biblioteca biblioteca) {
		Biblioteca bibliotecaOpt=bibliotecaRepository.findById(id).get(); 
		if (bibliotecaOpt != null) {
			bibliotecaOpt.setId(biblioteca.getId()); 
			bibliotecaOpt.setNombre(biblioteca.getNombre()); 
			bibliotecaOpt.setCategoria(biblioteca.getCategoria());
			bibliotecaOpt.setLibros(biblioteca.getLibros());
			bibliotecaRepository.save(bibliotecaOpt);
			return ResponseEntity.accepted().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("borrarporid/{id}")
	public ResponseEntity<Biblioteca> borrarBibliotecaPorId(@PathVariable Long id) {
		Biblioteca bibliotecaOpt=bibliotecaRepository.findById(id).get();
		if (bibliotecaOpt != null) {
			bibliotecaRepository.delete(bibliotecaOpt); 
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}

