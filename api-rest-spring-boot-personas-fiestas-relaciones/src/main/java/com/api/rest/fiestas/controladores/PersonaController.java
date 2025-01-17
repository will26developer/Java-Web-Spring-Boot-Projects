package com.api.rest.fiestas.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.fiestas.entidades.Fiesta;
import com.api.rest.fiestas.entidades.Persona;
import com.api.rest.fiestas.repositorios.PersonaRepository;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping 
	public ResponseEntity<Collection<Persona>> obtenerPersonas() {
		return new ResponseEntity<>(personaRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
		Persona persona=personaRepository.findById(id).orElseThrow(); 
		if (persona != null) return new ResponseEntity<>(persona,HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
		return new ResponseEntity<>(personaRepository.save(persona),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPersonaPorId(@PathVariable Long id) {
		Persona persona=personaRepository.findById(id).orElseThrow();
		if (persona != null) {
			personaRepository.delete(persona);
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/fiestas")
	public ResponseEntity<Collection<Fiesta>> listarFiestasPersona(@PathVariable Long id) {
		Persona persona=personaRepository.findById(id).orElseThrow();
		if (persona != null) return new ResponseEntity<>(persona.getFiestas(),HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
