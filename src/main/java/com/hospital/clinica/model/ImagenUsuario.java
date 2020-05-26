package com.hospital.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="imagen_usuario")
public class ImagenUsuario {
	
	public ImagenUsuario(String nombre, String type, byte[] imagenByte) {
		this.nombre = nombre;
		this.type = type;
		this.imagenByte = imagenByte;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 500,nullable = false)
	private String nombre;
	
	@Column(name="type", length = 500,nullable = false)
	private String type;
	
	@Lob
	@Column(name= "imagen_byte")
	private byte[] imagenByte;

}
