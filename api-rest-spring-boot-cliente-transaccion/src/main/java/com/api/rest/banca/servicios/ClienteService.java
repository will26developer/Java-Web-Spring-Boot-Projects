package com.api.rest.banca.servicios;

import java.util.List;
import com.api.rest.banca.dtos.ClienteDto;

public interface ClienteService { 
	List<ClienteDto> obtenerClientes();
	ClienteDto obtenerClientePorNif(String nif);
	ClienteDto crearCliente(ClienteDto clienteDto);
	ClienteDto actualizarCliente(String nif,ClienteDto clienteDto);
	ClienteDto borrarClientePorNif(String nif);
}
