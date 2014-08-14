package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEL_ID_GENERATOR")
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Grado
	@OneToMany(mappedBy="nivelBean")
	private List<Grado> grados;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="nivelBean")
	private List<Curso> cursos;

	public Nivel() {
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

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

	public Grado addGrado(Grado grado) {
		getGrados().add(grado);
		grado.setNivelBean(this);

		return grado;
	}

	public Grado removeGrado(Grado grado) {
		getGrados().remove(grado);
		grado.setNivelBean(null);

		return grado;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setNivelBean(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setNivelBean(null);

		return curso;
	}

}