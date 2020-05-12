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

import com.hospital.clinica.model.Periodo;
import com.hospital.clinica.service.PeriodoService;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {
	
	@Autowired
	private PeriodoService<Periodo> services; 

	
	@GetMapping(value="/periodo",produces = "application/json")
	public List<Periodo> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/periodo/{id}", produces = "application/json")
	public Optional<Periodo> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Periodo registrar (@RequestBody Periodo periodo) {
		return (Periodo) services.registrar(periodo);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Periodo modificar (@RequestBody Periodo periodo) {
		return (Periodo) services.modificar(periodo);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
}
