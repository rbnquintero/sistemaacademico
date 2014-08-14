package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "tareasAlumnos" database table.
 * 
 */
@Entity
@Table(name="\"tareasAlumnos\"")
@NamedQuery(name="TareasAlumno.findAll", query="SELECT t FROM TareasAlumno t")
public class TareasAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaCambio\"")
	private Date fechaCambio;

	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="tarea")
	private Tarea tareaBean;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alumno")
	private Alumno alumnoBean;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	public TareasAlumno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public Tarea getTareaBean() {
		return this.tareaBean;
	}

	public void setTareaBean(Tarea tareaBean) {
		this.tareaBean = tareaBean;
	}

	public Alumno getAlumnoBean() {
		return this.alumnoBean;
	}

	public void setAlumnoBean(Alumno alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

}