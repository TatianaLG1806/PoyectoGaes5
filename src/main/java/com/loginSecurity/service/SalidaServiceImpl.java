package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Salida;
import com.loginSecurity.repository.SalidaRepository;

@Service
public class SalidaServiceImpl implements SalidaService {
	
	@Autowired
	private SalidaRepository salidaRepository;

	@Override
	public List<Salida> listarTodosLosProveedores() {
		return salidaRepository.findAll();
	}

	@Override
	public Salida guardarProveedor(Salida salida) {
		return salidaRepository.save(salida);
	}

	@Override
	public Salida obtenerProveedorPorId(Long id) {
		return salidaRepository.findById(id).get();
	}

	@Override
	public Salida actualizarProveedor(Salida salida) {
		return salidaRepository.save(salida);
	}

	@Override
	public void eliminarProveedor(Long id) {
		salidaRepository.deleteById(id);
		
	}

	

	
}
