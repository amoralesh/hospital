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

