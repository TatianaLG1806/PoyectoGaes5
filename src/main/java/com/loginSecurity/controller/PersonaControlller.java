package com.loginSecurity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginSecurity.entity.Persona;

import com.loginSecurity.service.PersonaService;
import com.lowagie.text.DocumentException;

@Controller
public class PersonaControlller {
	
	@Autowired
	private PersonaService servicio;
	
	@GetMapping({ "/personas" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("personas", servicio.listarTodosLosProveedores());
		return "personas";
	}

	@GetMapping("/personas/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Persona persona = new Persona();
		modelo.addAttribute("persona", persona);
		return "crear_persona";
	}

	@PostMapping("/personas")
	public String guardarProveedor(@ModelAttribute("persona") Persona persona) {
		servicio.guardarProveedor(persona);
		return "redirect:/personas";
	}

	@GetMapping("/personas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("persona", servicio.obtenerProveedorPorId(id));
		return "editar_persona";
	}

	@PostMapping("/personas/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("persona") Persona persona,
			Model modelo) {
		Persona personaExistente = servicio.obtenerProveedorPorId(id);
		personaExistente.setId(id);
		personaExistente.setDocumento(persona.getDocumento());
		personaExistente.setNombres(persona.getNombres());
		personaExistente.setApellidos(persona.getApellidos());
		personaExistente.setCiudad(persona.getCiudad());
		personaExistente.setDireecion(persona.getDireecion());
		personaExistente.setTelefono(persona.getTelefono());
		personaExistente.setEmail(persona.getEmail());
		

		servicio.actualizarProveedor(personaExistente);
		return "redirect:/personas";
	}

	@GetMapping("/personas/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/personas";

	}
	
	@GetMapping("/exportarPersonaExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReportePersonas" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Persona> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.PersonaExporterExcel exporter = new com.loginSecurity.util.reportes.PersonaExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
	

}
