package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface UsuarioService <Usuario> {
	

	Usuario registrar(Usuario usuario);
	
	Usuario modificar(Usuario usuario);
	
	void eliminar (int id);
	
	Optional<Usuario>  listaId(int id);
	
	List<Usuario> lista();
	

}
