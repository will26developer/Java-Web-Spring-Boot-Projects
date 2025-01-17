package com.api.rest.banca.dtos;

import java.util.HashSet;
import java.util.Set;
import com.api.rest.banca.entidades.Transaccion;

import jakarta.validation.constraints.NotNull;


public class ClienteDto {
	
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
	@NotNull
	private String iban;
	@NotNull
	private Double saldo;
	private Set<Transaccion> transacciones=new HashSet<Transaccion>();
	
	

	public ClienteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDto(Long id, String nombre, String apellidos, Integer edad, String nif, String email, String iban,
			Double saldo, Set<Transaccion> transacciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.nif = nif;
		this.email = email;
		this.iban = iban;
		this.saldo = saldo;
		this.transacciones = transacciones;
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
