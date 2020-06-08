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
	
	@Column(name="dosis", length = 255, nullable = true)
	private String dosis;
	
	@Column(name="cada_cuando",length = 255,nullable = true )
	private String cadaCuando;
	
	@ManyToOne
	@JoinColumn(name="id_modo_aplicacion")
	private ModoAplicacion modoAplicacion;
	
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getCadaCuando() {
		return cadaCuando;
	}

	public void setCadaCuando(String cadaCuando) {
		this.cadaCuando = cadaCuando;
	}

	public ModoAplicacion getModoAplicacion() {
		return modoAplicacion;
	}

	public void setModoAplicacion(ModoAplicacion modoAplicacion) {
		this.modoAplicacion = modoAplicacion;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	

}
