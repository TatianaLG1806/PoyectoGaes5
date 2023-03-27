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
@Table(name = "requerimientos_del_proyecto")
public class Requerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column 
	private String codigoproyecto;
	@Column
	private String producto;
	@Column
	private String cantidad;
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoproyecto() {
		return codigoproyecto;
	}
	public void setCodigoproyecto(String codigoproyecto) {
		this.codigoproyecto = codigoproyecto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
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
	public Requerimiento(Long id, String codigoproyecto, String producto, String cantidad, Date fecha) {
		super();
		this.id = id;
		this.codigoproyecto = codigoproyecto;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	public Requerimiento() {
		super();
	}
	public Requerimiento(String codigoproyecto, String producto, String cantidad, Date fecha) {
		super();
		this.codigoproyecto = codigoproyecto;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	
	
}
