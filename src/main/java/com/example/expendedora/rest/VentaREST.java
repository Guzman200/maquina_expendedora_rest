package com.example.expendedora.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expendedora.Entity.MaquinaExpendedora;
import com.example.expendedora.Entity.Producto;
import com.example.expendedora.Entity.Venta;
import com.example.expendedora.dao.MaquinaExpendedoraDAO;
import com.example.expendedora.dao.ProductoDAO;
import com.example.expendedora.dao.VentaDAO;

@RestController
@RequestMapping("ventas")
public class VentaREST {
	
	@Autowired
	private MaquinaExpendedoraDAO maquinaDAO;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private VentaDAO ventaDAO;
	
	@GetMapping
	public ResponseEntity<List<Venta>> getVentas(){
		List<Venta> ventas = ventaDAO.findAll();
		return ResponseEntity.ok(ventas);
	}
	
	@GetMapping(value = "{maquina_id}")
	public ResponseEntity<List<Venta>> getVentasByMaquina(@PathVariable("maquina_id") int maquina_id){
		
		Optional<MaquinaExpendedora> maquina = maquinaDAO.findById(maquina_id);
		
		if(maquina.isPresent()) {
			MaquinaExpendedora maquina_ = maquina.get();
			List<Venta> ventas = ventaDAO.findBymaquinaExpendedora(maquina_);
			return ResponseEntity.ok(ventas);
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping(value = "{producto_id}/{maquina_id}")
	public ResponseEntity<Venta> crearVenta(@PathVariable("producto_id") int producto_id, 
			@PathVariable("maquina_id") int maquina_id){
		
		Optional<Producto> optionalProducto = productoDAO.findById(producto_id);
		Optional<MaquinaExpendedora> optionalMaquina = maquinaDAO.findById(maquina_id);
		
		if(optionalProducto.isPresent() && optionalMaquina.isPresent()) {
			Producto producto = optionalProducto.get();
			MaquinaExpendedora maquina = optionalMaquina.get();
			
			Venta venta = new Venta();
			venta.setMaquinaExpendedora(maquina);
			venta.setProducto(producto);
			
			ventaDAO.save(venta);
			
			return ResponseEntity.ok(venta);
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
