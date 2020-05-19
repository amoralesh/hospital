package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface AlcaldiaMunicipioService <AlcaldiaMunicipio>{

	
	AlcaldiaMunicipio registrar(AlcaldiaMunicipio alcaldiaMunicipio);
	
	AlcaldiaMunicipio modificar(AlcaldiaMunicipio alcaldiaMunicipio);
	
	void eliminar (int id);
	
	Optional<AlcaldiaMunicipio>  listaId(int id);
	
	List<AlcaldiaMunicipio> lista();
	
}
