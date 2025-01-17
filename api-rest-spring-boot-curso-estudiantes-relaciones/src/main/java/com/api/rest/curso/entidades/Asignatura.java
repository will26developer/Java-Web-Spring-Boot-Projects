package com.api.rest.curso.entidades;



import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "asignaturas",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asignatura_id")
	private Long id; 
	private String nombre;
	@ManyToMany
	@JoinTable(name="estudiante_asignatura",joinColumns = @JoinColumn(name="asignatura_id",referencedColumnName = "asignatura_id"),
	           inverseJoinColumns = @JoinColumn(name="estudiante_id",referencedColumnName = "estudiante_id"))
	@JsonBackReference
	private Set<Estudiante> estudiantes=new HashSet<Estudiante>();
	
	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
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

	