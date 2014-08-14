package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATERIAS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATERIAS_ID_GENERATOR")
	private Long id;

	private String clave;

	private String nombre;

	private Integer parciales;

	//bi-directional many-to-one association to Calificacionesprep
	@OneToMany(mappedBy="materiaBean")
	private List<Calificacionesprep> calificacionespreps;

	//bi-directional many-to-one association to Calificacionesprim
	@OneToMany(mappedBy="materiaBean")
	private List<Calificacionesprim> calificacionesprims;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to Maestro
	@ManyToOne
	@JoinColumn(name="maestro")
	private Maestro maestroBean;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	@JoinColumn(name="grado")
	private Grado gradoBean;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="materiaBean")
	private List<Reporte> reportes;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="materiaBean")
	private List<Tarea> tareas;

	public Materia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getParciales() {
		return this.parciales;
	}

	public void setParciales(Integer parciales) {
		this.parciales = parciales;
	}

	public List<Calificacionesprep> getCalificacionespreps() {
		return this.calificacionespreps;
	}

	public void setCalificacionespreps(List<Calificacionesprep> calificacionespreps) {
		this.calificacionespreps = calificacionespreps;
	}

	public Calificacionesprep addCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().add(calificacionesprep);
		calificacionesprep.setMateriaBean(this);

		return calificacionesprep;
	}

	public Calificacionesprep removeCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().remove(calificacionesprep);
		calificacionesprep.setMateriaBean(null);

		return calificacionesprep;
	}

	public List<Calificacionesprim> getCalificacionesprims() {
		return this.calificacionesprims;
	}

	public void setCalificacionesprims(List<Calificacionesprim> calificacionesprims) {
		this.calificacionesprims = calificacionesprims;
	}

	public Calificacionesprim addCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().add(calificacionesprim);
		calificacionesprim.setMateriaBean(this);

		return calificacionesprim;
	}

	public Calificacionesprim removeCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().remove(calificacionesprim);
		calificacionesprim.setMateriaBean(null);

		return calificacionesprim;
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

	public Grado getGradoBean() {
		return this.gradoBean;
	}

	public void setGradoBean(Grado gradoBean) {
		this.gradoBean = gradoBean;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setMateriaBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setMateriaBean(null);

		return reporte;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setMateriaBean(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setMateriaBean(null);

		return tarea;
	}

}