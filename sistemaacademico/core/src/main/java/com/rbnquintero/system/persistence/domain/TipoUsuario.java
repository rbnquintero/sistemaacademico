package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "tipoUsuario" database table.
 * 
 */
@Entity
@Table(name="\"tipoUsuario\"")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="tipoUsuarioBean")
	private List<Login> logins;

	public TipoUsuario() {
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

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setTipoUsuarioBean(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setTipoUsuarioBean(null);

		return login;
	}

}