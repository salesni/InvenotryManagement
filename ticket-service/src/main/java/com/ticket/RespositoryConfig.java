package com.ticket;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.commons.entity.Detalles;
import com.commons.entity.Inventario;
import com.commons.entity.Rol;
import com.commons.entity.Ticket;
import com.commons.entity.Usuario;

public class RespositoryConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Usuario.class, Rol.class, Inventario.class, Detalles.class, Ticket.class); 
	}
}