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

import com.hospital.clinica.model.Tratamiento;
import com.hospital.clinica.service.TratamientoService;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {
	
	@Autowired
	private TratamientoService<Tratamiento> services; 

	
	@GetMapping(value="/tratamiento",produces = "application/json")
	public List<Tratamiento> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/tratamiento/{id}", produces = "application/json")
	public Optional<Tratamiento> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Tratamiento registrar (@RequestBody Tratamiento tratamiento) {
		return (Tratamiento) services.registrar(tratamiento);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Tratamiento modificar (@RequestBody Tratamiento tratamiento) {
		return (Tratamiento) services.modificar(tratamiento);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
