package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface EstadoCivilService <EstadoCivil> {
	
	EstadoCivil registrar(EstadoCivil estadoCivil);
	
	EstadoCivil modificar(EstadoCivil estadoCivil);
	
	void eliminar (int id);
	
	Optional<EstadoCivil>  listaId(int id);
	
	List<EstadoCivil> lista();

}
