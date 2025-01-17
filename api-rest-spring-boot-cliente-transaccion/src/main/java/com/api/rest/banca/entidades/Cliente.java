package com.api.rest.banca.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "clientes",uniqueConstraints = {@UniqueConstraint(columnNames = {"nif","iban"})})
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;
	@Column(name = "cliente_nombre")
	private String nombre;
	@Column(name = "cliente_apellidos")
	private String apellidos;
	@Column(name = "cliente_edad")
	private Integer edad;
	@Column(name = "cliente_nif")
	private String nif;
	@Column(name = "cliente_email")
	private String email;
	@Column(name = "cliente_iban")
	private String iban;
	@Column(name = "cliente_saldo")
	private Double saldo;
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	private Set<Transaccion> transacciones=new HashSet<Transaccion>();
	
	public Cliente() {
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

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Set<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Set<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	
	
	
}
