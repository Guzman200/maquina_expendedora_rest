package com.example.expendedora.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id // Seria el id de la tabla
	@Column(name = "id") // Nombre columna a nivel base de datos
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementable
	private int id;
	
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;
	
	@Column(name = "precio_venta", nullable = false)
	private float precio_venta;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecio_venta() {
		return precio_venta;
	}
	
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	
}
