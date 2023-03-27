package com.loginSecurity.service;

import java.util.List;


import com.loginSecurity.entity.Empleado;


public interface EmpleadoService {
public List<Empleado> listarTodosLosProveedores();
	
	public Empleado guardarProveedor(Empleado empleado);
	
	public Empleado obtenerProveedorPorId(Long id);
	
	public Empleado actualizarProveedor(Empleado empleado);
	
	public void eliminarProveedor(Long id);
	
}
