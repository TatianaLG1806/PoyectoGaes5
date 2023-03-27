package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Producto;
import com.loginSecurity.entity.Proveedor;




 
public interface ProductoService {
public List<Producto> listarTodosLosProveedores();
	
	public Producto guardarProveedor(Producto producto);
	
	public Producto obtenerProveedorPorId(Long id);
	
	public Producto actualizarProveedor(Producto producto);
	
	public void eliminarProveedor(Long id);
}
