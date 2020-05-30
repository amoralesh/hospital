package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.AlcaldiaMunicipioDao;
import com.hospital.clinica.model.AlcaldiaMunicipio;
import com.hospital.clinica.service.AlcaldiaMunicipioService;

@Service
public class AlcaldiaMunicipioServiceImpl implements AlcaldiaMunicipioService<AlcaldiaMunicipio>{
	
	@Autowired
	AlcaldiaMunicipioDao dao;
	
	@Override
	public AlcaldiaMunicipio registrar(AlcaldiaMunicipio alcaldiaMunicipio) {
		return dao.save(alcaldiaMunicipio);
	}

	@Override
	public AlcaldiaMunicipio modificar(AlcaldiaMunicipio alcaldiaMunicipio) {
		return dao.save(alcaldiaMunicipio);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<AlcaldiaMunicipio> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<AlcaldiaMunicipio> lista() {
		return dao.findAll();
	}

	@Override
	public List<AlcaldiaMunicipio> findByIdEntidad(int id) {
		return (List<AlcaldiaMunicipio>) dao.findByIdEntidad(id);
	}


}
