package com.hospital.clinica.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable = false, length = 50)
	private String username;
	
	@Column(name="password", nullable = false , length = 255)
	private String password;
	
	@Column(name="nombre1", nullable = false , length = 255)
	private String nombre;
	
	@Column(name="apellido_p", nullable = false , length = 255)
	private String apellidoP;
	
	@Column(name="apellido_m", nullable = false , length = 255)
	private String apellidoM;
	
	@Column(name="estatus", nullable = false, length = 3)
	private boolean estatus;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuarios_permisos", joinColumns = @JoinColumn(name="id_usuario", nullable = false,referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="id_permisos", nullable = false,referencedColumnName = "id") )
	private List<Permisos> permisos;

	
	 @OneToOne (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private ImagenUsuario imagenUsuario;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoP() {
		return apellidoP;
	}


	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}


	public String getApellidoM() {
		return apellidoM;
	}


	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}


	public boolean isEstatus() {
		return estatus;
	}


	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}


	public List<Permisos> getPermisos() {
		return permisos;
	}


	public void setPermisos(List<Permisos> permisos) {
		this.permisos = permisos;
	}


	public ImagenUsuario getImagenUsuario() {
		return imagenUsuario;
	}


	public void setImagenUsuario(ImagenUsuario imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}



	 
	

	

}

