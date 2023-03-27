package com.loginSecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column 
	private String 	nombre;
	@Column
	private String presupuesto;
	@Column
	private String tiempo;
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
	public String getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public Proyecto(Long id, String nombre, String presupuesto, String tiempo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}
	public Proyecto(String nombre, String presupuesto, String tiempo) {
		super();
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}
	public Proyecto() {
		super();
	}
	
	

}
