package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Cliente;



public interface ClienteServicio {
	public List<Cliente> listarTodosLosProveedores();
	
	public Cliente guardarProveedor(Cliente cliente);
	
	public Cliente obtenerProveedorPorId(Long id);
	
	public Cliente actualizarProveedor(Cliente cliente);
	
	public void eliminarProveedor(Long id);

}
