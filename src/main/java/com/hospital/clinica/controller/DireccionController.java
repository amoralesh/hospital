package com.hospital.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.clinica.model.Direccion;
import com.hospital.clinica.service.DireccionService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/direcciones")
public class DireccionController {
	
	@Autowired
	private DireccionService<Direccion> services; 

	
	@GetMapping(value="/direccion",produces = "application/json")
	public List<Direccion> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/direccion/{id}", produces = "application/json")
	public Optional<Direccion> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva",produces = "application/json", consumes = "application/json")
	public Direccion registrar (@RequestBody Direccion direccion) {
		return (Direccion) services.registrar(direccion);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Direccion modificar (@RequestBody Direccion direccion) {
		return (Direccion) services.modificar(direccion);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
