package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "tipoReporte" database table.
 * 
 */
@Entity
@Table(name="\"tipoReporte\"")
@NamedQuery(name="TipoReporte.findAll", query="SELECT t FROM TipoReporte t")
public class TipoReporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="\"tipoReporte\"")
	private String tipoReporte;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="tipoReporteBean")
	private List<Reporte> reportes;

	public TipoReporte() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoReporte() {
		return this.tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setTipoReporteBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setTipoReporteBean(null);

		return reporte;
	}

}