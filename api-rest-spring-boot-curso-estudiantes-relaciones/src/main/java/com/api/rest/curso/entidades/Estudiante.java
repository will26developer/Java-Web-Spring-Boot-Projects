package com.api.rest.curso.entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "estudiantes",uniqueConstraints = {@UniqueConstraint(columnNames = {"nif","email"})})
public class Estudiante { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudiante_id")
	private Long id;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private String nif;
	private String email;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "curso_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Curso curso;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "estudiante_asignatura",joinColumns = @JoinColumn(name="estudiante_id",referencedColumnName = "estudiante_id"),
	           inverseJoinColumns = @JoinColumn(name="asignatura_id",referencedColumnName = "asignatura_id"))
	@JsonBackReference
	private Set<Asignatura> asignaturas=new HashSet<Asignatura>();
	
	public Estudiante() {
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
