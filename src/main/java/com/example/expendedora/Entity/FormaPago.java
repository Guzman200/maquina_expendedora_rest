package com.example.expendedora.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "forma_pagos")
public class FormaPago {

	@Id
	@Column(name = "cns")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cns;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "moneda_id")
	Moneda moneda;
	
	@ManyToOne
	@JoinColumn(name = "venta_id")
	Venta venta;

	public int getCns() {
		return cns;
	}

	public void setCns(int cns) {
		this.cns = cns;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
