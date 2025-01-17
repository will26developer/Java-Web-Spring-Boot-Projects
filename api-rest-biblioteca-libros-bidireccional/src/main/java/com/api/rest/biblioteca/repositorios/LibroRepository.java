package com.api.rest.biblioteca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.biblioteca.entidades.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
	Libro findLibroByTitulo(String titulo);
}
