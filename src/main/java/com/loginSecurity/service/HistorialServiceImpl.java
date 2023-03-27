package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Historial;
import com.loginSecurity.repository.HistorialRepository;


@Service
public class HistorialServiceImpl implements HistorialService {
	
	@Autowired
	private HistorialRepository historialRepository;

	@Override
	public List<Historial> listarTodosLosProveedores() {
		return historialRepository.findAll();
	}

	@Override
	public Historial guardarProveedor(Historial historial) {
		return historialRepository.save(historial);
	}

	@Override
	public Historial obtenerProveedorPorId(Long id) {
		return historialRepository.findById(id).get();
	}

	@Override
	public Historial actualizarProveedor(Historial historial) {
		return historialRepository.save(historial);
	}

	@Override
	public void eliminarProveedor(Long id) {
		historialRepository.deleteById(id);
		
	}

	

}
