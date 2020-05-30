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

import com.hospital.clinica.model.AlcaldiaMunicipio;
import com.hospital.clinica.service.AlcaldiaMunicipioService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/alcaldias")
public class AlcaldiaMunicipioController {
	
	@Autowired
	private AlcaldiaMunicipioService<AlcaldiaMunicipio> services; 
	
	
	@GetMapping(value="/alcaldia",produces = "application/json")
	public List<AlcaldiaMunicipio> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/municipio/alcaldia/{id}",produces = "application/json")
	public  List<AlcaldiaMunicipio> findByIdEntidad (@PathVariable("id") int id) {
		return services.findByIdEntidad(id); 
	}
	
	@GetMapping(value="/alcaldia/{id}", produces = "application/json")
	public Optional<AlcaldiaMunicipio> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva",produces = "application/json", consumes = "application/json")
	public AlcaldiaMunicipio registrar (@RequestBody AlcaldiaMunicipio alcaldiaMunicipio) {
		return (AlcaldiaMunicipio) services.registrar(alcaldiaMunicipio);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public AlcaldiaMunicipio modificar (@RequestBody AlcaldiaMunicipio alcaldiaMunicipio) {
		return (AlcaldiaMunicipio) services.modificar(alcaldiaMunicipio);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	
	

}
