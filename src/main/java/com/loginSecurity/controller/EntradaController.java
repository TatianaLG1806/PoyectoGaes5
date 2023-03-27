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

import com.loginSecurity.entity.Entrada;

import com.loginSecurity.service.EntradaService;
import com.lowagie.text.DocumentException;



@Controller
public class EntradaController {
	
	@Autowired
	private EntradaService servicio;

	@GetMapping({ "/entradas" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("entradas", servicio.listarTodosLosProveedores());
		return "entradas";// Nos retorna al archivo proveedores
	}

	@GetMapping("/entradas/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Entrada entrada = new Entrada();
		modelo.addAttribute("entrada", entrada);
		return "crear_entrada";
	}

	@PostMapping("/entradas")
	public String guardarProveedor(@ModelAttribute("entrada") Entrada entrada) {
		servicio.guardarProveedor(entrada);
		return "redirect:/entradas";
	}

	@GetMapping("/entradas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("entrada", servicio.obtenerProveedorPorId(id));
		return "editar_entrada";
	}

	@PostMapping("/entradas/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("entrada") Entrada entrada,
			Model modelo) {
		Entrada entradaExistente = servicio.obtenerProveedorPorId(id);
		entradaExistente.setId(id);
		entradaExistente.setCantidad(entrada.getCantidad());
		entradaExistente.setFecha(entrada.getFecha());
		entradaExistente.setNit(entrada.getNit());
		entradaExistente.setNombre(entrada.getNombre());
		

		servicio.actualizarProveedor(entradaExistente);
		return "redirect:/entradas";
	}

	@GetMapping("/entradas/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/entradas";

	}
	@GetMapping("/exportarEntradaExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteEntradas" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Entrada> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.EntradaExporterExcel exporter = new com.loginSecurity.util.reportes.EntradaExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
	
	
}
