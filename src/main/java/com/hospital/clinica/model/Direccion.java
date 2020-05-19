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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="direccion")
public class Direccion {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public EntidadFederativa getEntidadFederativa() {
		return entidadFederativa;
	}

	public void setEntidadFederativa(EntidadFederativa entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	public AlcaldiaMunicipio getAlcaldiaMunicipio() {
		return alcaldiaMunicipio;
	}

	public void setAlcaldiaMunicipio(AlcaldiaMunicipio alcaldiaMunicipio) {
		this.alcaldiaMunicipio = alcaldiaMunicipio;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	

}
