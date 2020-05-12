package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface DireccionService <Direccion>{
	
	Direccion registrar(Direccion direccion);
	
	Direccion modificar(Direccion direccion);
	
	void eliminar (int id);
	
	Optional<Direccion>  listaId(int id);
	
	List<Direccion> lista();

}
