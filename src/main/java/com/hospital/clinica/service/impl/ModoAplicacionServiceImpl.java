package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.ModoAplicacionDao;
import com.hospital.clinica.model.ModoAplicacion;
import com.hospital.clinica.service.ModoAplicacionService;

@Service
public class ModoAplicacionServiceImpl implements ModoAplicacionService<ModoAplicacion>{

	@Autowired
	ModoAplicacionDao dao;
	
	@Override
	public ModoAplicacion registrar(ModoAplicacion modoAplicacion) {
		return dao.save(modoAplicacion);
	}

	@Override
	public ModoAplicacion modificar(ModoAplicacion modoAplicacion) {
		return dao.save(modoAplicacion);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<ModoAplicacion> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<ModoAplicacion> lista() {
		return dao.findAll();
	}

}
