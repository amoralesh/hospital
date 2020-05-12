package com.hospital.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.Tratamiento;

public interface TratamientoDao extends JpaRepository<Tratamiento, Integer>{

}
