package com.api.rest.banca.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.banca.dtos.ClienteDto;
import com.api.rest.banca.entidades.Cliente;
import com.api.rest.banca.repositorios.ClienteRepository;
import com.api.rest.banca.servicios.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDto> obtenerClientes() {
		List<ClienteDto> clientes=new ArrayList<ClienteDto>();
		for (Cliente cliente:clienteRepository.findAll()) clientes.add(convertirADto(cliente));
		return clientes;
	}

	@Override
	public ClienteDto obtenerClientePorNif(String nif) {
		ClienteDto clienteDtoEnc=convertirADto(clienteRepository.findClienteByNif(nif));
		if (clienteDtoEnc != null) return clienteDtoEnc;
		return null;
	}

	@Override
	public ClienteDto crearCliente(ClienteDto clienteDto) {
		Cliente clienteEnc=clienteRepository.findClienteByNif(clienteDto.getNif());
		if (clienteEnc != null) {
			clienteRepository.save(convertirAEntidad(clienteDto));
			return clienteDto;
		}
		return null;
	}

	@Override
	public ClienteDto actualizarCliente(String nif, ClienteDto clienteDto) {
		Cliente clienteEnc=clienteRepository.findClienteByNif(nif);
		if (clienteEnc != null) {
			clienteEnc.setId(clienteDto.getId());
			clienteEnc.setNombre(clienteDto.getNombre());
			clienteEnc.setApellidos(clienteDto.getApellidos());
			clienteEnc.setEdad(clienteDto.getEdad());
			clienteEnc.setEmail(clienteDto.getEmail()); 
			clienteEnc.setNif(clienteDto.getNif());
			clienteEnc.setIban(clienteDto.getIban());
			clienteEnc.setSaldo(clienteDto.getSaldo());
			clienteEnc.setTransacciones(clienteDto.getTransacciones());
			clienteRepository.save(clienteEnc); 
			return convertirADto(clienteEnc);
		}
		return null;
	}

	@Override
	public ClienteDto borrarClientePorNif(String nif) {
		Cliente clienteEnc=clienteRepository.findClienteByNif(nif);
		if (clienteEnc != null) {
			clienteRepository.delete(clienteEnc);
			return convertirADto(clienteEnc);
		}
		return null;
	}
	
	private ClienteDto convertirADto(Cliente cliente) {
		ClienteDto clienteDto=new ClienteDto();
		clienteDto.setId(cliente.getId());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellidos(cliente.getApellidos());
		clienteDto.setEdad(cliente.getEdad());
		clienteDto.setEmail(cliente.getEmail()); 
		clienteDto.setNif(cliente.getNif());
		clienteDto.setIban(cliente.getIban());
		clienteDto.setSaldo(cliente.getSaldo());
		clienteDto.setTransacciones(cliente.getTransacciones());
		return clienteDto;
	}
	
	private Cliente convertirAEntidad(ClienteDto clienteDto) {
		Cliente cliente=new Cliente();
		cliente.setId(clienteDto.getId());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setApellidos(clienteDto.getApellidos());
		cliente.setEdad(clienteDto.getEdad());
		cliente.setEmail(clienteDto.getEmail()); 
		cliente.setNif(clienteDto.getNif());
		cliente.setIban(clienteDto.getIban());
		cliente.setSaldo(clienteDto.getSaldo());
		cliente.setTransacciones(clienteDto.getTransacciones());
		return cliente;
	}
}
