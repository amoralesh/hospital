package com.hospital.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
    @JoinColumn (name="id_paciente",nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="entidad_federativa")
	private EntidadFederativa entidadFederativa;
	
	@ManyToOne
	@JoinColumn(name="alcaldia_municipio")
	private AlcaldiaMunicipio alcaldiaMunicipio;
	
	@Column(name="colonia",length = 10000,nullable = true)
	private String colonia;
	
	@Column(name="codigo_postal",length = 5,nullable = true)
	private int codigoPostal;
	
	@Column(name="calle", length = 10000, nullable = true)
	private String calle;
	
	@Column(name="numero_exterior", length = 1000, nullable = true)
	private String numeroExterior;
	
	@Column(name="numero_interior", length = 1000, nullable = true)
	private String numeroInterior;
	
	
	

}
