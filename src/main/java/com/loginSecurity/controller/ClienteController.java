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

import com.loginSecurity.entity.Cliente;

import com.loginSecurity.service.ClienteServicio;
import com.loginSecurity.util.reportes.ClienteExporterExcel;
import com.lowagie.text.DocumentException;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteServicio servicio;

	@GetMapping({ "/clientes" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("clientes", servicio.listarTodosLosProveedores());
		return "clientes";// Nos retorna al archivo proveedores
	}

	@GetMapping("/clientes/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "crear_cliente";
	}

	@PostMapping("/clientes")
	public String guardarProveedor(@ModelAttribute("cliente") Cliente cliente) {
		servicio.guardarProveedor(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("cliente", servicio.obtenerProveedorPorId(id));
		return "editar_cliente";
	}

	@PostMapping("/clientes/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente,
			Model modelo) {
		Cliente clienteExistente = servicio.obtenerProveedorPorId(id);
		clienteExistente.setId(id);
		clienteExistente.setDocumento(cliente.getDocumento());
		clienteExistente.setEvento(cliente.getEvento());

		servicio.actualizarProveedor(clienteExistente);
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/clientes";

	}
	
	@GetMapping("/exportarClienteExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteClientes" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Cliente> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.ClienteExporterExcel exporter = new ClienteExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
}
