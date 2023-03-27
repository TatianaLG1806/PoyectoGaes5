package com.loginSecurity.service;

import java.util.List;




import com.loginSecurity.entity.Comentario;




public interface ComentarioService {
	public List<Comentario> listarTodosLosProveedores();
	
	public Comentario guardarProveedor(Comentario comentario);
	
	public Comentario obtenerProveedorPorId(Long id);
	
	public Comentario actualizarProveedor(Comentario comentario);
	
	public void eliminarProveedor(Long id);

}
