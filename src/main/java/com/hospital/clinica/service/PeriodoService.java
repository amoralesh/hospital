package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface PeriodoService <Periodo>{
	
	Periodo registrar(Periodo periodo);
	
	Periodo modificar(Periodo periodo);
	
	void eliminar (int id);
	
	Optional<Periodo>  listaId(int id);
	
	List<Periodo> lista();

}
