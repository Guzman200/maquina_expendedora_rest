package com.example.expendedora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expendedora.Entity.MaquinaExpendedora;
import com.example.expendedora.Entity.Venta;

public interface VentaDAO extends JpaRepository<Venta, Integer>{

	List<Venta> findBymaquinaExpendedora(MaquinaExpendedora maquina);
}
