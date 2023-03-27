package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Proyecto;
import com.loginSecurity.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Proyecto> listarTodosLosProveedores() {
		return proyectoRepository.findAll();
	}

	@Override
	public Proyecto guardarProveedor(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	public Proyecto obtenerProveedorPorId(Long id) {
		return proyectoRepository.findById(id).get();
	}

	@Override
	public Proyecto actualizarProveedor(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	public void eliminarProveedor(Long id) {
		proyectoRepository.deleteById(id);
		
	}

	

}
