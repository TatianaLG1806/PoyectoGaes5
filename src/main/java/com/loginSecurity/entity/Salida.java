package com.loginSecurity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "salida_productos")
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String cantidad;
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@Column
	private String nombreproyecto;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombreproyecto() {
		return nombreproyecto;
	}
	public void setNombreproyecto(String nombreproyecto) {
		this.nombreproyecto = nombreproyecto;
	}
	public Salida(Long id, String cantidad, Date fecha, String nombreproyecto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.nombreproyecto = nombreproyecto;
	}
	public Salida() {
		super();
	}
	public Salida(String cantidad, Date fecha, String nombreproyecto) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.nombreproyecto = nombreproyecto;
	}
	
	
}
