package com.api.rest.banca.controladores;

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

import com.api.rest.banca.dtos.ClienteDto;
import com.api.rest.banca.servicios.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController { 
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> obtenerClientes() {
		return ResponseEntity.ok(clienteService.obtenerClientes());
	}
	
	@GetMapping("/obtenerpornif/{nif}")
	public ResponseEntity<ClienteDto> obtenerClientesPorNif(@PathVariable String nif) {
		ClienteDto clienteDtoEnc=clienteService.obtenerClientePorNif(nif);
		if (clienteDtoEnc != null) return ResponseEntity.ok(clienteDtoEnc);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping 
	public ResponseEntity<ClienteDto> crearCliente(@Valid @RequestBody ClienteDto clienteDto) {
		ClienteDto clienteDtoCr=clienteService.crearCliente(clienteDto);
		if (clienteDtoCr != null) {
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteDtoCr).toUri();
			return ResponseEntity.created(location).body(clienteDtoCr);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@PutMapping("/actualizarpornif/{nif}")
	public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable String nif,@Valid @RequestBody ClienteDto clienteDto) {
		ClienteDto clienteDtoAc=clienteService.actualizarCliente(nif, clienteDto);
		if (clienteDto != null) return ResponseEntity.accepted().build();
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/borrarpornif/{nif}")
	public ResponseEntity<ClienteDto> borrarClientePorNif(@PathVariable String nif) {
		ClienteDto clienteDto=clienteService.borrarClientePorNif(nif);
		if (clienteDto != null) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
}
