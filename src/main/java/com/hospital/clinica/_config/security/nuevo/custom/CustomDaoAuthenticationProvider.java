package com.hospital.clinica._config.security.nuevo.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.hospital.clinica.dao.UsuarioDao;
import com.hospital.clinica.model.Usuario;
 
public class CustomDaoAuthenticationProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	public UsuarioDao usuarioPublicoDao;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	  
	@Autowired(required = false)
	private HttpServletRequest request;

	@Value("${websocket.topics.admin}")
	private String topicAdmin;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		

		List<GrantedAuthority> authorities = new ArrayList<>();

		Usuario usuarioPublico = usuarioPublicoDao.findOnByUsername(username);

		// VALIDACION DE USUARIOS PUBLICOS
		if (usuarioPublico != null) {
			
			if (!bcrypt.matches(password, usuarioPublico.getPassword())) {
				throw new BadCredentialsException("login.password.incorrecto");
			}
			usuarioPublico.getPermisos().forEach(permiso -> {
				//authorities.add(new SimpleGrantedAuthority(permiso.getEtiqueta()));
			});
		}
 

		Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
		return auth;
	}

	 
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
