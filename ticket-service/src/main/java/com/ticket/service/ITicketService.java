package com.ticket.service;

import java.util.List;
import java.util.Optional;

import com.commons.entity.Ticket;



public interface ITicketService {
	public Ticket save(Ticket ticket);
	public Ticket update(Ticket ticket);
	public void delete(Long id);
	public Optional<Ticket> findById(long id);
	public List<Ticket> findByUsername(String usuario);
}
