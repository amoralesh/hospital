package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface ModoAplicacionService <ModoAplicacion>{

	ModoAplicacion registrar(ModoAplicacion modoAplicacion);
	
	ModoAplicacion modificar(ModoAplicacion modoAplicacion);
	
	void eliminar (int id);
	
	Optional<ModoAplicacion>  listaId(int id);
	
	List<ModoAplicacion> lista();
}
