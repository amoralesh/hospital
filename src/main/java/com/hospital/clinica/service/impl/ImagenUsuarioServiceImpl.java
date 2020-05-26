package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.ImagenUsuarioDao;
import com.hospital.clinica.model.ImagenUsuario;
import com.hospital.clinica.service.ImagenUsuarioService;

@Service
public class ImagenUsuarioServiceImpl implements ImagenUsuarioService<ImagenUsuario>{
	
	@Autowired
	ImagenUsuarioDao dao;
	
	@Override
	public ImagenUsuario registrar(ImagenUsuario imagenUsuario) {
		return dao.save(imagenUsuario);
	}

	@Override
	public ImagenUsuario modificar(ImagenUsuario imagenUsuario) {
		return dao.save(imagenUsuario);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<ImagenUsuario> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<ImagenUsuario> lista() {
		return dao.findAll();
	}

}
