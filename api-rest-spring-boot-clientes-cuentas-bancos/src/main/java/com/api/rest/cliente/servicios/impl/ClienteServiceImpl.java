package com.api.rest.cliente.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.cliente.dtos.ClienteDto;
import com.api.rest.cliente.entidades.Cliente;
import com.api.rest.cliente.repositorios.ClienteRepository;
import com.api.rest.cliente.servicios.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDto> obtenerClientes() {
		List<ClienteDto> clientes=new ArrayList<>();
		for (Cliente cliente:clienteRepository.findAll()) clientes.add(convertirADto(cliente));
		return clientes;
	}

	@Override
	public ClienteDto obtenerClientePorDni(String dni) {
		ClienteDto clienteDto=convertirADto(clienteRepository.findClienteByDniCliente(dni)); 
		if (clienteDto != null) return clienteDto;
		return null;
	}

	@Override
	public ClienteDto crearCliente(ClienteDto clienteDto) {
		Cliente cliente=clienteRepository.findClienteByDniCliente(clienteDto.getDniCliente()); 
		if (cliente == null) {
			clienteRepository.save(convertirAEntidad(clienteDto));
			return clienteDto;
		}
		return null;
	}

	@Override
	public ClienteDto actualizarCliente(String dni, ClienteDto clienteDto) {
		Cliente cliente=clienteRepository.findClienteByDniCliente(dni);
		if (cliente != null) {
			cliente.setDniCliente(clienteDto.getDniCliente());
			cliente.setNombreCliente(clienteDto.getNombreCliente());
			cliente.setDireccionCliente(cliente.getDireccionCliente());
			cliente.setCuentas(cliente.getCuentas());
			clienteRepository.save(cliente);
			return clienteDto;
		}
		return null;
	}

	@Override
	public ClienteDto eliminarCliente(String dni) {
		Cliente cliente=clienteRepository.findClienteByDniCliente(dni);
		if (cliente != null) {
			clienteRepository.delete(cliente);
			return convertirADto(cliente);
		}
		return null;
	}
	
	private ClienteDto convertirADto(Cliente cliente) {
		ClienteDto clienteDto=new ClienteDto();
		clienteDto.setDniCliente(cliente.getDniCliente());
		clienteDto.setNombreCliente(cliente.getNombreCliente());
		clienteDto.setDireccionCliente(cliente.getDireccionCliente());
		clienteDto.setCuentas(cliente.getCuentas());
		return clienteDto;
	}

	private Cliente convertirAEntidad(ClienteDto clienteDto) {
		Cliente cliente=new Cliente(); 
		cliente.setDniCliente(clienteDto.getDniCliente());
		cliente.setNombreCliente(clienteDto.getNombreCliente());
		cliente.setDireccionCliente(clienteDto.getDireccionCliente());
		cliente.setCuentas(clienteDto.getCuentas());
		return cliente;
	}
}
