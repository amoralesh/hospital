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

import com.hospital.clinica.model.Paciente;
import com.hospital.clinica.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService services;
	
	
	@GetMapping(value="/paciente",produces = "application/json")
	public List<Paciente> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/paciente/{id}", produces = "application/json")
	public Optional listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Paciente registrar (@RequestBody Paciente paciente) {
		return (Paciente) services.registrar(paciente);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	public Paciente modificar (@RequestBody Paciente paciente) {
		return (Paciente) services.modificar(paciente);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	
}
