package com.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entity.Ticket;
import com.ticket.client.TicketClient;
import com.ticket.model.TicketLogic;

@Service("ServiceFeign")
public class TicketLogicService implements ITicketsLogicService{
	
	@Autowired
	private TicketClient clienteFeign;
	
	
	
	@Override
	public Ticket save(Ticket ticket) {
		TicketLogic ticketL = new TicketLogic(ticket);
		ticketL.calcAll();
		
		return clienteFeign.newTicket(ticketL.getTicket());
	}

	@Override
	public Ticket update(Ticket ticket) {
		TicketLogic ticketL = new TicketLogic(ticket);
		ticketL.calcAll();
		return clienteFeign.update(ticketL.getTicket());
	}

	@Override
	public void delete(Long id) {
		clienteFeign.deleteTicket(id);
		
	}

	@Override
	public Optional<Ticket> findById(long id) {
		
		return clienteFeign.findById(id);
	}

	@Override
	public List<Ticket> findByUsername(String usuario) {
		return clienteFeign.findByUsuario(usuario);
	}

}