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
 
public class CustomDaoAuthenticationProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioAdministradorDao usuarioAdministradorDao;

	@Autowired
	public UsuarioPublicoDao usuarioPublicoDao;

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
		String huella = null;
		try {
			String base64 = request.getParameter("huella"); 
			huella = base64;
		} catch (Exception ex) {
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		UsuarioAdministrador usuarioAdministrador = usuarioAdministradorDao.findByUsername(username);
		UsuarioPublico usuarioPublico = usuarioPublicoDao.findByUsernameOrEmail(username, username);

		if (usuarioPublico == null && usuarioAdministrador == null) {
			throw new UsernameNotFoundException(String.format(Translator.toLocale("login.usuario.noexiste"), username));
		}

		if (usuarioPublico != null && usuarioAdministrador != null) {
			throw new SessionAuthenticationException(String.format(Translator.toLocale("login.usuario.same.users"), username));
		}

		// VALIDACION DE USUARIOS ADMINISTRADORES
		if (usuarioAdministrador != null) {
			if (!usuarioAdministrador.isEnabled()) {
				throw new DisabledException(Translator.toLocale("login.usuario.deshabilitado"));
			}

			if (!bcrypt.matches(password, usuarioAdministrador.getPassword())) {
				throw new BadCredentialsException(Translator.toLocale("login.password.incorrecto"));
			}
			usuarioAdministrador.getPermisos().forEach(permiso -> {
				authorities.add(new SimpleGrantedAuthority(permiso.getEtiqueta()));
			});
		}

		// VALIDACION DE USUARIOS PUBLICOS
		if (usuarioPublico != null) {
			if (!usuarioPublico.isEnabled()) {
				throw new DisabledException(Translator.toLocale("login.usuario.publico.deshabilitado"));
			} 
			if (!bcrypt.matches(password, usuarioPublico.getPassword())) {
				throw new BadCredentialsException(Translator.toLocale("login.password.incorrecto"));
			}
			usuarioPublico.getPermisos().forEach(permiso -> {
				authorities.add(new SimpleGrantedAuthority(permiso.getEtiqueta()));
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
