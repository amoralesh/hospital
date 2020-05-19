package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.EntidadFederativaDao;
import com.hospital.clinica.model.EntidadFederativa;
import com.hospital.clinica.service.EntidadFederativaService;
@Service
public class EntidadFederativaServiceImpl implements EntidadFederativaService<EntidadFederativa>{
	
	@Autowired
	EntidadFederativaDao dao;
	
	@Override
	public EntidadFederativa registrar(EntidadFederativa entidadFederativa) {
		return dao.save(entidadFederativa);
	}

	@Override
	public EntidadFederativa modificar(EntidadFederativa entidadFederativa) {
		return dao.save(entidadFederativa);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<EntidadFederativa> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<EntidadFederativa> lista() {
		return dao.findAll();
	}

}
