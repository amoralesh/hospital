package com.hospital.clinica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hospital.clinica.service.impl.Permisos;


@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 255, nullable = false)
	private String nombre;
	
	@Column(name="apellidoP", nullable = true)
	private String apellidoP;
	
	@Column(name="apellidoM", nullable = true)
	private String apellidoM;
	
	@Column(name="usuario", nullable = false, length = 50)
	private String usuario;
	
	@Column(name="password", nullable = false , length = 30)
	private String passwod;

	
	 @OneToOne (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private ImagenUsuario imagenUsuario;
	 
	 @ManyToMany(mappedBy = "usuario")
	 private List<Permisos> permisos;
	 
	 


}

