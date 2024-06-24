package com.api.rest.cliente.dtos;

import java.util.ArrayList;
import java.util.List;

import com.api.rest.cliente.entidades.Cuenta;

import jakarta.validation.constraints.NotNull;

public class BancoDto {
	private Long idBanco;
	@NotNull
	private String nombreBanco;
	@NotNull
	private String ciudadBanco;
	private List<Cuenta> cuentas=new ArrayList<Cuenta>();
	
	public BancoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BancoDto(Long idBanco, String nombreBanco, String ciudadBanco, List<Cuenta> cuentas) {
		super();
		this.idBanco = idBanco;
		this.nombreBanco = nombreBanco;
		this.ciudadBanco = ciudadBanco;
		this.cuentas = cuentas;
	}

	public Long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getCiudadBanco() {
		return ciudadBanco;
	}

	public void setCiudadBanco(String ciudadBanco) {
		this.ciudadBanco = ciudadBanco;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
