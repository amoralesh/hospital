package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface TipoSangreService <TipoSangre>{
	
	TipoSangre registrar(TipoSangre tipoSangre);
	
	TipoSangre modificar(TipoSangre tipoSangre);
	
	void eliminar (int id);
	
	Optional<TipoSangre>  listaId(int id);
	
	List<TipoSangre> lista();

}
