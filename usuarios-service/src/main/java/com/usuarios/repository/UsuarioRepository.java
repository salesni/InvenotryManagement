package com.usuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.commons.entity.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	
	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param ("username") String username);
	
//	@Query(" select u from Usuario u where u.username=?1")
//	public Usuario obtenerporNombredeUsuario(String username);
	
}