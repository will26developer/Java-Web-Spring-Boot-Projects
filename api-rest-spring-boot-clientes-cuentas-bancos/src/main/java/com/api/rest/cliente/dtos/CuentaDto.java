package com.api.rest.cliente.dtos;

import com.api.rest.cliente.entidades.Cliente;

import jakarta.validation.constraints.NotNull;

public class CuentaDto {

	private Long idCuenta;
	@NotNull
	private String dniClienteDto; 
	@NotNull
	private Long idBancoDto;
	@NotNull
	private Double saldoCuenta;
	
	public CuentaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getDniClienteDto() {
		return dniClienteDto;
	}

	public void setDniClienteDto(String dniClienteDto) {
		this.dniClienteDto = dniClienteDto;
	}

	public Long getIdBancoDto() {
		return idBancoDto;
	}

	public void setIdBancoDto(Long idBancoDto) {
		this.idBancoDto = idBancoDto;
	}

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	
	
}
