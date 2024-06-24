package com.api.rest.cliente.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.cliente.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> { 
	Cliente findClienteByDniCliente(String dniCliente);
}
