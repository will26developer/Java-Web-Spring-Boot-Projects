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

import com.api.rest.cliente.dtos.CuentaDto;
import com.api.rest.cliente.servicios.CuentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired  
    private CuentaService cuentaService;

    @GetMapping 
    public ResponseEntity<List<CuentaDto>> obtenerCuentas() {
        return ResponseEntity.ok(cuentaService.obtenerCuentas()); 
    }

    @GetMapping("/obtenerporid/{id}")
    public ResponseEntity<CuentaDto> obtenerPorId(@PathVariable Long id) {
        CuentaDto cuentaDto=cuentaService.obtenerCuentaPorId(id);
        if (cuentaDto != null) return ResponseEntity.ok(cuentaDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CuentaDto> crearCuenta(@Valid @RequestBody CuentaDto cuentaDto) {
        CuentaDto cuentaDto2=cuentaService.crearCuenta(cuentaDto); 
        if (cuentaDto2 != null) {
            URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCuenta}").buildAndExpand(cuentaDto2.getIdCuenta()).toUri();
            return ResponseEntity.created(locationUri).body(cuentaDto2);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PutMapping("/actualizarporid/{id}")
    public ResponseEntity<CuentaDto> actualizarCuenta(@PathVariable Long id,@Valid @RequestBody CuentaDto cuentaDto) {
        CuentaDto cuentaDto2=cuentaService.actualizarCuenta(id, cuentaDto);
        if (cuentaDto2 != null) return ResponseEntity.accepted().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminarporid/{id}")
    public ResponseEntity<CuentaDto> eliminarCuenta(@PathVariable Long id) {
        CuentaDto cuentaDto=cuentaService.eliminarCuenta(id);
        if (cuentaDto != null) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
