package com.api.rest.cliente.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.cliente.entidades.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> { 
	Banco findBancoByNombreBanco(String nombreBanco);
}
