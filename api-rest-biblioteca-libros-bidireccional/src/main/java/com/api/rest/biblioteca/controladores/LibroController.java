package com.api.rest.biblioteca.controladores;

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
import com.api.rest.biblioteca.entidades.Libro;
import com.api.rest.biblioteca.repositorios.LibroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping
	public ResponseEntity<List<Libro>> obtenerLibro() {
		return ResponseEntity.ok(libroRepository.findAll());
	}
	
	@GetMapping("/obtenerporid/{id}")
	public ResponseEntity<Libro> obtenerPorLibroId(@PathVariable Long id) {
		Libro libroOpt=libroRepository.findById(id).get();
		if (libroOpt != null) return ResponseEntity.ok(libroOpt);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Libro> crearNuevoLibro(@Valid @RequestBody Libro libro) {
		Libro libroOpt=libroRepository.findLibroByTitulo(libro.getTitulo());
		if (libroOpt == null) {
			libroRepository.save(libro);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(libro).toUri();
			return ResponseEntity.created(location).body(libro);
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	@PutMapping("/actualizarporid/{id}")
	public ResponseEntity<Libro> actualizarLibroPorId(@PathVariable Long id,@Valid @RequestBody Libro libro) {
		Libro libroOpt=libroRepository.findById(id).get();
		if (libroOpt != null) {
			libroOpt.setId(libro.getId());
			libroOpt.setTitulo(libro.getTitulo());
			libroOpt.setNumeroPaginas(libro.getNumeroPaginas()); 
			libroOpt.setAñoLanzamiento(libro.getAñoLanzamiento());
			libroOpt.setBiblioteca(libro.getBiblioteca());
			libroRepository.save(libroOpt);
			return ResponseEntity.accepted().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/borrarporid/{id}")
	public ResponseEntity<Libro> borrarLibroPorId(@PathVariable Long id) {
		Libro libroOpt=libroRepository.findById(id).get();
		if (libroOpt != null) {
			libroRepository.delete(libroOpt);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
