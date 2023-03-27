package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Cliente;
import com.loginSecurity.repository.ClienteRepository;


@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	private ClienteRepository clienterepository;

	@Override
	public List<Cliente> listarTodosLosProveedores() {
		return clienterepository.findAll();
	}

	@Override
	public Cliente guardarProveedor(Cliente cliente) {
		return clienterepository.save(cliente);
	}

	@Override
	public Cliente obtenerProveedorPorId(Long id) {
		return clienterepository.findById(id).get();
	}

	@Override
	public Cliente actualizarProveedor(Cliente cliente) {
		return clienterepository.save(cliente);
	}

	@Override
	public void eliminarProveedor(Long id) {
		clienterepository.deleteById(id);
		
	}

	

	
	
	

}
