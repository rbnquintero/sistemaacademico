package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tareas database table.
 * 
 */
@Entity
@Table(name="tareas")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAREAS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAREAS_ID_GENERATOR")
	private Long id;

	private String explicacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String titulo;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	@JoinColumn(name="grado")
	private Grado gradoBean;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to Maestro
	@ManyToOne
	@JoinColumn(name="maestro")
	private Maestro maestroBean;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="materia")
	private Materia materiaBean;

	//bi-directional many-to-one association to TareasAlumno
	@OneToMany(mappedBy="tareaBean")
	private List<TareasAlumno> tareasAlumnos;

	public Tarea() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Grado getGradoBean() {
		return this.gradoBean;
	}

	public void setGradoBean(Grado gradoBean) {
		this.gradoBean = gradoBean;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public Maestro getMaestroBean() {
		return this.maestroBean;
	}

	public void setMaestroBean(Maestro maestroBean) {
		this.maestroBean = maestroBean;
	}

	public Materia getMateriaBean() {
		return this.materiaBean;
	}

	public void setMateriaBean(Materia materiaBean) {
		this.materiaBean = materiaBean;
	}

	public List<TareasAlumno> getTareasAlumnos() {
		return this.tareasAlumnos;
	}

	public void setTareasAlumnos(List<TareasAlumno> tareasAlumnos) {
		this.tareasAlumnos = tareasAlumnos;
	}

	public TareasAlumno addTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().add(tareasAlumno);
		tareasAlumno.setTareaBean(this);

		return tareasAlumno;
	}

	public TareasAlumno removeTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().remove(tareasAlumno);
		tareasAlumno.setTareaBean(null);

		return tareasAlumno;
	}

}