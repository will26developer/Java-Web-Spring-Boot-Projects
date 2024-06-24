package com.api.rest.fiestas.entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id")
	private Long id;
	private String nombre;
	private Integer edad;
	@OneToMany(mappedBy = "persona")
	private Set<Habilidad> habilidades=new HashSet<Habilidad>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "personas_fiestas",joinColumns = @JoinColumn(name="persona_id",referencedColumnName = "persona_id"),
	           inverseJoinColumns = @JoinColumn(name="fiesta_id",referencedColumnName = "fiesta_id"))
	private Set<Fiesta> fiestas=new HashSet<Fiesta>();
	
	public Persona() {
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Set<Fiesta> getFiestas() {
		return fiestas;
	}

	public void setFiestas(Set<Fiesta> fiestas) {
		this.fiestas = fiestas;
	}
	
	
}
