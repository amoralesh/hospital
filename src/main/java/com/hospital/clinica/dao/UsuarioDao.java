package com.hospital.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{
	
	Usuario findOnByUsername(String nombre); 
	
	

}
