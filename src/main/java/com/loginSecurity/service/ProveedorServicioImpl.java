package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Proveedor;
import com.loginSecurity.repository.ProveedorRepositorio;



@Service
public class ProveedorServicioImpl implements ProveedorServicio {

	@Autowired
	private ProveedorRepositorio repositorio;

	@Override
	public List<Proveedor> listarTodosLosProveedores() {
		return repositorio.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return repositorio.save(proveedor);
	}

	@Override
	public Proveedor obtenerProveedorPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return repositorio.save(proveedor);
	}

	@Override
	public void eliminarProveedor(Long id) {
		repositorio.deleteById(id);
	}



	

}
