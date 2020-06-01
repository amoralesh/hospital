package com.hospital.clinica.model;

import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Paciente")
public class Paciente {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 500,nullable = false)
	private String nombre;
	
	@Column(name="apellido_P", length = 500, nullable = false)
	private String ApellidoP;
	
	@Column(name="apellido_M", length = 500, nullable = true)
	private String apellidoM;
	
	@Column(name="fecha_nacimiento", nullable = true)
	private LocalDateTime fechaNacimiento;
	
	@Column(name="edad",length = 3, nullable = true)
	private int edad;
	
	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name="id_estado_civil")
	private EstadoCivil estadoCivil;
	
    @Column(name="curp",length = 21,nullable = true)
	private String curp;
	
    @Column(name="correo",length = 100,nullable = true)
	private String correo;
    
    @Column(name="telefono",length = 12,nullable = true)
	private Integer telefono;
    
    @Column(name="telefono_celular",length = 12,nullable = true)
	private Integer telefonoCelular;
    
    @Column(name="estatus", nullable = false)
	private boolean estatus;
    
    private LocalDateTime fechaAlta;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 	private List<Consulta> consulta;
    
    @OneToOne (mappedBy="paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Direccion direccion;
    
    
    @OneToOne (mappedBy="paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ImagenPaciente imagenPaciente;
    

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

	public String getApellidoP() {
		return ApellidoP;
	}

	public void setApellidoP(String apellidoP) {
		ApellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(int telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public void setTelefonoCelular(Integer telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public ImagenPaciente getImagenPaciente() {
		return imagenPaciente;
	}

	public void setImagenPaciente(ImagenPaciente imagenPaciente) {
		this.imagenPaciente = imagenPaciente;
	}
	
    


}
