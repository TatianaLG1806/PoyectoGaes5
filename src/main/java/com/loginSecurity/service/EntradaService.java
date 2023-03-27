package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Entrada;



public interface EntradaService {
public List<Entrada> listarTodosLosProveedores();
	
	public Entrada guardarProveedor(Entrada entrada);
	
	public Entrada obtenerProveedorPorId(Long id);
	
	public Entrada actualizarProveedor(Entrada entrada);
	
	public void eliminarProveedor(Long id);
}
