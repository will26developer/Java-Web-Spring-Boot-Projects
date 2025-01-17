package com.api.rest.cliente.dtos;

import java.util.ArrayList;
import java.util.List;

import com.api.rest.cliente.entidades.Cuenta;

import jakarta.validation.constraints.NotNull;

public class ClienteDto {
	@NotNull
	private String dniCliente;
	@NotNull
	private String nombreCliente; 
	@NotNull
	private String direccionCliente;
	private List<Cuenta> cuentas=new ArrayList<Cuenta>();
	
	public ClienteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClienteDto(String dniCliente, String nombreCliente, String direccionCliente, List<Cuenta> cuentas) {
		super();
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.cuentas = cuentas;
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
