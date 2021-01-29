package com.oauth.security;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private InfoAdicionalToken infoAdicionalToken;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()") //permiso a los endpoint mientras hayan sido aunteticados
		; 
	}

	//quienes tiene acceso a la configuracion
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//para decir que otro tipo de applicacion sera
		clients.inMemory().withClient("frontendApp")
		.secret(passwordEncoder.encode("12345"))
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
//		.and()
//		.withClient("frontendApp")
//		.secret(passwordEncoder.encode("1234"))
//		.scopes("read", "write")
//		.authorizedGrantTypes("password", "refresh_token")
//		.accessTokenValiditySeconds(3600)
//		.refreshTokenValiditySeconds(3600);
	}

	//aqui los endpoint
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhancerChain);
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		//Regresar un token
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		//palabra secreta de JWT
		tokenConverter.setSigningKey("algun_codigo_secreto_aeiou");
		return tokenConverter;
	}

	
	
}

