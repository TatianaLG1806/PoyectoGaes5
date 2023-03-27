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


import com.loginSecurity.entity.Salida;
import com.loginSecurity.service.SalidaService;
import com.lowagie.text.DocumentException;

@Controller
public class SalidaController {
	
	@Autowired
	private SalidaService servicio;
	
	@GetMapping({ "/salidas" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("salidas", servicio.listarTodosLosProveedores());
		return "salidas";// Nos retorna al archivo proveedores
	}

	@GetMapping("/salidas/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Salida salida = new Salida();
		modelo.addAttribute("salida", salida);
		return "crear_salida";
	}

	@PostMapping("/salidas")
	public String guardarProveedor(@ModelAttribute("salida") Salida salida) {
		servicio.guardarProveedor(salida);
		return "redirect:/salidas";
	}

	@GetMapping("/salidas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("salida", servicio.obtenerProveedorPorId(id));
		return "editar_salida";
	}

	@PostMapping("/salidas/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("salida") Salida salida,
			Model modelo) {
		Salida salidaExistente = servicio.obtenerProveedorPorId(id);
		salidaExistente.setId(id);
		salidaExistente.setCantidad(salida.getCantidad());
		salidaExistente.setNombreproyecto(salida.getNombreproyecto());
		
		servicio.actualizarProveedor(salidaExistente);
		return "redirect:/salidas";
	}

	@GetMapping("/salidas/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/salidas";

	}
	@GetMapping("/exportarSalidaExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteSalidas" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Salida> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.SalidaExporterExcel exporter = new com.loginSecurity.util.reportes.SalidaExporterExcel(proveedores);
		
		exporter.exportar(response);
	}

}
