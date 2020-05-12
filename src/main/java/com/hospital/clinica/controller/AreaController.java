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

import com.hospital.clinica.model.Area;
import com.hospital.clinica.service.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private AreaService<Area> services; 

	
	@GetMapping(value="/area",produces = "application/json")
	public List<Area> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/area/{id}", produces = "application/json")
	public Optional<Area> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva",produces = "application/json", consumes = "application/json")
	public Area registrar (@RequestBody Area area) {
		return (Area) services.registrar(area);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Area modificar (@RequestBody Area area) {
		return (Area) services.modificar(area);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	

}
