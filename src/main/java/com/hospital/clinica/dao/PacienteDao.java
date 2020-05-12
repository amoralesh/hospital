package com.hospital.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.Paciente;

public interface PacienteDao  extends JpaRepository<Paciente, Integer>{

}
