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


import com.loginSecurity.entity.Requerimiento;
import com.loginSecurity.service.RequerimientosService;
import com.lowagie.text.DocumentException;

@Controller
public class RequerimientosController {
	
	@Autowired
	private RequerimientosService servicio;
	
	@GetMapping({ "/requerimientos" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("requerimientos", servicio.listarTodosLosProveedores());
		return "requerimientos";// Nos retorna al archivo proveedores
	}

	@GetMapping("/requerimientos/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Requerimiento requerimientos = new Requerimiento();
		modelo.addAttribute("requerimiento", requerimientos);
		return "crear_requerimiento";
	}

	@PostMapping("/requerimientos")
	public String guardarProveedor(@ModelAttribute("requerimiento") Requerimiento requerimientos) {
		servicio.guardarProveedor(requerimientos);
		return "redirect:/requerimientos";
	}

	@GetMapping("/requerimientos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("requerimiento", servicio.obtenerProveedorPorId(id));
		return "editar_requerimiento";
	}

	@PostMapping("/requerimientos/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("requerimiento") Requerimiento requerimientos,
			Model modelo) {
		Requerimiento requerimientosExistente = servicio.obtenerProveedorPorId(id);
		requerimientosExistente.setId(id);
		requerimientosExistente.setCodigoproyecto(requerimientos.getCodigoproyecto());
		requerimientosExistente.setProducto(requerimientos.getProducto());
		requerimientosExistente.setCantidad(requerimientos.getCantidad());
		
		servicio.actualizarProveedor(requerimientosExistente);
		return "redirect:/requerimientos";
	}

	@GetMapping("/requerimientos/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/requerimientos";

	}
	@GetMapping("/exportarRequerimientoExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteRequerimientos" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Requerimiento> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.RequerimientosExporterExcel exporter = new com.loginSecurity.util.reportes.RequerimientosExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	

}
