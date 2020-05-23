package com.hospital.clinica.dao;

import java.sql.Array;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.clinica.model.Paciente;

public interface PacienteDao  extends JpaRepository<Paciente, Integer>{
	

	@Query( "select g.etiqueta,COUNT(p.id) as valor from Paciente p INNER JOIN p.genero g GROUP BY g.etiqueta")
	String[] countGenero();

}
