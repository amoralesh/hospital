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

import com.hospital.clinica.model.EntidadFederativa;
import com.hospital.clinica.service.EntidadFederativaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/entidadesfederativas")
public class EntidadFederativaController {
	
	@Autowired
	private EntidadFederativaService<EntidadFederativa> services; 

	
	@GetMapping(value="/entidadfederativa",produces = "application/json")
	public List<EntidadFederativa> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/entidadfederativa/{id}", produces = "application/json")
	public Optional<EntidadFederativa> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva",produces = "application/json", consumes = "application/json")
	public EntidadFederativa registrar (@RequestBody EntidadFederativa entidadFederativa) {
		return (EntidadFederativa) services.registrar(entidadFederativa);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public EntidadFederativa modificar (@RequestBody EntidadFederativa entidadFederativa) {
		return (EntidadFederativa) services.modificar(entidadFederativa);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
