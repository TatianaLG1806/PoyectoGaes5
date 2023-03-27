package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Entrada;
import com.loginSecurity.repository.EntradaRepository;


@Service
public class EntradaServiceImpl implements EntradaService {
	
	@Autowired
	private EntradaRepository entradaRepository;

	@Override
	public List<Entrada> listarTodosLosProveedores() {
		return entradaRepository.findAll();	
	}

	@Override
	public Entrada guardarProveedor(Entrada entrada) {
		return entradaRepository.save(entrada);
	}

	@Override
	public Entrada obtenerProveedorPorId(Long id) {
		return entradaRepository.findById(id).get();
	}

	@Override
	public Entrada actualizarProveedor(Entrada entrada) {
		return entradaRepository.save(entrada);
	}

	@Override
	public void eliminarProveedor(Long id) {
		entradaRepository.deleteById(id);
		
	}

	

}
