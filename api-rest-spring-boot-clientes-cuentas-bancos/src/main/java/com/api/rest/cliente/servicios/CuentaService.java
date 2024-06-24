package com.api.rest.cliente.servicios;

import java.util.List;

import com.api.rest.cliente.dtos.CuentaDto;

public interface CuentaService {
	List<CuentaDto> obtenerCuentas();
	CuentaDto obtenerCuentaPorId(Long id);
	CuentaDto crearCuenta(CuentaDto cuentaDto);
	CuentaDto actualizarCuenta(Long id,CuentaDto cuentaDto);
	CuentaDto eliminarCuenta(Long id);
}
