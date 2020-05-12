package com.hospital.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tratamiento")
public class Tratamiento {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name="id_consulta", nullable=false)
	private Consulta consulta;
	
	@Column(name="dosis", length = 10000, nullable = true)
	private String dosis;
	
	@Column(name="cada_cuando",length = 10000,nullable = true )
	private String cadaCuando;
	
	@ManyToOne
	@JoinColumn(name="id_modo_aplicacion")
	private ModoAplicacion modoAplicacion;
	
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

}
