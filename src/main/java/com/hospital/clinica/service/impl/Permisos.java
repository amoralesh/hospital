package com.hospital.clinica.service.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.hospital.clinica.model.Usuario;

@Entity
@Table(name="persmisos")
public class Permisos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="descripcion", nullable = false)
	private String descripcion; 
	
	
	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="usuarios_permisos", joinColumns = @JoinColumn(name="id_usuario", nullable = false),
	inverseJoinColumns = @JoinColumn(name="id_permisos", nullable = false) )
	private List<Usuario> usuario;
	

}
