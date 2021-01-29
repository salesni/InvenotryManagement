package com.oauth.security;


import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.commons.entity.Usuario;
import com.oauth.services.IUsuarioService;




@Configuration
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		
		
		Map<String,Object>additionalInformation = new HashMap<String,Object>();
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		additionalInformation.put("nombre", usuario.getNombre());
		additionalInformation.put("apellido", usuario.getApellido());
		additionalInformation.put("correo", usuario.getEmail());
		additionalInformation.put("user_id", usuario.getId());
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(additionalInformation);
		
		return accessToken;
	}

}