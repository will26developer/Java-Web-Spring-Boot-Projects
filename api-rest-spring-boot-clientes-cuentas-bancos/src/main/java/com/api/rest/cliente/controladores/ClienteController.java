package com.api.rest.cliente.controladores;

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

import com.api.rest.cliente.dtos.ClienteDto;
import com.api.rest.cliente.servicios.ClienteService;

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

    @GetMapping("/obtenerpordni/{dni}")
    public ResponseEntity<ClienteDto> obtenerClientePorNombre(@PathVariable String dni) {
        ClienteDto clienteDto=clienteService.obtenerClientePorDni(dni); 
        if (clienteDto != null) return ResponseEntity.ok(clienteDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ClienteDto> crearCuenta(@Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteDto2=clienteService.crearCliente(clienteDto);
        if (clienteDto2 != null) {
            URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{dniCliente}").buildAndExpand(clienteDto2).toUri();
            return ResponseEntity.created(locationUri).body(clienteDto2);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PutMapping("/actualizarpordni/{dni}")
    public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable String dni,@Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteDto2=clienteService.actualizarCliente(dni, clienteDto);
        if (clienteDto2 != null) return ResponseEntity.accepted().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminarpordni/{dni}")
    public ResponseEntity<ClienteDto> eliminarCliente(@PathVariable String dni) {
        ClienteDto clienteDto=clienteService.eliminarCliente(dni);
        if (clienteDto != null) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
