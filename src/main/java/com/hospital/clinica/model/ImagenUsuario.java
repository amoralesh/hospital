package com.hospital.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="imagen_usuario")
public class ImagenUsuario {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 255,nullable = false)
	private String nombre;
	
	@Column(name="type", length = 255,nullable = false)
	private String type;
	
	@Lob
	@Column(name= "imagen_byte")
	private byte[] imagenByte;
	
	@JsonIgnore
	@OneToOne
    @JoinColumn (name="id_usuario",nullable = false)
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImagenByte() {
		return imagenByte;
	}

	public void setImagenByte(byte[] imagenByte) {
		this.imagenByte = imagenByte;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
