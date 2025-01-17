package com.api.rest.cliente.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.cliente.dtos.CuentaDto;
import com.api.rest.cliente.entidades.Banco;
import com.api.rest.cliente.entidades.Cliente;
import com.api.rest.cliente.entidades.Cuenta;
import com.api.rest.cliente.repositorios.BancoRepository;
import com.api.rest.cliente.repositorios.ClienteRepository;
import com.api.rest.cliente.repositorios.CuentaRepository;
import com.api.rest.cliente.servicios.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService { 
	@Autowired
	private BancoRepository bancoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private CuentaRepository cuentaRepository;

	@Override
	public List<CuentaDto> obtenerCuentas() {
		List<CuentaDto> cuentas=new ArrayList<CuentaDto>();
		for (Cuenta cuenta:cuentaRepository.findAll()) cuentas.add(convertirADto(cuenta)); 
		return cuentas;
	}

	@Override
	public CuentaDto obtenerCuentaPorId(Long id) {
		CuentaDto cuentaDto=convertirADto(cuentaRepository.findById(id).orElseThrow()); 
		if (cuentaDto != null) return cuentaDto;
		return null;
	}

	@Override
	public CuentaDto crearCuenta(CuentaDto cuentaDto) {
		Cliente cliente=clienteRepository.findClienteByDniCliente(cuentaDto.getDniClienteDto());
		Banco banco=bancoRepository.findById(cuentaDto.getIdBancoDto()).orElseThrow();
		if (cliente != null && banco != null) {
			Cuenta cuenta=new Cuenta();
			cuenta.setCliente(cliente);
			cuenta.setBanco(banco);
			cuenta.setSaldoCuenta(cuentaDto.getSaldoCuenta());
			cuentaRepository.save(cuenta);
			return cuentaDto;
		}
		return null;
	}

	@Override
	public CuentaDto actualizarCuenta(Long id, CuentaDto cuentaDto) {
		Banco banco=bancoRepository.findById(cuentaDto.getIdBancoDto()).orElseThrow();
		Cliente cliente=clienteRepository.findClienteByDniCliente(cuentaDto.getDniClienteDto());
		Cuenta cuenta=cuentaRepository.findById(id).orElseThrow();
		if (cuenta != null && banco != null && cliente != null) {
			cuenta.setSaldoCuenta(cuentaDto.getSaldoCuenta());
			cuentaRepository.save(cuenta);
			return cuentaDto;
		}
		return null;
	}

	@Override
	public CuentaDto eliminarCuenta(Long id) {
		Cuenta cuenta=cuentaRepository.findById(id).orElseThrow();
		if (cuenta != null) {
			cuentaRepository.delete(cuenta);
			return convertirADto(cuenta);
		}
		return null;
	}

	private CuentaDto convertirADto(Cuenta cuenta) {
		CuentaDto cuentaDto=new CuentaDto();
		cuentaDto.setIdCuenta(cuenta.getIdCuenta());
		cuentaDto.setDniClienteDto(cuenta.getCliente().getDniCliente());
		cuentaDto.setIdBancoDto(cuenta.getBanco().getIdBanco());
		cuentaDto.setSaldoCuenta(cuenta.getSaldoCuenta());
		return cuentaDto;
	}
	
	private Cuenta convertirAEntidad(CuentaDto cuentaDto) {
		Cuenta cuenta=new Cuenta();
		cuenta.setIdCuenta(cuentaDto.getIdCuenta());
		cuenta.setSaldoCuenta(cuentaDto.getSaldoCuenta());
		return cuenta;
	}
}
