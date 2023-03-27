package com.loginSecurity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String documento;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	
	private Date fecha;
	@Column
	private String ciudad;
	@Column
	private String direecion;
	@Column
	private String telefono;
	@Column
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireecion() {
		return direecion;
	}
	public void setDireecion(String direecion) {
		this.direecion = direecion;
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
	public Persona(Long id, String documento, String nombres, String apellidos, Date fecha, String ciudad,
			String direecion, String telefono, String email) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.direecion = direecion;
		this.telefono = telefono;
		this.email = email;
	}
	public Persona() {
		super();
	}
	public Persona(String documento, String nombres, String apellidos, Date fecha, String ciudad, String direecion,
			String telefono, String email) {
		super();
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.direecion = direecion;
		this.telefono = telefono;
		this.email = email;
	}
	
	
}
