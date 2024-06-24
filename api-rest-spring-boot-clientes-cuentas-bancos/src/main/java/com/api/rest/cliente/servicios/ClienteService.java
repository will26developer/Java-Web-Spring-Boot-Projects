package com.api.rest.cliente.servicios;

import java.util.List;

import com.api.rest.cliente.dtos.ClienteDto;

public interface ClienteService {
	List<ClienteDto> obtenerClientes();
	ClienteDto obtenerClientePorDni(String dni);
	ClienteDto crearCliente(ClienteDto clienteDto);
	ClienteDto actualizarCliente(String dni,ClienteDto clienteDto);
	ClienteDto eliminarCliente(String dni);
}
