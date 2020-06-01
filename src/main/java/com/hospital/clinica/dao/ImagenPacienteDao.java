package com.hospital.clinica.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.ImagenPaciente;

public interface ImagenPacienteDao extends JpaRepository<ImagenPaciente, Integer>{

}
