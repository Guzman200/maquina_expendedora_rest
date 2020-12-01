package com.example.expendedora.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expendedora.Entity.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Integer>{
	
	
}
