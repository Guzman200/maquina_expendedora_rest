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

import com.example.expendedora.Entity.MaquinaExpendedora;
import com.example.expendedora.dao.MaquinaExpendedoraDAO;

@RestController
@RequestMapping("/maquinas_expendedoras")
public class MaquinaExpendedoraREST {
	
	@Autowired
	private MaquinaExpendedoraDAO maquinaExpendedoraDAO;

	@GetMapping
	public ResponseEntity<List<MaquinaExpendedora>> getMaquinasExpendedoras(){
		List<MaquinaExpendedora> maquinas = maquinaExpendedoraDAO.findAll();
		return ResponseEntity.ok(maquinas);
	}
	
	@GetMapping(value = "{maquina_id}")
	public ResponseEntity<MaquinaExpendedora> getMaquinaExpendedora(@PathVariable("maquina_id") int maquina_id){
		
		Optional<MaquinaExpendedora> optional = maquinaExpendedoraDAO.findById(maquina_id);
		
		if(optional.isPresent()) {
			MaquinaExpendedora maquina_expendedora = optional.get();
			return ResponseEntity.ok(maquina_expendedora);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<MaquinaExpendedora> crearMaquinaExpendedora(@RequestBody MaquinaExpendedora maquina){
		maquinaExpendedoraDAO.save(maquina);
		return ResponseEntity.ok(maquina);
	}
	
	@PutMapping
	public ResponseEntity<MaquinaExpendedora> editarMaquinaExpendedora(@RequestBody MaquinaExpendedora maquina){
		Optional<MaquinaExpendedora> optional = maquinaExpendedoraDAO.findById(maquina.getId());
		
		if(optional.isPresent()) {
			MaquinaExpendedora maquina_update = optional.get();
			maquina_update.setLatitud(maquina.getLatitud());
			maquina_update.setLongitud(maquina.getLongitud());
			maquina_update.setUbicacion(maquina.getUbicacion());
			maquinaExpendedoraDAO.save(maquina_update);
			return ResponseEntity.ok(maquina_update);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "{maquina_id}")
	public ResponseEntity<Void> eliminarMaquinaExpendedora(@PathVariable("maquina_id") int maquina_id){
		maquinaExpendedoraDAO.deleteById(maquina_id);
		return ResponseEntity.ok(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
