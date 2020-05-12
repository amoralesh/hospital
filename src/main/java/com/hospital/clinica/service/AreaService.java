package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface AreaService <Area>{
	
	Area registrar(Area area);
	
	Area modificar(Area area);
	
	void eliminar (int id);
	
	Optional<Area>  listaId(int id);
	
	List<Area> lista();

}
