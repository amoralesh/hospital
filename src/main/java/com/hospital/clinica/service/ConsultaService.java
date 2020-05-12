package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface ConsultaService <Consulta> {
	
	Consulta registrar(Consulta consulta);
	
	Consulta modificar(Consulta consulta);
	
	void eliminar (int id);
	
	Optional<Consulta>  listaId(int id);
	
	List<Consulta> lista();

}
