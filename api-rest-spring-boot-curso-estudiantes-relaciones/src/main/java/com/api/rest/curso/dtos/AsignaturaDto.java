package com.api.rest.curso.dtos;

import java.util.HashSet;
import java.util.Set;

import com.api.rest.curso.entidades.Estudiante;

import jakarta.validation.constraints.NotNull;

public class AsignaturaDto {
	private Long id;
	@NotNull
	private String nombre; 
	private Set<Estudiante> estudiantes=new HashSet<Estudiante>();
	
	public AsignaturaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AsignaturaDto(Long id, String nombre, Set<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estudiantes = estudiantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
}
