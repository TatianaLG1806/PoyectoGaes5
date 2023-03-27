package com.loginSecurity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "historial")
public class Historial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String productoadquirido;
	@Column
	private String valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductoadquirido() {
		return productoadquirido;
	}
	public void setProductoadquirido(String productoadquirido) {
		this.productoadquirido = productoadquirido;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Historial(Long id, String productoadquirido, String valor, Date fecha) {
		super();
		this.id = id;
		this.productoadquirido = productoadquirido;
		this.valor = valor;
		
	}
	public Historial() {
		super();
	}
	public Historial(String productoadquirido, String valor, Date fecha) {
		super();
		this.productoadquirido = productoadquirido;
		this.valor = valor;
		
	}
	

	

}
