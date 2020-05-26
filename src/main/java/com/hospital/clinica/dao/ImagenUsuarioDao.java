package com.hospital.clinica.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.ImagenUsuario;

public interface ImagenUsuarioDao extends JpaRepository<ImagenUsuario, Integer>{

}
