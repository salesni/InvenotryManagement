package com.oauth.services;

import com.commons.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername (  String username);
}
