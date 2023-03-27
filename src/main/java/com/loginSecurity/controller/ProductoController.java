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

import com.loginSecurity.entity.Producto;

import com.loginSecurity.service.ProductoService;
import com.lowagie.text.DocumentException;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	
	@GetMapping({ "/productos" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("productos", servicio.listarTodosLosProveedores());
		return "productos";// Nos retorna al archivo proveedores
	}

	@GetMapping("/productos/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("producto", producto);
		return "crear_producto";
	}

	@PostMapping("/productos")
	public String guardarProveedor(@ModelAttribute("proveedor") Producto producto) {
		servicio.guardarProveedor(producto);
		return "redirect:/productos";
	}

	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.obtenerProveedorPorId(id));
		return "editar_producto";
	}

	@PostMapping("/productos/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("producto") Producto producto,
			Model modelo) {
		Producto productoExistente = servicio.obtenerProveedorPorId(id);
		productoExistente.setId(id);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setDescripcion(producto.getDescripcion());
		
		servicio.actualizarProveedor(productoExistente);
		return "redirect:/productos";
	}

	@GetMapping("/productos/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/productos";

	}
	@GetMapping("/exportarProductoExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteProductos" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Producto> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.ProductoExporterExcel exporter = new com.loginSecurity.util.reportes.ProductoExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
	
}
