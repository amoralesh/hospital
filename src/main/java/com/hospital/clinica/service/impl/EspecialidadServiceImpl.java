package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.EspecialidadDao;
import com.hospital.clinica.model.Especialidad;
import com.hospital.clinica.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService<Especialidad>{

	@Autowired
	EspecialidadDao dao;
	
	@Override
	public Especialidad registrar(Especialidad especialidad) {
		return dao.save(especialidad);
	}

	@Override
	public Especialidad modificar(Especialidad especialidad) {
		return dao.save(especialidad);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Especialidad> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Especialidad> lista() {
		return dao.findAll();
	}

}
