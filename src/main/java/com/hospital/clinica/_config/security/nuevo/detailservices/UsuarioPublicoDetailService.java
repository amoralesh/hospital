package com.hospital.clinica._config.security.nuevo.detailservices;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.UsuarioDao;
import com.hospital.clinica.model.Usuario;


  
@Service("PublicUserDetailService")
public class UsuarioPublicoDetailService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UsuarioPublicoDetailService.class);

	@Autowired
	private UsuarioDao usuarioPublicoDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) { 
		
		logger.info("loadUserByUsername - publico - " + username);
		Usuario user = usuarioPublicoDao.findOnByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("user.detail.service.usuario.noexiste"+ username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getPermisos().forEach(permiso -> {
			//authorities.add(new SimpleGrantedAuthority(permiso.getEtiqueta()));
		});
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
		return userDetails;
	}



}
