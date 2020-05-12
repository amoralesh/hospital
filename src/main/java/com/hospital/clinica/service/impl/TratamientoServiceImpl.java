package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.TratamientoDao;
import com.hospital.clinica.model.Tratamiento;
import com.hospital.clinica.service.TratamientoService;

@Service
public class TratamientoServiceImpl implements TratamientoService<Tratamiento>{

	@Autowired
	TratamientoDao dao;
	
	@Override
	public Tratamiento registrar(Tratamiento tratamiento) {
		return dao.save(tratamiento);
	}

	@Override
	public Tratamiento modificar(Tratamiento tratamiento) {
		return dao.save(tratamiento);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Tratamiento> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Tratamiento> lista() {
		return dao.findAll();
	}

}
