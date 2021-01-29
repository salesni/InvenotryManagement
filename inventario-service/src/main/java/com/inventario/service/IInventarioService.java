package com.inventario.service;

import java.util.Optional;

import com.commons.entity.Inventario;

public interface IInventarioService {
	public Inventario save(Inventario Inventario);
	public Inventario updateInventario(Inventario Inventario);
	public void delete(Long id);
	public Optional<Inventario> findById(long id);
}
