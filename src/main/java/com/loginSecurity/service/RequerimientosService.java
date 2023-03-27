package com.loginSecurity.service;

import java.util.List;


import com.loginSecurity.entity.Requerimiento;



public interface RequerimientosService {
public List<Requerimiento> listarTodosLosProveedores();
	
	public Requerimiento guardarProveedor(Requerimiento requerimientos);
	
	public Requerimiento obtenerProveedorPorId(Long id);
	
	public Requerimiento actualizarProveedor(Requerimiento requerimientos);
	
	public void eliminarProveedor(Long id);

}
