package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Boolean calificarajenos;

	private Boolean cambiarprivilegios;

	private Boolean confirmarreportes;

	private Boolean crearmaestros;

	private Boolean crearmaterias;

	private Boolean inscribir;

	private String password;

	private String username;

	private Boolean vercalificaciones;

	//bi-directional one-to-one association to Alumno
	@OneToOne(mappedBy="login")
	private Alumno alumno;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso cursoBean;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="\"tipoUsuario\"")
	private TipoUsuario tipoUsuarioBean;

	//bi-directional one-to-one association to Maestro
	@OneToOne(mappedBy="login")
	private Maestro maestro;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="destinatario")
	private List<Mensaje> mensajes1;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="remitente")
	private List<Mensaje> mensajes2;

	public Login() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCalificarajenos() {
		return this.calificarajenos;
	}

	public void setCalificarajenos(Boolean calificarajenos) {
		this.calificarajenos = calificarajenos;
	}

	public Boolean getCambiarprivilegios() {
		return this.cambiarprivilegios;
	}

	public void setCambiarprivilegios(Boolean cambiarprivilegios) {
		this.cambiarprivilegios = cambiarprivilegios;
	}

	public Boolean getConfirmarreportes() {
		return this.confirmarreportes;
	}

	public void setConfirmarreportes(Boolean confirmarreportes) {
		this.confirmarreportes = confirmarreportes;
	}

	public Boolean getCrearmaestros() {
		return this.crearmaestros;
	}

	public void setCrearmaestros(Boolean crearmaestros) {
		this.crearmaestros = crearmaestros;
	}

	public Boolean getCrearmaterias() {
		return this.crearmaterias;
	}

	public void setCrearmaterias(Boolean crearmaterias) {
		this.crearmaterias = crearmaterias;
	}

	public Boolean getInscribir() {
		return this.inscribir;
	}

	public void setInscribir(Boolean inscribir) {
		this.inscribir = inscribir;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getVercalificaciones() {
		return this.vercalificaciones;
	}

	public void setVercalificaciones(Boolean vercalificaciones) {
		this.vercalificaciones = vercalificaciones;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

	public TipoUsuario getTipoUsuarioBean() {
		return this.tipoUsuarioBean;
	}

	public void setTipoUsuarioBean(TipoUsuario tipoUsuarioBean) {
		this.tipoUsuarioBean = tipoUsuarioBean;
	}

	public Maestro getMaestro() {
		return this.maestro;
	}

	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}

	public List<Mensaje> getMensajes1() {
		return this.mensajes1;
	}

	public void setMensajes1(List<Mensaje> mensajes1) {
		this.mensajes1 = mensajes1;
	}

	public Mensaje addMensajes1(Mensaje mensajes1) {
		getMensajes1().add(mensajes1);
		mensajes1.setLogin1(this);

		return mensajes1;
	}

	public Mensaje removeMensajes1(Mensaje mensajes1) {
		getMensajes1().remove(mensajes1);
		mensajes1.setLogin1(null);

		return mensajes1;
	}

	public List<Mensaje> getMensajes2() {
		return this.mensajes2;
	}

	public void setMensajes2(List<Mensaje> mensajes2) {
		this.mensajes2 = mensajes2;
	}

	public Mensaje addMensajes2(Mensaje mensajes2) {
		getMensajes2().add(mensajes2);
		mensajes2.setLogin2(this);

		return mensajes2;
	}

	public Mensaje removeMensajes2(Mensaje mensajes2) {
		getMensajes2().remove(mensajes2);
		mensajes2.setLogin2(null);

		return mensajes2;
	}

}