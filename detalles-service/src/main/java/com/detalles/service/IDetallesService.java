package com.detalles.service;

import java.util.Optional;

import com.commons.entity.Detalles;


public interface IDetallesService {
	public Detalles save(Detalles detalles);
	public Detalles updateInventario(Detalles detalles);
	public void delete(Long id);
	public Optional<Detalles> findById(long id);
}