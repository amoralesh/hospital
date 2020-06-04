package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.UsuarioDao;
import com.hospital.clinica.model.Usuario;
import com.hospital.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService<Usuario>{

	@Autowired
	UsuarioDao dao;
	
	@Override
	public Usuario registrar(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Usuario> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Usuario> lista() {
		return dao.findAll();
	}
}
