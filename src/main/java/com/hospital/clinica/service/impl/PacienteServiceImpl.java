package com.hospital.clinica.service.impl;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.PacienteDao;
import com.hospital.clinica.model.Direccion;
import com.hospital.clinica.model.Paciente;
import com.hospital.clinica.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService<Paciente>{

	
	@Autowired
	PacienteDao dao;
	
	@Override
	public Paciente registrar(Paciente paciente) {
		
	     Direccion direccion= paciente.getDireccion();
	     direccion.setPaciente(paciente);
		
		return dao.save(paciente);
	}

	@Override
	public Paciente modificar(Paciente paciente) {
		
		  Direccion direccion= paciente.getDireccion();
		     direccion.setPaciente(paciente);
		return dao.save(paciente);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Paciente> lista() {
		return dao.findAll();
	}

	@Override
	public Optional<Paciente> listaId(int id) {
		return dao.findById(id);
	}

	@Override
	public String[] generoPaciente() {
		return dao.countGenero();
	}
	
	

}
