package com.api.rest.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.curso.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	Curso findCursoByNombre(String nombre);
}
