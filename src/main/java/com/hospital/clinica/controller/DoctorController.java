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

import com.hospital.clinica.model.Doctor;
import com.hospital.clinica.service.DoctorService;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
	
	@Autowired
	private DoctorService<Doctor> services; 

	
	@GetMapping(value="/doctor",produces = "application/json")
	public List<Doctor> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/doctor/{id}", produces = "application/json")
	public Optional<Doctor> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nuevo",produces = "application/json", consumes = "application/json")
	public Doctor registrar (@RequestBody Doctor doctor) {
		return (Doctor) services.registrar(doctor);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public Doctor modificar (@RequestBody Doctor doctor) {
		return (Doctor) services.modificar(doctor);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	

}
