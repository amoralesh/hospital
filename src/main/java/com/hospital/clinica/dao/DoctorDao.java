package com.hospital.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Integer>{

}
