package com.api.rest.banca.dtos;

import com.api.rest.banca.entidades.Cliente;

import jakarta.validation.constraints.NotNull;


public class TransaccionDto {
	
	private Long id;
	@NotNull
	private String ibanProp;
	@NotNull
	private String ibanDest;
	@NotNull
	private Double monto;
	@NotNull
	private String descripcion;
	private Cliente cliente;
	
	public TransaccionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransaccionDto(Long id, @NotNull String ibanProp, @NotNull String ibanDest, @NotNull Double monto,
			@NotNull String descripcion, Cliente cliente) {
		super();
		this.id = id;
		this.ibanProp = ibanProp;
		this.ibanDest = ibanDest;
		this.monto = monto;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIbanProp() {
		return ibanProp;
	}

	public void setIbanProp(String ibanProp) {
		this.ibanProp = ibanProp;
	}

	public String getIbanDest() {
		return ibanDest;
	}

	public void setIbanDest(String ibanDest) {
		this.ibanDest = ibanDest;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
