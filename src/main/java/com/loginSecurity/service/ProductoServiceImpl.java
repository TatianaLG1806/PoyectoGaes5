package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Producto;
import com.loginSecurity.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> listarTodosLosProveedores() {
		return productoRepository.findAll();
	}
	

	@Override
	public Producto guardarProveedor(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto obtenerProveedorPorId(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public Producto actualizarProveedor(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void eliminarProveedor(Long id) {
		productoRepository.deleteById(id);
		
	}
	

	

}
