package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calificacionesprep database table.
 * 
 */
@Entity
@NamedQuery(name="Calificacionesprep.findAll", query="SELECT c FROM Calificacionesprep c")
public class Calificacionesprep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALIFICACIONESPREP_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALIFICACIONESPREP_ID_GENERATOR")
	private Long id;

	private double csd;

	private double e1;

	private double e2;

	private double e3;

	private double p1;

	private double p2;

	private double p3;

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

	public Calificacionesprep() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCsd() {
		return this.csd;
	}

	public void setCsd(double csd) {
		this.csd = csd;
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

	public double getP1() {
		return this.p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return this.p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	public double getP3() {
		return this.p3;
	}

	public void setP3(double p3) {
		this.p3 = p3;
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