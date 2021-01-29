package com.inventario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.commons.entity.Inventario;
@RepositoryRestResource(path = "inventario")
public interface InventarioRepository extends PagingAndSortingRepository<Inventario, Long> {

}
