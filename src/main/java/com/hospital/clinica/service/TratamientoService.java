package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface TratamientoService <Tratamiento>{
	
	Tratamiento registrar(Tratamiento tratamiento);
	
	Tratamiento modificar(Tratamiento tratamiento);
	
	void eliminar (int id);
	
	Optional<Tratamiento>  listaId(int id);
	
	List<Tratamiento> lista();

}
