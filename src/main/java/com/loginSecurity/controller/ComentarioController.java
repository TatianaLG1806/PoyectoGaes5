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

import com.loginSecurity.entity.Comentario;

import com.loginSecurity.service.ComentarioService;
import com.lowagie.text.DocumentException;

@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioService servicio;
	
	@GetMapping({ "/comentarios" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("comentarios", servicio.listarTodosLosProveedores());
		return "comentarios";// Nos retorna al archivo proveedores
	}

	@GetMapping("/comentarios/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Comentario comentario = new Comentario();
		modelo.addAttribute("comentario", comentario);
		return "crear_comentario";
	}

	@PostMapping("/comentarios")
	public String guardarProveedor(@ModelAttribute("comentario") Comentario comentario) {
		servicio.guardarProveedor(comentario);
		return "redirect:/comentarios";
	}

	@GetMapping("/comentarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("comentario", servicio.obtenerProveedorPorId(id));
		return "editar_comentario";
	}

	@PostMapping("/comentarios/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("comentario") Comentario comentario,
			Model modelo) {
		Comentario comentarioExistente = servicio.obtenerProveedorPorId(id);
		comentarioExistente.setId(id);
		comentarioExistente.setMensaje(comentario.getMensaje());
		comentarioExistente.setAsunto(comentario.getAsunto());
		

		servicio.actualizarProveedor(comentarioExistente);
		return "redirect:/comentarios";
	}

	@GetMapping("/comentarios/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/comentarios";

	}
	@GetMapping("/exportarComentarioExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteComentarios" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Comentario> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.ComentarioExporterExcel exporter = new com.loginSecurity.util.reportes.ComentarioExporterExcel(proveedores);
		
		exporter.exportar(response);
	}

}
