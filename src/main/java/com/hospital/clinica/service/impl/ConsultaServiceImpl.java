package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.ConsultaDao;
import com.hospital.clinica.model.Consulta;
import com.hospital.clinica.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService<Consulta>{

	@Autowired
	ConsultaDao dao;
	
	@Override
	public Consulta registrar(Consulta consulta) {
		return dao.save(consulta);
	}

	@Override
	public Consulta modificar(Consulta consulta) {
		return dao.save(consulta);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Consulta> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Consulta> lista() {
		return dao.findAll();
	}
}
