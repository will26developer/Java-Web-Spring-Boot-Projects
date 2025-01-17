package com.api.rest.curso.dtos;

import java.util.HashSet;
import java.util.Set;

import com.api.rest.curso.entidades.Asignatura;
import com.api.rest.curso.entidades.Curso;

import jakarta.validation.constraints.NotNull;

public class EstudianteDto {
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	private Integer edad;
	@NotNull
	private String nif;
	@NotNull
	private String email;
	private Curso curso;
	private Set<Asignatura> asignaturas=new HashSet<Asignatura>();
	
	public EstudianteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstudianteDto(Long id, String nombre, String apellidos, Integer edad, String nif, String email, Curso curso,
			Set<Asignatura> asignaturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.nif = nif;
		this.email = email;
		this.curso = curso;
		this.asignaturas = asignaturas;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
}
