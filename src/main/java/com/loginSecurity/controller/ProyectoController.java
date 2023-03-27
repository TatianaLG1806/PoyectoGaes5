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

import com.loginSecurity.entity.Proveedor;
import com.loginSecurity.entity.Proyecto;
import com.loginSecurity.service.ProyectoService;
import com.lowagie.text.DocumentException;

@Controller
public class ProyectoController {
	
	@Autowired
	private ProyectoService servicio;
	
	
	@GetMapping({ "/proyectos" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("proyectos", servicio.listarTodosLosProveedores());
		return "proyectos";// 
	}

	@GetMapping("/proyectos/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Proyecto proyecto = new Proyecto();
		modelo.addAttribute("proyecto", proyecto);
		return "crear_proyecto";
	}

	@PostMapping("/proyectos")
	public String guardarProveedor(@ModelAttribute("proyecto") Proyecto proyecto) {
		servicio.guardarProveedor(proyecto);
		return "redirect:/proyectos";
	}

	@GetMapping("/proyectos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("proyecto", servicio.obtenerProveedorPorId(id));
		return "editar_proyecto";
	}

	@PostMapping("/proyectos/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("proyecto") Proyecto proyecto,
			Model modelo) {
		Proyecto proyectoExistente = servicio.obtenerProveedorPorId(id);
		proyectoExistente.setId(id);
		proyectoExistente.setNombre(proyecto.getNombre());
		proyectoExistente.setPresupuesto(proyecto.getPresupuesto());
		proyectoExistente.setTiempo(proyecto.getTiempo());
		
		servicio.actualizarProveedor(proyectoExistente);
		return "redirect:/proyectos";
	}

	@GetMapping("/proyectos/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/proyectos";

	}
	@GetMapping("/exportarProyectoExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteProyectos" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Proyecto> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.ProyectoExporterExcel exporter = new com.loginSecurity.util.reportes.ProyectoExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	

}
