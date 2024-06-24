package com.api.rest.curso.dtos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.api.rest.curso.entidades.Estudiante;

import jakarta.validation.constraints.NotNull;

public class CursoDto {
	private Long id; 
	@NotNull
	private String nombre;
	@NotNull
	private String ubicacion; 
	@NotNull
	private Date fechaInicio; 
	@NotNull
	private Date fechaFin; 
	private Set<Estudiante> estudiantes=new HashSet<Estudiante>();
	
	public CursoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoDto(Long id, String nombre, String ubicacion, Date fechaInicio, Date fechaFin,
			Set<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
}
