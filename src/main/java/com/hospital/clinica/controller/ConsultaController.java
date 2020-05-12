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

import com.hospital.clinica.model.Consulta;
import com.hospital.clinica.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService<Consulta> services; 

	
	@GetMapping(value="/consulta",produces = "application/json")
	public List<Consulta> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/consulta/{id}", produces = "application/json")
	public Optional<Consulta> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva",produces = "application/json", consumes = "application/json")
	public Consulta registrar (@RequestBody Consulta consulta) {
		return (Consulta) services.registrar(consulta);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Consulta modificar (@RequestBody Consulta consulta) {
		return (Consulta) services.modificar(consulta);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	

}
