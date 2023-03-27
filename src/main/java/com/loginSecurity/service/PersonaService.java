package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Persona;







public interface PersonaService {
public List<Persona> listarTodosLosProveedores();
	
	public Persona guardarProveedor(Persona persona);
	
	public Persona obtenerProveedorPorId(Long id);
	
	public Persona actualizarProveedor(Persona persona);
	
	public void eliminarProveedor(Long id);
}
