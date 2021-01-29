package com.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commons.entity.Ticket;
import com.ticket.service.ITicketService;



@RefreshScope
@RestController
public class TicketController {
	
	@Autowired
	@Qualifier("ServiceFeign")
	private ITicketService service;
	
	@GetMapping("/findById/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<Ticket> findById(@PathVariable (name = "id") Long id) {
		return service.findById(id);
	}
	
	
	@PostMapping("/newTicket")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket newTicket(@RequestBody Ticket  ticket) {
		return service.save(ticket);
	}
	
	@DeleteMapping("/deleteTicket/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deleteTicket(@PathVariable (name = "id") Long id) {
		service.delete(id);
	}
	
	@GetMapping("/findByUsuario/{usuario}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Ticket> findByUsuario(@PathVariable (name = "usuario") String usuario) {
		return service.findByUsername(usuario);
	}
	
	@PutMapping("/updateTicket")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket update(@RequestBody Ticket  ticket){
		return service.update(ticket);
	}
	
	

}
