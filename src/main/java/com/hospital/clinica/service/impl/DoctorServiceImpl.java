package com.hospital.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.clinica.dao.DoctorDao;
import com.hospital.clinica.model.Doctor;
import com.hospital.clinica.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService<Doctor>{
	
	@Autowired
	DoctorDao dao;
	
	@Override
	public Doctor registrar(Doctor doctor) {
		return dao.save(doctor);
	}

	@Override
	public Doctor modificar(Doctor doctor) {
		return dao.save(doctor);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Doctor> listaId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Doctor> lista() {
		return dao.findAll();
	}


}
