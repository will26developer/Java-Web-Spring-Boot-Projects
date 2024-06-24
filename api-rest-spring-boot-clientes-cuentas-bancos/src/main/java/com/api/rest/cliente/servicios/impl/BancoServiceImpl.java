package com.api.rest.cliente.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.cliente.dtos.BancoDto;
import com.api.rest.cliente.entidades.Banco;
import com.api.rest.cliente.repositorios.BancoRepository;
import com.api.rest.cliente.servicios.BancoService;

@Service
public class BancoServiceImpl implements BancoService { 
	@Autowired 
	private BancoRepository bancoRepository;

	@Override
	public List<BancoDto> obtenerBancos() {
		List<BancoDto> bancos=new ArrayList<>();
		for (Banco banco:bancoRepository.findAll()) bancos.add(convertirADto(banco));
		return bancos;
	}

	@Override
	public BancoDto obtenerBancoPorNombre(String nombre) {
		BancoDto bancoDto=convertirADto(bancoRepository.findBancoByNombreBanco(nombre));
		if (bancoDto != null) return bancoDto;
		return null;
	}

	@Override
	public BancoDto crearBanco(BancoDto bancoDto) {
		Banco banco=bancoRepository.findBancoByNombreBanco(bancoDto.getNombreBanco()); 
		if (banco == null) {
			bancoRepository.save(convertirAEntidad(bancoDto)); 
			return bancoDto;
		}
		return null;
	}

	@Override
	public BancoDto actualizarBanco(String nombre, BancoDto bancoDto) {
		Banco banco=bancoRepository.findBancoByNombreBanco(nombre); 
		if (banco != null) {
			banco.setIdBanco(bancoDto.getIdBanco());
			banco.setNombreBanco(bancoDto.getNombreBanco());
			banco.setCiudadBanco(bancoDto.getCiudadBanco());
			banco.setCuentas(banco.getCuentas());
			bancoRepository.save(banco);
			return bancoDto;
		}
		return null;
	}

	@Override
	public BancoDto eliminarBanco(String nombre) {
		Banco banco=bancoRepository.findBancoByNombreBanco(nombre);
		if (banco != null) {
			bancoRepository.delete(banco);
			return convertirADto(banco);
		}
		return null;
	}
	
	private BancoDto convertirADto(Banco banco) {
		BancoDto bancoDto=new BancoDto(); 
		bancoDto.setIdBanco(banco.getIdBanco());
		bancoDto.setNombreBanco(banco.getNombreBanco());
		bancoDto.setCiudadBanco(banco.getCiudadBanco());
		bancoDto.setCuentas(banco.getCuentas());
		return bancoDto;
	}
	
	private Banco convertirAEntidad(BancoDto bancoDto) {
		Banco banco=new Banco();
		banco.setIdBanco(bancoDto.getIdBanco());
		banco.setNombreBanco(bancoDto.getNombreBanco());
		banco.setCiudadBanco(bancoDto.getCiudadBanco());
		banco.setCuentas(bancoDto.getCuentas());
		return banco;
	}
}
