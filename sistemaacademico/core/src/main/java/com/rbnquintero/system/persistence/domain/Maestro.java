package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the maestros database table.
 * 
 */
@Entity
@Table(name="maestros")
@NamedQuery(name="Maestro.findAll", query="SELECT m FROM Maestro m")
public class Maestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAESTROS_ID_GENERATOR", sequenceName="MATRICULA_PROFE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAESTROS_ID_GENERATOR")
	private Long id;

	private String apellidom;

	private String apellidop;

	private String calleynumero;

	private String colonia;

	private String curp;

	private String email;

	private String estudios;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaNacimiento\"")
	private Date fechaNacimiento;

//	@Column(name="\"loginId\"")
//	private Long loginId;

	private String nombre;

	private String nss;

	private String numcelular;

	private String numtelefono;

	private String rfc;

	private String snombre;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional one-to-one association to Login
	@OneToOne
	@JoinColumn(name="\"loginId\"")
	private Login login;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="maestroBean")
	private List<Materia> materias;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="maestroBean")
	private List<Reporte> reportes;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="maestroBean")
	private List<Tarea> tareas;

	public Maestro() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidom() {
		return this.apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getApellidop() {
		return this.apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getCalleynumero() {
		return this.calleynumero;
	}

	public void setCalleynumero(String calleynumero) {
		this.calleynumero = calleynumero;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstudios() {
		return this.estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

//	public Long getLoginId() {
//		return this.loginId;
//	}
//
//	public void setLoginId(Long loginId) {
//		this.loginId = loginId;
//	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNss() {
		return this.nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumcelular() {
		return this.numcelular;
	}

	public void setNumcelular(String numcelular) {
		this.numcelular = numcelular;
	}

	public String getNumtelefono() {
		return this.numtelefono;
	}

	public void setNumtelefono(String numtelefono) {
		this.numtelefono = numtelefono;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSnombre() {
		return this.snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setMaestroBean(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setMaestroBean(null);

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
		reporte.setMaestroBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setMaestroBean(null);

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
		tarea.setMaestroBean(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setMaestroBean(null);

		return tarea;
	}

}