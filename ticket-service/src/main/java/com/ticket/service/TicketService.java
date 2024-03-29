package com.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entity.Ticket;
import com.ticket.repository.TicketRepository;

@Service("ServiceFeign")
public class TicketService implements ITicketService {
	
	@Autowired
	private TicketRepository repo;

	@Override
	public Ticket save(Ticket ticket) {
		return repo.save(ticket);
	}


	@Override
	public void delete(Long id) {
		repo.deleteById(id);

	}

	@Override
	public Optional<Ticket> findById(long id) {
		Optional <Ticket> temp = repo.findById(id);
		temp.get().getUsuario().setPassword("");
		return temp;
	}


	@Override
	public List<Ticket> findByUsername(String usuario) {
		List<Ticket> tickets = repo.dwight(usuario);
		if(tickets != null)
			tickets.get(0).getUsuario().setPassword("");
		return tickets;
	}


	@Override
	public Ticket update(Ticket ticket) {
		Ticket ticketTemp = repo.save(ticket);
		ticketTemp.getUsuario().setPassword("");
		return ticketTemp;
	}


	
	

}
