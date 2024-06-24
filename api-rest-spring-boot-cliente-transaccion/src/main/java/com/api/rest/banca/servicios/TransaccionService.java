package com.api.rest.banca.servicios;

import java.util.List;

import com.api.rest.banca.dtos.TransaccionDto;

public interface TransaccionService {
	List<TransaccionDto> obtenerTransacciones();
	TransaccionDto crearNuevaTransaccion(TransaccionDto transaccionDto);
}
