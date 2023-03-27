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

import com.loginSecurity.service.ProveedorServicio;
import com.lowagie.text.DocumentException;





@Controller
public class ProveedorControlador {

	@Autowired
	private ProveedorServicio servicio;
   

	@GetMapping({ "/proveedores" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("proveedores", servicio.listarTodosLosProveedores());
		return "proveedores";// Nos retorna al archivo proveedores
	}

	@GetMapping("/proveedores/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Proveedor proveedor = new Proveedor();
		modelo.addAttribute("proveedor", proveedor);
		return "crear_proveedor";
	}

	@PostMapping("/proveedores")
	public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
		servicio.guardarProveedor(proveedor);
		return "redirect:/proveedores";
	}

	@GetMapping("/proveedores/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("proveedor", servicio.obtenerProveedorPorId(id));
		return "editar_proveedor";
	}

	@PostMapping("/proveedores/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("proveedor") Proveedor proveedor,
			Model modelo) {
		Proveedor proveedorExistente = servicio.obtenerProveedorPorId(id);
		proveedorExistente.setId(id);
		proveedorExistente.setNombre(proveedor.getNombre());
		proveedorExistente.setApellido(proveedor.getApellido());
		proveedorExistente.setNumDocumento(proveedor.getNumDocumento());
		proveedorExistente.setTelefono(proveedor.getTelefono());
		proveedorExistente.setEmail(proveedor.getEmail());
		proveedorExistente.setEstadoUsuario(proveedor.getEstadoUsuario());

		servicio.actualizarProveedor(proveedorExistente);
		return "redirect:/proveedores";
	}

	@GetMapping("/proveedores/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/proveedores";

	}
	@GetMapping("/exportarProveedorExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteProveedores" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Proveedor> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.ProveedorExporterExcel exporter = new com.loginSecurity.util.reportes.ProveedorExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
	

}
