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

import com.api.rest.cliente.dtos.BancoDto;
import com.api.rest.cliente.servicios.BancoService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/bancos")
public class BancoController { 
    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoDto>> obtenerBancos() {
        return ResponseEntity.ok(bancoService.obtenerBancos());
    }

    @GetMapping("/obtenerpornombre/{nombre}")
    public ResponseEntity<BancoDto> obtenerBancoPorNombre(@PathVariable String nombre) {
        BancoDto bancoDto=bancoService.obtenerBancoPorNombre(nombre);
        if (bancoDto != null) return ResponseEntity.ok(bancoDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BancoDto> crearBanco(@Valid @RequestBody BancoDto bancoDto) {
        BancoDto bancoDto2=bancoService.crearBanco(bancoDto);
        if (bancoDto2 != null) {
            URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{idBanco}").buildAndExpand(bancoDto2).toUri();
            return ResponseEntity.created(locationUri).body(bancoDto2);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PutMapping("/actualizarpornombre/{nombre}")
    public ResponseEntity<BancoDto> actualizarBanco(@PathVariable String nombre,@Valid @RequestBody BancoDto bancoDto) {
        BancoDto bancoDto2=bancoService.actualizarBanco(nombre, bancoDto);
        if (bancoDto2 != null) return ResponseEntity.accepted().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminarpornombre/{nombre}")
    public ResponseEntity<BancoDto> eliminarPorNombre(@PathVariable String nombre) {
        BancoDto bancoDto=bancoService.eliminarBanco(nombre);
        if (bancoDto != null) return ResponseEntity.noContent().build(); 
        return ResponseEntity.notFound().build();
    }
}
