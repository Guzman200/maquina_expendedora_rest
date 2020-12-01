package com.example.expendedora.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expendedora.Entity.Producto;
import com.example.expendedora.dao.ProductoDAO;

@RestController
@RequestMapping("/productos")
public class ProductoREST {
	
	@Autowired
	private ProductoDAO productoDAO;

	@GetMapping()
	public ResponseEntity<List<Producto>> getProductos() {
		List<Producto> productos =  productoDAO.findAll();
		
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping(value = "{producto_id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("producto_id") int producto_id){
		Optional<Producto> OptionalProducto =  productoDAO.findById(producto_id);
		
		// Si existe
		if(OptionalProducto.isPresent()) {
			return ResponseEntity.ok(OptionalProducto.get());
		}else {
			return ResponseEntity.status(404).build();
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
		Producto productoNew =  productoDAO.save(producto);
		
		return ResponseEntity.ok(productoNew);
	}
	
	@DeleteMapping(value = "{producto_id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("producto_id") int producto_id){
		productoDAO.deleteById(producto_id);
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Producto> editarProducto(@RequestBody Producto producto){
		
		Optional<Producto> optionalProducto = productoDAO.findById(producto.getId());
		
		if(optionalProducto.isPresent()) {
			Producto productoUpdate = optionalProducto.get();
			productoUpdate.setNombre(producto.getNombre());
			productoUpdate.setPrecio_venta(producto.getPrecio_venta());
			productoDAO.save(productoUpdate);
			return ResponseEntity.ok(productoUpdate);
		}
		
		return ResponseEntity.status(404).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
