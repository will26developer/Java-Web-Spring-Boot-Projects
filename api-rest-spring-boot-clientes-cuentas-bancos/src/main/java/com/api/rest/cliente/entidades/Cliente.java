package com.api.rest.cliente.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "clientes",uniqueConstraints = {@UniqueConstraint(columnNames = {"dniCliente"})})
public class Cliente {
	@Id
	private String dniCliente;
	private String nombreCliente; 
	private String direccionCliente;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Cuenta> cuentas=new ArrayList<Cuenta>();
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
}
