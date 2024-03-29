package com.ticket.client;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commons.entity.Ticket;


@FeignClient (name = "servicio-ticket")
public interface TicketClient {
	@GetMapping("/findById/{id}")
	public Optional<Ticket> findById(@PathVariable (name = "id") Long id);
	
	@PostMapping("/newTicket")
	public Ticket newTicket(@RequestBody Ticket  ticket); 
	
	@DeleteMapping("/deleteTicket/{id}")
	public void deleteTicket(@PathVariable (name = "id") Long id);
	
	@GetMapping("/findByUsuario/{usuario}")
	public List<Ticket> findByUsuario(@PathVariable (name = "usuario") String usuario);
	
	@PutMapping("/operaciones/{id}")
	public Ticket update(@RequestBody Ticket producto, @PathVariable Integer id); 
	
	@PutMapping("/updateTicket")
	public Ticket update(@RequestBody Ticket  ticket);

}
