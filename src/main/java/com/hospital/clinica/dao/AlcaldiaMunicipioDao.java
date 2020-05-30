package com.hospital.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.clinica.model.AlcaldiaMunicipio;

public interface AlcaldiaMunicipioDao extends JpaRepository<AlcaldiaMunicipio, Integer>{

	@Query( "SELECT am FROM AlcaldiaMunicipio am WHERE am.idEntidad = ?1 ")
	List<AlcaldiaMunicipio> findByIdEntidad(int id); 
}
 