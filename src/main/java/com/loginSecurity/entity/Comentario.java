package com.loginSecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String mensaje;
	@Column
	private String asunto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Comentario(Long id, String mensaje, String asunto) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.asunto = asunto;
	}
	public Comentario() {
		super();
	}
	public Comentario(String mensaje, String asunto) {
		super();
		this.mensaje = mensaje;
		this.asunto = asunto;
	}
	
	
	
	
	
	
}
