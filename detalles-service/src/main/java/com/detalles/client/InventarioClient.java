package com.detalles.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commons.entity.Inventario;

@FeignClient (name = "servicio-inventario")
public interface InventarioClient {
	
	
	@GetMapping("/findById/{id}")
	public Optional<Inventario> findById(@PathVariable (name = "id") Long id) ;
	
	@PutMapping("/updateInventario")
	public Inventario updateDetalle(@RequestBody Inventario  inventario);

}
