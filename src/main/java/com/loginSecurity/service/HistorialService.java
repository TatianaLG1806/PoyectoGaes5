package com.loginSecurity.service;

import java.util.List;


import com.loginSecurity.entity.Historial;


public interface HistorialService {
public List<Historial> listarTodosLosProveedores();
	
	public Historial guardarProveedor(Historial historial);
	
	public Historial obtenerProveedorPorId(Long id);
	
	public Historial actualizarProveedor(Historial historial);
	
	public void eliminarProveedor(Long id);
}
