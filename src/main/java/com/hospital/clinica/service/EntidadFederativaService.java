package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface EntidadFederativaService <EntidadFederativa>{
	
	EntidadFederativa registrar(EntidadFederativa entidadFederativa);
	
	EntidadFederativa modificar(EntidadFederativa entidadFederativa);
	
	void eliminar (int id);
	
	Optional<EntidadFederativa>  listaId(int id);
	
	List<EntidadFederativa> lista();

}
