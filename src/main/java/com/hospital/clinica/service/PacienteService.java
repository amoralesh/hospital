package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

import java.sql.Array;


public interface PacienteService <Paciente> {
	
	Paciente registrar(Paciente paciente);
	
	Paciente modificar(Paciente paciente);
	
	void eliminar (int id);
	
	Optional<Paciente>  listaId(int id);
	
	List<Paciente> lista();
	
	String[] generoPaciente();
	
}
