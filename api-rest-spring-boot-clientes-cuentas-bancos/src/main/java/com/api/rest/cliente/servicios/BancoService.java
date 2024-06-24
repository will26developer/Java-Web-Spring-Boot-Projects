package com.api.rest.cliente.servicios;

import java.util.List;

import com.api.rest.cliente.dtos.BancoDto;

public interface BancoService {
	List<BancoDto> obtenerBancos();
	BancoDto obtenerBancoPorNombre(String nombre); 
	BancoDto crearBanco(BancoDto bancoDto);
	BancoDto actualizarBanco(String nombre,BancoDto bancoDto); 
	BancoDto eliminarBanco(String nombre);
}
