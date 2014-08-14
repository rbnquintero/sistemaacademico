package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADO_ID_GENERATOR")
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="nivel")
	private Nivel nivelBean;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="gradoBean")
	private List<Materia> materias;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="gradoBean")
	private List<Reporte> reportes;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="gradoBean")
	private List<Tarea> tareas;

	public Grado() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivelBean() {
		return this.nivelBean;
	}

	public void setNivelBean(Nivel nivelBean) {
		this.nivelBean = nivelBean;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setGradoBean(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setGradoBean(null);

		return materia;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setGradoBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setGradoBean(null);

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
		tarea.setGradoBean(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setGradoBean(null);

		return tarea;
	}

}