package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CURSOS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURSOS_ID_GENERATOR")
	private Long id;

	private String clave;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaFinal\"")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaInicio\"")
	private Date fechaInicio;

	private String matricula;

	private String nombre;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="nivel")
	private Nivel nivelBean;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to Calificacionesprep
	@OneToMany(mappedBy="cursoBean")
	private List<Calificacionesprep> calificacionespreps;

	//bi-directional many-to-one association to Calificacionesprim
	@OneToMany(mappedBy="cursoBean")
	private List<Calificacionesprim> calificacionesprims;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="cursoBean")
	private List<Login> logins;

	public Curso() {
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

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public List<Calificacionesprep> getCalificacionespreps() {
		return this.calificacionespreps;
	}

	public void setCalificacionespreps(List<Calificacionesprep> calificacionespreps) {
		this.calificacionespreps = calificacionespreps;
	}

	public Calificacionesprep addCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().add(calificacionesprep);
		calificacionesprep.setCursoBean(this);

		return calificacionesprep;
	}

	public Calificacionesprep removeCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().remove(calificacionesprep);
		calificacionesprep.setCursoBean(null);

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
		calificacionesprim.setCursoBean(this);

		return calificacionesprim;
	}

	public Calificacionesprim removeCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().remove(calificacionesprim);
		calificacionesprim.setCursoBean(null);

		return calificacionesprim;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setCursoBean(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setCursoBean(null);

		return login;
	}

}