package com.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.commons.entity.Ticket;

@RepositoryRestResource(path = "ticket")
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
	
	@RestResource(path = "buscar-username")
	@Query(value = "select *  from Ticket u where u.usuario =?",nativeQuery = true)
	public List<Ticket> dwight(@Param ("usuario") String usuario);
}
