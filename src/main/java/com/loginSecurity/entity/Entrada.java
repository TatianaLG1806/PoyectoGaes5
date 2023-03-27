package com.loginSecurity.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "entrada_producto")
public class Entrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String cantidad;
	@Column
	
	private String fecha;
	@Column
	private String nit;
	@Column
	private String nombre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Entrada(Long id, String cantidad, String fecha, String nit, String nombre) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.nit = nit;
		this.nombre = nombre;
	}
	public Entrada() {
		super();
	}
	public Entrada(String cantidad, String fecha, String nit, String nombre) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.nit = nit;
		this.nombre = nombre;
	}
	
	


}
