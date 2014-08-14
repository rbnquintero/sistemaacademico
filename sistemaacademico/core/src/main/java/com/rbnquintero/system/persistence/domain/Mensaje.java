package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mensajes database table.
 * 
 */
@Entity
@Table(name="mensajes")
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENSAJES_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENSAJES_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Boolean leido;

	private String mensaje;

	private String titulo;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="destinatario")
	private Login destinatario;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="remitente")
	private Login remitente;

	public Mensaje() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getLeido() {
		return this.leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public Login getLogin1() {
		return this.destinatario;
	}

	public void setLogin1(Login login1) {
		this.destinatario = login1;
	}

	public Login getLogin2() {
		return this.remitente;
	}

	public void setLogin2(Login login2) {
		this.remitente = login2;
	}

}