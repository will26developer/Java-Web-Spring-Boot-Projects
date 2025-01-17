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
import com.api.rest.fiestas.repositorios.FiestaRepository;

@RestController
@RequestMapping("/api/fiestas")
public class FiestaController {
	@Autowired
	private FiestaRepository fiestaRepository; 
	
	@GetMapping 
	public ResponseEntity<Collection<Fiesta>> obtenerFiestas() {
		return new ResponseEntity<>(fiestaRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
		Fiesta fiesta=fiestaRepository.findById(id).orElseThrow(); 
		if (fiesta != null) return new ResponseEntity<>(fiesta,HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta) {
		return new ResponseEntity<>(fiestaRepository.save(fiesta),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarFiestaPorId(@PathVariable Long id) {
		Fiesta fiesta=fiestaRepository.findById(id).orElseThrow();
		if (fiesta != null) {
			fiestaRepository.delete(fiesta);
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
}
