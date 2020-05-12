package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.AreaDao;
import com.hospital.clinica.model.Area;
import com.hospital.clinica.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService<Area>{

	@Autowired
	AreaDao dao;
	
	@Override
	public Area registrar(Area area) {
		return dao.save(area);
	}

	@Override
	public Area modificar(Area area) {
		return dao.save(area);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Area> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Area> lista() {
		return dao.findAll();
	}

}
