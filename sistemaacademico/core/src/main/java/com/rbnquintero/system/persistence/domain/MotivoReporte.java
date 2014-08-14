package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "motivoReporte" database table.
 * 
 */
@Entity
@Table(name="\"motivoReporte\"")
@NamedQuery(name="MotivoReporte.findAll", query="SELECT m FROM MotivoReporte m")
public class MotivoReporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String motivo;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="motivoReporte")
	private List<Reporte> reportes;

	public MotivoReporte() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setMotivoReporte(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setMotivoReporte(null);

		return reporte;
	}

}