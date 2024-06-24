package com.api.rest.banca.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.banca.dtos.TransaccionDto;
import com.api.rest.banca.entidades.Cliente;
import com.api.rest.banca.entidades.Transaccion;
import com.api.rest.banca.repositorios.ClienteRepository;
import com.api.rest.banca.repositorios.TransaccionRepository;
import com.api.rest.banca.servicios.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService {
	@Autowired
	private TransaccionRepository transaccionRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<TransaccionDto> obtenerTransacciones() {
		List<TransaccionDto> transacciones=new ArrayList<>();
		for (Transaccion transaccion:transaccionRepository.findAll()) transacciones.add(convertirADto(transaccion));
		return transacciones;
	}
	@Override
	public TransaccionDto crearNuevaTransaccion(TransaccionDto transaccionDto) {
		Cliente clientIban1=clienteRepository.findClienteByIban(transaccionDto.getIbanProp());
		Cliente clienteIban2=clienteRepository.findClienteByIban(transaccionDto.getIbanDest());
		if ((clientIban1 != null && clienteIban2 != null) && clientIban1.getSaldo() >= transaccionDto.getMonto()) {
			clientIban1.setSaldo(clientIban1.getSaldo() - transaccionDto.getMonto());
			clienteIban2.setSaldo(clienteIban2.getSaldo() + transaccionDto.getMonto());
			clienteRepository.save(clientIban1);
			clienteRepository.save(clienteIban2);
			transaccionRepository.save(convertirAEntidad(transaccionDto));
			return transaccionDto;
		}
		return null;
	}
	
	private TransaccionDto convertirADto(Transaccion transaccion) {
		TransaccionDto transaccionDto=new TransaccionDto();
		transaccionDto.setId(transaccion.getId());
		transaccionDto.setIbanProp(transaccion.getIbanProp());
		transaccionDto.setIbanDest(transaccion.getIbanDest()); 
		transaccionDto.setMonto(transaccion.getMonto());
		transaccionDto.setDescripcion(transaccion.getDescripcion());
		transaccionDto.setCliente(transaccion.getCliente()); 
		return transaccionDto;
	}
	
	private Transaccion convertirAEntidad(TransaccionDto transaccionDto) {
		Transaccion transaccion=new Transaccion();
		transaccion.setId(transaccionDto.getId());
		transaccion.setIbanProp(transaccionDto.getIbanProp());
		transaccion.setIbanDest(transaccionDto.getIbanDest()); 
		transaccion.setMonto(transaccionDto.getMonto());
		transaccion.setDescripcion(transaccionDto.getDescripcion());
		transaccion.setCliente(transaccionDto.getCliente()); 
		return transaccion;
	}
}
