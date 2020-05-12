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

import com.hospital.clinica.model.Especialidad;
import com.hospital.clinica.service.EspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService<Especialidad> services; 

	
	@GetMapping(value="/especialidad",produces = "application/json")
	public List<Especialidad> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/especialidad/{id}", produces = "application/json")
	public Optional<Especialidad> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Especialidad registrar (@RequestBody Especialidad especialidad) {
		return (Especialidad) services.registrar(especialidad);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Especialidad modificar (@RequestBody Especialidad especialidad) {
		return (Especialidad) services.modificar(especialidad);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	

}
