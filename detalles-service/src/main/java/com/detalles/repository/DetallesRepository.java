package com.detalles.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.commons.entity.Detalles;
@RepositoryRestResource(path = "detalles")
public interface DetallesRepository extends PagingAndSortingRepository<Detalles, Long> {

	
}
