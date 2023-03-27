package com.loginSecurity.service;

import java.util.List;

import com.loginSecurity.entity.Proyecto;




public interface ProyectoService {
public List<Proyecto> listarTodosLosProveedores();
	
	public Proyecto guardarProveedor(Proyecto proyecto);
	
	public Proyecto obtenerProveedorPorId(Long id);
	
	public Proyecto actualizarProveedor(Proyecto proyecto);
	
	public void eliminarProveedor(Long id);

}
