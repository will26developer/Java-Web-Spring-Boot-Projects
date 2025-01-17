package com.api.rest.fiestas.entidades;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fiestas")
public class Fiesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fiesta_id")
	private Long id;
	private String ubicacion;
	@Column(name="fiesta_fecha")
	@JsonFormat(pattern = "YYY-MM-dd")
	private Date fecha;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "personas_fiestas",joinColumns = @JoinColumn(name="fiesta_id",referencedColumnName = "fiesta_id"),
	           inverseJoinColumns = @JoinColumn(name="persona_id",referencedColumnName = "persona_id"))
	private Set<Persona> personas=new HashSet<Persona>();
	
	public Fiesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	
	
}
