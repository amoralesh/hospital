package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.TipoSangreDao;
import com.hospital.clinica.model.TipoSangre;
import com.hospital.clinica.service.TipoSangreService;

@Service
public class TipoSangreServiceImpl implements TipoSangreService<TipoSangre>{

	@Autowired
	TipoSangreDao dao;
	
	@Override
	public TipoSangre registrar(TipoSangre tipoSangre) {
		return dao.save(tipoSangre);
	}

	@Override
	public TipoSangre modificar(TipoSangre tipoSangre) {
		return dao.save(tipoSangre);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<TipoSangre> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<TipoSangre> lista() {
		return dao.findAll();
	}

}
