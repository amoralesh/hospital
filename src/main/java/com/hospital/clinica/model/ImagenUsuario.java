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
	
	public ImagenUsuario() {
		super();
	}
	
	public ImagenUsuario(String nombre, String type, byte[] imagenByte) {
		this.nombre = nombre;
		this.type = type;
		this.imagenByte = imagenByte;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@OneToOne
    @JoinColumn (name="id_paciente",nullable = false)
	private Paciente paciente;
	
	@Column(name="nombre", length = 500,nullable = false)
	private String nombre;
	
	@Column(name="type", length = 500,nullable = false)
	private String type;
	
	@Lob
	@Column(name= "imagen_byte")
	private byte[] imagenByte;

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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	

}
