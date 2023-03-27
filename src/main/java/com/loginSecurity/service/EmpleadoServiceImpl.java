package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Empleado;
import com.loginSecurity.repository.EmpleadoRepository;



@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarTodosLosProveedores() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado guardarProveedor(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado obtenerProveedorPorId(Long id) {
		return empleadoRepository.findById(id).get();
	}

	@Override
	public Empleado actualizarProveedor(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarProveedor(Long id) {
		empleadoRepository.deleteById(id);
		
	}
	
	
	
}
