package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface DoctorService <Doctor>{

	Doctor registrar(Doctor doctor);
	
	Doctor modificar(Doctor doctor);
	
	void eliminar (int id);
	
	Optional<Doctor>  listaId(int id);
	
	List<Doctor> lista();
}
