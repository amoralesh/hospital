package com.hospital.clinica.service;

import java.util.List;
import java.util.Optional;

public interface ImagenUsuarioService <ImagenUsuario>{
	
	ImagenUsuario registrar(ImagenUsuario imagenUsuario);
	
	ImagenUsuario modificar(ImagenUsuario imagenUsuario);
	
	void eliminar (int id);
	
	Optional<ImagenUsuario>  listaId(int id);
	
	List<ImagenUsuario> lista();

}
