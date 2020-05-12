package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.DireccionDao;
import com.hospital.clinica.model.Direccion;
import com.hospital.clinica.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService<Direccion>{
	
	@Autowired
	DireccionDao dao;
	
	@Override
	public Direccion registrar(Direccion direccion) {
		return dao.save(direccion);
	}

	@Override
	public Direccion modificar(Direccion direccion) {
		return dao.save(direccion);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Direccion> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Direccion> lista() {
		return dao.findAll();
	}

}
