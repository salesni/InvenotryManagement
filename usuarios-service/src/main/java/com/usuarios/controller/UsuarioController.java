package com.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commons.entity.Usuario;
import com.usuarios.service.IUserService;

import org.springframework.http.HttpStatus;



@RefreshScope
@RestController
public class UsuarioController {
	@Autowired
	@Qualifier("ServiceFeign")
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@PostMapping("/newUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario  usuario) {
		//System.out.println(usuario.getPassword());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		//System.out.println(usuario.getPassword());
		Usuario temp = service.save(usuario);
		temp.setPassword("");
		return temp;
	}
	
	@GetMapping("/listAll")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Usuario> listAll() {
		return service.findAll();
	}
	
	@PutMapping("/updatePassword/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updatePassword(@RequestBody Usuario  usuario, @PathVariable (name = "username") String username) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		Usuario temp = service.updatePassword(usuario, username);
		temp.setPassword("");
		return temp;
	}
	
	@PutMapping("/updateRoles/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updateRoles(@RequestBody Usuario  usuario, @PathVariable (name = "username") String username) {
		Usuario temp = service.updateRoles(usuario, username);
		temp.setPassword("");
		return temp;
	}
	
	@PutMapping("/updateInfo/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updateInfo(@RequestBody Usuario  usuario, @PathVariable (name = "username") String username) {
		Usuario temp = service.updateInfo(usuario, username);
		temp.setPassword("");
		return temp;
	}
	
	@DeleteMapping("/deleteUser/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deleteUser( @PathVariable (name = "username") String username) {
		service.deleteUser(username);
	}
	
	@PutMapping("/updateUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario  usuario) {
		//System.out.println(usuario.getPassword());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		//System.out.println(usuario.getPassword());
		return service.update(usuario);
	}
	

}

