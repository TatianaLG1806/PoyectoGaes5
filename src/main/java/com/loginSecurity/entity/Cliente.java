package com.loginSecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String documento;
	@Column
	private String evento;
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
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public Cliente(Long id, String documento, String evento) {
		super();
		this.id = id;
		this.documento = documento;
		this.evento = evento;
	}
	public Cliente() {
		super();
	}
	public Cliente(String documento, String evento) {
		super();
		this.documento = documento;
		this.evento = evento;
	}
	
	

}
