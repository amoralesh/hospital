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
@Table(name="consulta")
public class Consulta {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="diagnostico", length = 10000, nullable = false)
	private String diagnostico;
	
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name="id_doctor", nullable=false)
	private Doctor doctor;
	
	@OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tratamiento> tratamiento;

}
