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

import com.hospital.clinica.model.ModoAplicacion;
import com.hospital.clinica.service.ModoAplicacionService;

@RestController
@RequestMapping("/modoaplicacion")
public class ModoAplicacionController {
	
	@Autowired
	private ModoAplicacionService<ModoAplicacion> services; 

	
	@GetMapping(value="/modoaplicacion",produces = "application/json")
	public List<ModoAplicacion> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/modoaplicacion/{id}", produces = "application/json")
	public Optional<ModoAplicacion> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public ModoAplicacion registrar (@RequestBody ModoAplicacion modoAplicacion) {
		return (ModoAplicacion) services.registrar(modoAplicacion);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public ModoAplicacion modificar (@RequestBody ModoAplicacion modoAplicacion) {
		return (ModoAplicacion) services.modificar(modoAplicacion);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}

}
