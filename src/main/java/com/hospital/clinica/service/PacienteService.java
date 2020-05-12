package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

import com.hospital.clinica.model.Paciente;

public interface PacienteService<Paciente> {
	
	Paciente registrar(Paciente paciente);
	
	Paciente modificar(Paciente paciente);
	
	void eliminar (int id);
	
	Optional<Paciente>  listaId(int id);
	
	List<Paciente> lista();

}
