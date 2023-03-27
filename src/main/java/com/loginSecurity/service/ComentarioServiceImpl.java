package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Comentario;
import com.loginSecurity.repository.ComentarioRepository;



@Service
public class ComentarioServiceImpl implements ComentarioService{
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	@Override
	public List<Comentario> listarTodosLosProveedores() {
		return comentarioRepository.findAll();
	}

	@Override
	public Comentario guardarProveedor(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	@Override
	public Comentario obtenerProveedorPorId(Long id) {
		return comentarioRepository.findById(id).get();
	}

	@Override
	public Comentario actualizarProveedor(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	@Override
	public void eliminarProveedor(Long id) {
		comentarioRepository.deleteById(id);
		
	}


}
