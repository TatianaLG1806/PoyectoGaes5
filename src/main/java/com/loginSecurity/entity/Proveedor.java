package com.loginSecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="nombre", nullable = false,length = 50)
	private String nombre;
	
	@Column(name="apellido", nullable = false,length = 50)
	private String apellido;
	
	@Column(name="numDocumento", nullable = false,length = 50,unique = true)
	private String numDocumento;
	
	@Column(name="telefono", nullable = false,length = 50)
	private String telefono;
	
	@Column(name="email", nullable = false,length = 50,unique = true)
	private String email;
	
	@Column(name="estadoUsuario", nullable = false,length = 50)
	private String estadoUsuario;
	
	public Proveedor() {
		
	}

	public Proveedor(Long id, String nombre, String apellido, String numDocumento, String telefono, String email,
			String estadoUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDocumento = numDocumento;
		this.telefono = telefono;
		this.email = email;
		this.estadoUsuario = estadoUsuario;
	}
	
	public Proveedor(String nombre, String apellido, String numDocumento, String telefono, String email,
			String estadoUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDocumento = numDocumento;
		this.telefono = telefono;
		this.email = email;
		this.estadoUsuario = estadoUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String documento) {
		this.numDocumento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", numDocumento="
				+ numDocumento + ", telefono=" + telefono + ", email=" + email + ", estadoUsuario=" + estadoUsuario
				+ "]";
	}
	
	
	
	
	
	
}
