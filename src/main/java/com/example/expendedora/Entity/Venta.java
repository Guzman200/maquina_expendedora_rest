package com.example.expendedora.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha = new Date();
	
	@Column(name = "hora", updatable = false, nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora = new Date();
	
	@ManyToOne
	@JoinColumn(name = "maquina_expendedora_id")
	MaquinaExpendedora maquinaExpendedora;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	Producto producto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MaquinaExpendedora getMaquinaExpendedora() {
		return maquinaExpendedora;
	}

	public void setMaquinaExpendedora(MaquinaExpendedora maquinaExpendedora) {
		this.maquinaExpendedora = maquinaExpendedora;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	

	
	
	
	
}
