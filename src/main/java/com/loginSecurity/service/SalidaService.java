package com.loginSecurity.service;

import java.util.List;


import com.loginSecurity.entity.Salida;



public interface SalidaService {
public List<Salida> listarTodosLosProveedores();
	
	public Salida guardarProveedor(Salida salida);
	
	public Salida obtenerProveedorPorId(Long id);
	
	public Salida actualizarProveedor(Salida salida);
	
	public void eliminarProveedor(Long id);
}
