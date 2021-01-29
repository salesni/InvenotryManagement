package com.detalles.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commons.entity.Detalles;
import com.detalles.service.IDetallesService;



@RefreshScope
@RestController
public class DetallesController {
	@Autowired
	@Qualifier("ServiceFeign")
	private IDetallesService service;
	
	@GetMapping("/findById/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<Detalles> findById(@PathVariable (name = "id") Long id) {
		return service.findById(id);
	}
	
	
	@PostMapping("/newDetalle")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalles newDetalle(@RequestBody Detalles  detalle) {
		return service.save(detalle);
	}
	
	@PutMapping("/updateCantidad")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalles updateDetalle(@RequestBody Detalles  detalle) {
		return service.updateInventario(detalle);
	}
	
	@DeleteMapping("/deleteDetalle/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deleteDetalle(@PathVariable (name = "id") Long id) {
		service.delete(id);
	}
	
}
