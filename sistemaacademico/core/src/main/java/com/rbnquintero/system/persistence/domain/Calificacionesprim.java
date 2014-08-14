package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calificacionesprim database table.
 * 
 */
@Entity
@NamedQuery(name="Calificacionesprim.findAll", query="SELECT c FROM Calificacionesprim c")
public class Calificacionesprim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALIFICACIONESPRIM_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALIFICACIONESPRIM_ID_GENERATOR")
	private Long id;

	private double b1;

	private double b2;

	private double b3;

	private double b4;

	private double b5;

	private double e1;

	private double e2;

	private double e3;

	private double prom;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="matricula")
	private Alumno alumno;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="materia")
	private Materia materiaBean;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso cursoBean;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	public Calificacionesprim() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getB1() {
		return this.b1;
	}

	public void setB1(double b1) {
		this.b1 = b1;
	}

	public double getB2() {
		return this.b2;
	}

	public void setB2(double b2) {
		this.b2 = b2;
	}

	public double getB3() {
		return this.b3;
	}

	public void setB3(double b3) {
		this.b3 = b3;
	}

	public double getB4() {
		return this.b4;
	}

	public void setB4(double b4) {
		this.b4 = b4;
	}

	public double getB5() {
		return this.b5;
	}

	public void setB5(double b5) {
		this.b5 = b5;
	}

	public double getE1() {
		return this.e1;
	}

	public void setE1(double e1) {
		this.e1 = e1;
	}

	public double getE2() {
		return this.e2;
	}

	public void setE2(double e2) {
		this.e2 = e2;
	}

	public double getE3() {
		return this.e3;
	}

	public void setE3(double e3) {
		this.e3 = e3;
	}

	public double getProm() {
		return this.prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateriaBean() {
		return this.materiaBean;
	}

	public void setMateriaBean(Materia materiaBean) {
		this.materiaBean = materiaBean;
	}

	public Curso getCursoBean() {
		return this.cursoBean;
	}

	public void setCursoBean(Curso cursoBean) {
		this.cursoBean = cursoBean;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

}