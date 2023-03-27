package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Proveedor;



public interface ProveedorServicio {
	
	public List<Proveedor> listarTodosLosProveedores();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor obtenerProveedorPorId(Long id);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(Long id);
	
}
