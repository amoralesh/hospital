package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.ImagenPacienteDao;
import com.hospital.clinica.model.ImagenPaciente;
import com.hospital.clinica.service.ImagenPacienteService;

@Service
public class ImagenPacienteServiceImpl implements ImagenPacienteService<ImagenPaciente>{
	
	@Autowired
	ImagenPacienteDao dao;
	
	@Override
	public ImagenPaciente registrar(ImagenPaciente imagenUsuario) {
		return dao.save(imagenUsuario);
	}

	@Override
	public ImagenPaciente modificar(ImagenPaciente imagenUsuario) {
		return dao.save(imagenUsuario);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<ImagenPaciente> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<ImagenPaciente> lista() {
		return dao.findAll();
	}

}
