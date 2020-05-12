package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.GeneroDao;
import com.hospital.clinica.model.Genero;
import com.hospital.clinica.service.GeneroService;

@Service
public class GeneroServiceImpl  implements GeneroService<Genero>{

	@Autowired
	GeneroDao dao;
	
	@Override
	public Genero registrar(Genero genero) {
		return dao.save(genero);
	}

	@Override
	public Genero modificar(Genero genero) {
		return dao.save(genero);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Genero> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Genero> lista() {
		return dao.findAll();
	}

}
