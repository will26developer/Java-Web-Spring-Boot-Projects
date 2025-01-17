package com.api.rest.banca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.banca.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findClienteByNif(String nif); 
	Cliente findClienteByIban(String iban);
}
