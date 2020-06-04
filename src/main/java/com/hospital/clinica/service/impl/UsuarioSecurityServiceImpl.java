package com.hospital.clinica.service.impl;

import java.util.ArrayList;
import java.util.List;

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

@Service("userDetailsService")
public class UsuarioSecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario usuario =  dao.findOnByUsername(username);
		 
		 if(usuario == null) { 
			 throw new UsernameNotFoundException(String.format("Usuario no existe", username));
			 
		 }
		 
		 List<GrantedAuthority> authorities = new ArrayList<>();
		 
		 usuario.getPermisos().forEach(permiso -> {
			 authorities.add(new SimpleGrantedAuthority(permiso.getNombre()));
		 });
		 
		 UserDetails UserDetails= new User(usuario.getUsername(), "{noop}"+usuario.getPassword(),authorities);
		 return UserDetails;
	}

}
