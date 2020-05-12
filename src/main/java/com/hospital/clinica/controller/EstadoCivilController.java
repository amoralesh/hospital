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

import com.hospital.clinica.model.EstadoCivil;
import com.hospital.clinica.service.EstadoCivilService;

@RestController
@RequestMapping("/estadosciviles")
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService<EstadoCivil> services; 

	
	@GetMapping(value="/estadocivil",produces = "application/json")
	public List<EstadoCivil> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/estadocivil/{id}", produces = "application/json")
	public Optional<EstadoCivil> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public EstadoCivil registrar (@RequestBody EstadoCivil estadoCivil) {
		return (EstadoCivil) services.registrar(estadoCivil);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public EstadoCivil modificar (@RequestBody EstadoCivil estadoCivil) {
		return (EstadoCivil) services.modificar(estadoCivil);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
