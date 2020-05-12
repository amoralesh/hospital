package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface EspecialidadService<Especialidad>{
	
	Especialidad registrar(Especialidad especialidad);
	
	Especialidad modificar(Especialidad especialidad);
	
	void eliminar (int id);
	
	Optional<Especialidad>  listaId(int id);
	
	List<Especialidad> lista();

}
