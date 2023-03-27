package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Requerimiento;
import com.loginSecurity.repository.RequerimientosRepository;


@Service
public class RequerimientosServiceImpl implements RequerimientosService{
	
    @Autowired
    private RequerimientosRepository requerimientosRepository;

	@Override
	public List<Requerimiento> listarTodosLosProveedores() {
		return requerimientosRepository.findAll();
	}

	@Override
	public Requerimiento guardarProveedor(Requerimiento requerimientos) {
		return requerimientosRepository.save(requerimientos);
	}

	@Override
	public Requerimiento obtenerProveedorPorId(Long id) {
		return requerimientosRepository.findById(id).get();
	}

	@Override
	public Requerimiento actualizarProveedor(Requerimiento requerimientos) {
		return requerimientosRepository.save(requerimientos);
	}

	@Override
	public void eliminarProveedor(Long id) {
		requerimientosRepository.deleteById(id);
		
	}

	

}
