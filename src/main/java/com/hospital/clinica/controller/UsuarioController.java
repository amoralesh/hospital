package com.hospital.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.clinica.model.Usuario;
import com.hospital.clinica.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService<Usuario> services; 

	
	@GetMapping(value="/usuario",produces = "application/json")
	public List<Usuario> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/usuario/{id}", produces = "application/json")
	public Optional<Usuario> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Usuario registrar (@RequestBody Usuario usuario) {
		return (Usuario) services.registrar(usuario);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Usuario modificar (@RequestBody Usuario usuario) {
		return (Usuario) services.modificar(usuario);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
