package com.api.rest.biblioteca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.biblioteca.entidades.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
	Biblioteca findBibliotecaByNombre(String nombre);
}
