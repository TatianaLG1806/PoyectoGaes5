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

import com.loginSecurity.entity.Empleado;
import com.loginSecurity.entity.Proveedor;
import com.loginSecurity.service.EmpleadoService;
import com.lowagie.text.DocumentException;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping({ "/empleados" })
	public String listarProveedores(Model modelo) {
		modelo.addAttribute("empleados", servicio.listarTodosLosProveedores());
		return "empleados";// Nos retorna al archivo proveedores
	}

	@GetMapping("/empleados/nuevo")
	public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
		Empleado empleado = new Empleado();
		modelo.addAttribute("empleado", empleado);
		return "crear_empleado";
	}

	@PostMapping("/empleados")
	public String guardarProveedor(@ModelAttribute("empleado") Empleado empleado) {
		servicio.guardarProveedor(empleado);
		return "redirect:/empleados";
	}

	@GetMapping("/empleados/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerProveedorPorId(id));
		return "editar_empleado";
	}

	@PostMapping("/empleados/{id}")
	public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado,
			Model modelo) {
		Empleado empleadoExistente = servicio.obtenerProveedorPorId(id);
		empleadoExistente.setId(id);
		empleadoExistente.setNombre(empleado.getNombre());
		empleadoExistente.setApellido(empleado.getApellido());
		
		empleadoExistente.setTelefono(empleado.getTelefono());
		empleadoExistente.setEmail(empleado.getEmail());
		empleadoExistente.setSalario(empleado.getSalario());

		servicio.actualizarProveedor(empleadoExistente);
		return "redirect:/empleados";
	}

	@GetMapping("/empleados/{id}")
	public String eliminarProveedor(@PathVariable Long id) {
		servicio.eliminarProveedor(id);
		return "redirect:/empleados";

	}
	@GetMapping("/exportarEmpleadoExcel")
	public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		

		/*
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		*/
		
		String cacebera = "Content-Disposition";
		String valor = "attachment; filename=ReporteEmpleados" + ".xlsx";
		
		response.setHeader(cacebera, valor);
		
		List<Empleado> proveedores = servicio.listarTodosLosProveedores();
		
		com.loginSecurity.util.reportes.EmpleadoExporterExcel exporter = new com.loginSecurity.util.reportes.EmpleadoExporterExcel(proveedores);
		
		exporter.exportar(response);
	}
	
}
