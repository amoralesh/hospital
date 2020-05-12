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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre",length = 200, nullable = false)
	private String nombre;
	
	@Column(name="apellidos", length = 500, nullable = true)
	private String apellidos;
	
	@ManyToOne
	@JoinColumn(name="id_area")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consulta> consulta;
	
	
	
 
}
