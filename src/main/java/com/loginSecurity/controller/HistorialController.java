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

import com.loginSecurity.entity.Historial;
import com.loginSecurity.entity.Proveedor;
import com.loginSecurity.service.HistorialService;
import com.lowagie.text.DocumentException;

@Controller
public class HistorialController {
	
	@Autowired
	private HistorialService servicio;
	
	
	@GetMapping({ "/historiales" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("historiales", servicio.listarTodosLosProveedores());
		return "historiales";// Nos retorna al archivo proveedores
	}

	@GetMapping("/historiales/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Historial historial = new Historial();
		modelo.addAttribute("historial", historial);
		return "crear_historial";
	}

	@PostMapping("/historiales")
	public String guardarProveedor(@ModelAttribute("historial") Historial historial) {
		servicio.guardarProveedor(historial);
		return "redirect:/historiales";
	}

	@GetMapping("/historiales/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("historial", servicio.obtenerProveedorPorId(id));
		return "editar_historial";
	}

	@PostMapping("/historiales/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("historial") Historial historial,
			Model modelo) {
		Historial historialExistente = servicio.obtenerProveedorPorId(id);
		historialExistente.setId(id);
		historialExistente.setProductoadquirido(historial.getProductoadquirido());
		historialExistente.setValor(historial.getValor());
	
		servicio.actualizarProveedor(historialExistente);
		return "redirect:/historiales";
	}

	@GetMapping("/historiales/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/historiales";

	}
	@GetMapping("/exportarHistorialExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteHistorial" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Historial> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.HistorialExporterExcel exporter = new com.loginSecurity.util.reportes.HistorialExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
	
}
