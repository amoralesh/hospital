package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.EstadoCivilDao;
import com.hospital.clinica.model.EstadoCivil;
import com.hospital.clinica.service.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService<EstadoCivil>{
	
	@Autowired
	EstadoCivilDao dao;
	
	@Override
	public EstadoCivil registrar(EstadoCivil estadoCivil) {
		return dao.save(estadoCivil);
	}

	@Override
	public EstadoCivil modificar(EstadoCivil estadoCivil) {
		return dao.save(estadoCivil);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<EstadoCivil> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<EstadoCivil> lista() {
		return dao.findAll();
	}


}
