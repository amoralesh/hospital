package com.hospital.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.clinica.model.TipoSangre;

public interface TipoSangreDao extends JpaRepository<TipoSangre, Integer>{

}
