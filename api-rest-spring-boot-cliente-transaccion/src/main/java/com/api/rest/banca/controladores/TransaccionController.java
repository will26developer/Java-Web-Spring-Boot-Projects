package com.api.rest.banca.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.banca.dtos.TransaccionDto;
import com.api.rest.banca.servicios.TransaccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
	@Autowired
	private TransaccionService transaccionService;
	
	@GetMapping
	public ResponseEntity<List<TransaccionDto>> obtenerTransacciones() {
		return ResponseEntity.ok(transaccionService.obtenerTransacciones());
	}
	
	@PostMapping
	public ResponseEntity<TransaccionDto> crearTransaccion(@Valid @RequestBody TransaccionDto transaccionDto) {
		TransaccionDto transaccionDto2=transaccionService.crearNuevaTransaccion(transaccionDto);
		if (transaccionDto2 != null) {
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaccionDto).toUri();
			return ResponseEntity.created(location).body(transaccionDto2);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
}
