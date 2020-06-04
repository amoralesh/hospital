package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.hospital.clinica.dao.UsuarioDao;
import com.hospital.clinica.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalClinicaApplicationTests {
	
	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void crearUsuario() {
		
		Usuario us = new Usuario();
		us.setId(2);
		us.setUsername("amoralesh3");
		us.setPassword("1234");
		Usuario retorno = dao.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
