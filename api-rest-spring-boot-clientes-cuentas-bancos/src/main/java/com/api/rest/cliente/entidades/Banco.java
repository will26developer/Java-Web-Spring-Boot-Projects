package com.api.rest.cliente.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(name = "bancos",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombreBanco"})})
public class Banco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco; 
	private String nombreBanco;
	private String ciudadBanco;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "banco",cascade = CascadeType.ALL)
	private List<Cuenta> cuentas=new ArrayList<Cuenta>();
	
	public Banco() {
		super();
		// TODO Auto-generated constructor stub
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
