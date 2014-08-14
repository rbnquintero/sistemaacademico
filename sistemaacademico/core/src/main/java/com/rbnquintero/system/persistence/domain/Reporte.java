package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reportes database table.
 * 
 */
@Entity
@Table(name="reportes")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTES_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTES_ID_GENERATOR")
	private Long id;

	private Integer cantidad;

	private String comentarios;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Boolean nuevo;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to TipoReporte
	@ManyToOne
	@JoinColumn(name="\"tipoReporte\"")
	private TipoReporte tipoReporteBean;

	//bi-directional many-to-one association to MotivoReporte
	@ManyToOne
	@JoinColumn(name="motivo")
	private MotivoReporte motivoReporte;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alumno")
	private Alumno alumnoBean;

	//bi-directional many-to-one association to Maestro
	@ManyToOne
	@JoinColumn(name="maestro")
	private Maestro maestroBean;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="materia")
	private Materia materiaBean;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	@JoinColumn(name="grado")
	private Grado gradoBean;

	public Reporte() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getNuevo() {
		return this.nuevo;
	}

	public void setNuevo(Boolean nuevo) {
		this.nuevo = nuevo;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public TipoReporte getTipoReporteBean() {
		return this.tipoReporteBean;
	}

	public void setTipoReporteBean(TipoReporte tipoReporteBean) {
		this.tipoReporteBean = tipoReporteBean;
	}

	public MotivoReporte getMotivoReporte() {
		return this.motivoReporte;
	}

	public void setMotivoReporte(MotivoReporte motivoReporte) {
		this.motivoReporte = motivoReporte;
	}

	public Alumno getAlumnoBean() {
		return this.alumnoBean;
	}

	public void setAlumnoBean(Alumno alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public Maestro getMaestroBean() {
		return this.maestroBean;
	}

	public void setMaestroBean(Maestro maestroBean) {
		this.maestroBean = maestroBean;
	}

	public Materia getMateriaBean() {
		return this.materiaBean;
	}

	public void setMateriaBean(Materia materiaBean) {
		this.materiaBean = materiaBean;
	}

	public Grado getGradoBean() {
		return this.gradoBean;
	}

	public void setGradoBean(Grado gradoBean) {
		this.gradoBean = gradoBean;
	}

}