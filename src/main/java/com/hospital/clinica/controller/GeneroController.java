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

import com.hospital.clinica.model.Genero;
import com.hospital.clinica.model.Paciente;
import com.hospital.clinica.service.GeneroService;
import com.hospital.clinica.service.PacienteService;

@RestController
@RequestMapping("/generos")
public class GeneroController {
	
	@Autowired
	private GeneroService services; 

	
	
	@GetMapping(value="/genero",produces = "application/json")
	public List<Genero> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/genero/{id}", produces = "application/json")
	public Optional listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Genero registrar (@RequestBody Genero genero) {
		return (Genero) services.registrar(genero);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Genero modificar (@RequestBody Genero genero) {
		return (Genero) services.modificar(genero);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	

}
