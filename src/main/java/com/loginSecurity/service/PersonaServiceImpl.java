package com.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSecurity.entity.Persona;
import com.loginSecurity.repository.PersonaRepository;


@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired 
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> listarTodosLosProveedores() {
		return personaRepository.findAll();
	}

	@Override
	public Persona guardarProveedor(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona obtenerProveedorPorId(Long id) {
		return personaRepository.findById(id).get();
	}

	@Override
	public Persona actualizarProveedor(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void eliminarProveedor(Long id) {
		personaRepository.deleteById(id);
		
	}


}


