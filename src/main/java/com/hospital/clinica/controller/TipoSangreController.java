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

import com.hospital.clinica.model.TipoSangre;
import com.hospital.clinica.service.TipoSangreService;

@RestController
@RequestMapping("/tiposdesangre")
public class TipoSangreController {

	@Autowired
	private TipoSangreService<TipoSangre> services; 

	
	@GetMapping(value="/tiposangre",produces = "application/json")
	public List<TipoSangre> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/tiposangre/{id}", produces = "application/json")
	public Optional<TipoSangre> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public TipoSangre registrar (@RequestBody TipoSangre tipoSangre) {
		return (TipoSangre) services.registrar(tipoSangre);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public TipoSangre modificar (@RequestBody TipoSangre tipoSangre) {
		return (TipoSangre) services.modificar(tipoSangre);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
}
