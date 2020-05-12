package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.PeriodoDao;
import com.hospital.clinica.model.Periodo;
import com.hospital.clinica.service.PeriodoService;

@Service
public class PeriodoServiceImpl implements PeriodoService<Periodo>{
	
	@Autowired
	PeriodoDao dao;
	
	@Override
	public Periodo registrar(Periodo periodo) {
		return dao.save(periodo);
	}

	@Override
	public Periodo modificar(Periodo periodo) {
		return dao.save(periodo);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Periodo> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Periodo> lista() {
		return dao.findAll();
	}

}
