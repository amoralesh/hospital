package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface GeneroService<Genero>{
	
	Genero registrar(Genero genero);
	
	Genero modificar(Genero genero);
	
	void eliminar (int id);
	
	Optional<Genero>  listaId(int id);
	
	List<Genero> lista();

}
