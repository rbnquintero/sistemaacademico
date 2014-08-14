package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_ID_GENERATOR")
	private Long id;

	private String estado;

	private String tabla;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="estadoBean")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="estadoBean")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Calificacionesprep
	@OneToMany(mappedBy="estadoBean")
	private List<Calificacionesprep> calificacionespreps;

	//bi-directional many-to-one association to Calificacionesprim
	@OneToMany(mappedBy="estadoBean")
	private List<Calificacionesprim> calificacionesprims;

	//bi-directional many-to-one association to Maestro
	@OneToMany(mappedBy="estadoBean")
	private List<Maestro> maestros;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="estadoBean")
	private List<Materia> materias;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="estadoBean")
	private List<Mensaje> mensajes;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="estadoBean")
	private List<Reporte> reportes;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="estadoBean")
	private List<Tarea> tareas;

	//bi-directional many-to-one association to TareasAlumno
	@OneToMany(mappedBy="estadoBean")
	private List<TareasAlumno> tareasAlumnos;

	public Estado() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setEstadoBean(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setEstadoBean(null);

		return curso;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setEstadoBean(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setEstadoBean(null);

		return alumno;
	}

	public List<Calificacionesprep> getCalificacionespreps() {
		return this.calificacionespreps;
	}

	public void setCalificacionespreps(List<Calificacionesprep> calificacionespreps) {
		this.calificacionespreps = calificacionespreps;
	}

	public Calificacionesprep addCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().add(calificacionesprep);
		calificacionesprep.setEstadoBean(this);

		return calificacionesprep;
	}

	public Calificacionesprep removeCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().remove(calificacionesprep);
		calificacionesprep.setEstadoBean(null);

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
		calificacionesprim.setEstadoBean(this);

		return calificacionesprim;
	}

	public Calificacionesprim removeCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().remove(calificacionesprim);
		calificacionesprim.setEstadoBean(null);

		return calificacionesprim;
	}

	public List<Maestro> getMaestros() {
		return this.maestros;
	}

	public void setMaestros(List<Maestro> maestros) {
		this.maestros = maestros;
	}

	public Maestro addMaestro(Maestro maestro) {
		getMaestros().add(maestro);
		maestro.setEstadoBean(this);

		return maestro;
	}

	public Maestro removeMaestro(Maestro maestro) {
		getMaestros().remove(maestro);
		maestro.setEstadoBean(null);

		return maestro;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setEstadoBean(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setEstadoBean(null);

		return materia;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setEstadoBean(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setEstadoBean(null);

		return mensaje;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setEstadoBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setEstadoBean(null);

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
		tarea.setEstadoBean(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setEstadoBean(null);

		return tarea;
	}

	public List<TareasAlumno> getTareasAlumnos() {
		return this.tareasAlumnos;
	}

	public void setTareasAlumnos(List<TareasAlumno> tareasAlumnos) {
		this.tareasAlumnos = tareasAlumnos;
	}

	public TareasAlumno addTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().add(tareasAlumno);
		tareasAlumno.setEstadoBean(this);

		return tareasAlumno;
	}

	public TareasAlumno removeTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().remove(tareasAlumno);
		tareasAlumno.setEstadoBean(null);

		return tareasAlumno;
	}

}