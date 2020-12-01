package com.example.expendedora.Entity;


import java.util.Calendar;

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
	
	@Column(name = "fecha", nullable = false, updatable = false, insertable = false, columnDefinition = "date DEFAULT CURRENT_DATE")
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
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

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
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

	
	
	
	
}
