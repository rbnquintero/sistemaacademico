package com.rbnquintero.system.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALUMNOS_MATRICULA_GENERATOR", sequenceName="MATRICULA_ALUMNO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALUMNOS_MATRICULA_GENERATOR")
	private Long matricula;

	private Boolean actanacimiento;

	private String alergias;

	private String apellidom;

	private String apellidop;

	private Boolean avisodebaja;

	private String calleescuela;

	private String calleynumero;

	private Boolean cartaconducta;

	private Boolean certificadopreescolar;

	private Boolean certificadoprimaria;

	private Boolean certificadosecundaria;

	private String ciudad;

	private String codigopostal;

	private String colonia;

	private String coloniaescuela;

	private Boolean copiaactanacimiento;

	private Boolean copiacartaconducta;

	private Boolean copiacertificadopreescolar;

	private Boolean copiacertificadoprimaria;

	private Boolean copiacertificadosecundaria;

	private String curp;

	private Boolean curpdoc;

	private String denfermedad;

	private String emergencia1;

	private String emergencia2;

	private Boolean enfermedad;

	private String fechanacimiento;

	private Boolean fotografiasinfantil;

	private String gradoainscribirse;

	private String iglesia;

//	@Column(name="\"loginId\"")
//	private Long loginId;

	private String lugarnacimiento;

	private String mamaapellidom;

	private String mamaapellidop;

	private String mamacalleynumero;

	private String mamaciudad;

	private String mamacodigopostal;

	private String mamacolonia;

	private String mamanombre;

	private String mamanumerocelular;

	private String mamanumerotelefonico;

	private String mamanumerotrabajo;

	private String mamaocupacion;

	private String mamareligion;

	private String materiasreprobadas;

	private String medicamentos;

	private String nacionalidad;

	private String nivelingreso;

	private String nombre;

	private String nombreplantel;

	private String numerocelular;

	private String numerotelefonico;

	private String papaapellidom;

	private String papaapellidop;

	private String papacalleynumero;

	private String papaciudad;

	private String papacodigopostal;

	private String papacolonia;

	private String papanombre;

	private String papanumerocelular;

	private String papanumerotelefonico;

	private String papanumerotrabajo;

	private String papaocupacion;

	private String papareligion;

	private String password;

	private String promedioanterior;

	private String religion;

	private String semestres;

	private String sexo;

	private Boolean sistemacobach;

	private String telefonoescuela;

	private Integer tiempo;

	private String tiposangre;

	private Boolean ultimaboleta;

	private String ultimaescuela;

	private String ultimogradocursado;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional one-to-one association to Login
	@OneToOne
	@JoinColumn(name="\"loginId\"")
	private Login login;

	//bi-directional many-to-one association to Calificacionesprep
	@OneToMany(mappedBy="alumno")
	private List<Calificacionesprep> calificacionespreps;

	//bi-directional many-to-one association to Calificacionesprim
	@OneToMany(mappedBy="alumno")
	private List<Calificacionesprim> calificacionesprims;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="alumnoBean")
	private List<Reporte> reportes;

	//bi-directional many-to-one association to TareasAlumno
	@OneToMany(mappedBy="alumnoBean")
	private List<TareasAlumno> tareasAlumnos;

	public Alumno() {
	}

	public Long getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Boolean getActanacimiento() {
		return this.actanacimiento;
	}

	public void setActanacimiento(Boolean actanacimiento) {
		this.actanacimiento = actanacimiento;
	}

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
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

	public Boolean getAvisodebaja() {
		return this.avisodebaja;
	}

	public void setAvisodebaja(Boolean avisodebaja) {
		this.avisodebaja = avisodebaja;
	}

	public String getCalleescuela() {
		return this.calleescuela;
	}

	public void setCalleescuela(String calleescuela) {
		this.calleescuela = calleescuela;
	}

	public String getCalleynumero() {
		return this.calleynumero;
	}

	public void setCalleynumero(String calleynumero) {
		this.calleynumero = calleynumero;
	}

	public Boolean getCartaconducta() {
		return this.cartaconducta;
	}

	public void setCartaconducta(Boolean cartaconducta) {
		this.cartaconducta = cartaconducta;
	}

	public Boolean getCertificadopreescolar() {
		return this.certificadopreescolar;
	}

	public void setCertificadopreescolar(Boolean certificadopreescolar) {
		this.certificadopreescolar = certificadopreescolar;
	}

	public Boolean getCertificadoprimaria() {
		return this.certificadoprimaria;
	}

	public void setCertificadoprimaria(Boolean certificadoprimaria) {
		this.certificadoprimaria = certificadoprimaria;
	}

	public Boolean getCertificadosecundaria() {
		return this.certificadosecundaria;
	}

	public void setCertificadosecundaria(Boolean certificadosecundaria) {
		this.certificadosecundaria = certificadosecundaria;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getColoniaescuela() {
		return this.coloniaescuela;
	}

	public void setColoniaescuela(String coloniaescuela) {
		this.coloniaescuela = coloniaescuela;
	}

	public Boolean getCopiaactanacimiento() {
		return this.copiaactanacimiento;
	}

	public void setCopiaactanacimiento(Boolean copiaactanacimiento) {
		this.copiaactanacimiento = copiaactanacimiento;
	}

	public Boolean getCopiacartaconducta() {
		return this.copiacartaconducta;
	}

	public void setCopiacartaconducta(Boolean copiacartaconducta) {
		this.copiacartaconducta = copiacartaconducta;
	}

	public Boolean getCopiacertificadopreescolar() {
		return this.copiacertificadopreescolar;
	}

	public void setCopiacertificadopreescolar(Boolean copiacertificadopreescolar) {
		this.copiacertificadopreescolar = copiacertificadopreescolar;
	}

	public Boolean getCopiacertificadoprimaria() {
		return this.copiacertificadoprimaria;
	}

	public void setCopiacertificadoprimaria(Boolean copiacertificadoprimaria) {
		this.copiacertificadoprimaria = copiacertificadoprimaria;
	}

	public Boolean getCopiacertificadosecundaria() {
		return this.copiacertificadosecundaria;
	}

	public void setCopiacertificadosecundaria(Boolean copiacertificadosecundaria) {
		this.copiacertificadosecundaria = copiacertificadosecundaria;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Boolean getCurpdoc() {
		return this.curpdoc;
	}

	public void setCurpdoc(Boolean curpdoc) {
		this.curpdoc = curpdoc;
	}

	public String getDenfermedad() {
		return this.denfermedad;
	}

	public void setDenfermedad(String denfermedad) {
		this.denfermedad = denfermedad;
	}

	public String getEmergencia1() {
		return this.emergencia1;
	}

	public void setEmergencia1(String emergencia1) {
		this.emergencia1 = emergencia1;
	}

	public String getEmergencia2() {
		return this.emergencia2;
	}

	public void setEmergencia2(String emergencia2) {
		this.emergencia2 = emergencia2;
	}

	public Boolean getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(Boolean enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Boolean getFotografiasinfantil() {
		return this.fotografiasinfantil;
	}

	public void setFotografiasinfantil(Boolean fotografiasinfantil) {
		this.fotografiasinfantil = fotografiasinfantil;
	}

	public String getGradoainscribirse() {
		return this.gradoainscribirse;
	}

	public void setGradoainscribirse(String gradoainscribirse) {
		this.gradoainscribirse = gradoainscribirse;
	}

	public String getIglesia() {
		return this.iglesia;
	}

	public void setIglesia(String iglesia) {
		this.iglesia = iglesia;
	}

//	public Long getLoginId() {
//		return this.loginId;
//	}
//
//	public void setLoginId(Long loginId) {
//		this.loginId = loginId;
//	}

	public String getLugarnacimiento() {
		return this.lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	public String getMamaapellidom() {
		return this.mamaapellidom;
	}

	public void setMamaapellidom(String mamaapellidom) {
		this.mamaapellidom = mamaapellidom;
	}

	public String getMamaapellidop() {
		return this.mamaapellidop;
	}

	public void setMamaapellidop(String mamaapellidop) {
		this.mamaapellidop = mamaapellidop;
	}

	public String getMamacalleynumero() {
		return this.mamacalleynumero;
	}

	public void setMamacalleynumero(String mamacalleynumero) {
		this.mamacalleynumero = mamacalleynumero;
	}

	public String getMamaciudad() {
		return this.mamaciudad;
	}

	public void setMamaciudad(String mamaciudad) {
		this.mamaciudad = mamaciudad;
	}

	public String getMamacodigopostal() {
		return this.mamacodigopostal;
	}

	public void setMamacodigopostal(String mamacodigopostal) {
		this.mamacodigopostal = mamacodigopostal;
	}

	public String getMamacolonia() {
		return this.mamacolonia;
	}

	public void setMamacolonia(String mamacolonia) {
		this.mamacolonia = mamacolonia;
	}

	public String getMamanombre() {
		return this.mamanombre;
	}

	public void setMamanombre(String mamanombre) {
		this.mamanombre = mamanombre;
	}

	public String getMamanumerocelular() {
		return this.mamanumerocelular;
	}

	public void setMamanumerocelular(String mamanumerocelular) {
		this.mamanumerocelular = mamanumerocelular;
	}

	public String getMamanumerotelefonico() {
		return this.mamanumerotelefonico;
	}

	public void setMamanumerotelefonico(String mamanumerotelefonico) {
		this.mamanumerotelefonico = mamanumerotelefonico;
	}

	public String getMamanumerotrabajo() {
		return this.mamanumerotrabajo;
	}

	public void setMamanumerotrabajo(String mamanumerotrabajo) {
		this.mamanumerotrabajo = mamanumerotrabajo;
	}

	public String getMamaocupacion() {
		return this.mamaocupacion;
	}

	public void setMamaocupacion(String mamaocupacion) {
		this.mamaocupacion = mamaocupacion;
	}

	public String getMamareligion() {
		return this.mamareligion;
	}

	public void setMamareligion(String mamareligion) {
		this.mamareligion = mamareligion;
	}

	public String getMateriasreprobadas() {
		return this.materiasreprobadas;
	}

	public void setMateriasreprobadas(String materiasreprobadas) {
		this.materiasreprobadas = materiasreprobadas;
	}

	public String getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNivelingreso() {
		return this.nivelingreso;
	}

	public void setNivelingreso(String nivelingreso) {
		this.nivelingreso = nivelingreso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreplantel() {
		return this.nombreplantel;
	}

	public void setNombreplantel(String nombreplantel) {
		this.nombreplantel = nombreplantel;
	}

	public String getNumerocelular() {
		return this.numerocelular;
	}

	public void setNumerocelular(String numerocelular) {
		this.numerocelular = numerocelular;
	}

	public String getNumerotelefonico() {
		return this.numerotelefonico;
	}

	public void setNumerotelefonico(String numerotelefonico) {
		this.numerotelefonico = numerotelefonico;
	}

	public String getPapaapellidom() {
		return this.papaapellidom;
	}

	public void setPapaapellidom(String papaapellidom) {
		this.papaapellidom = papaapellidom;
	}

	public String getPapaapellidop() {
		return this.papaapellidop;
	}

	public void setPapaapellidop(String papaapellidop) {
		this.papaapellidop = papaapellidop;
	}

	public String getPapacalleynumero() {
		return this.papacalleynumero;
	}

	public void setPapacalleynumero(String papacalleynumero) {
		this.papacalleynumero = papacalleynumero;
	}

	public String getPapaciudad() {
		return this.papaciudad;
	}

	public void setPapaciudad(String papaciudad) {
		this.papaciudad = papaciudad;
	}

	public String getPapacodigopostal() {
		return this.papacodigopostal;
	}

	public void setPapacodigopostal(String papacodigopostal) {
		this.papacodigopostal = papacodigopostal;
	}

	public String getPapacolonia() {
		return this.papacolonia;
	}

	public void setPapacolonia(String papacolonia) {
		this.papacolonia = papacolonia;
	}

	public String getPapanombre() {
		return this.papanombre;
	}

	public void setPapanombre(String papanombre) {
		this.papanombre = papanombre;
	}

	public String getPapanumerocelular() {
		return this.papanumerocelular;
	}

	public void setPapanumerocelular(String papanumerocelular) {
		this.papanumerocelular = papanumerocelular;
	}

	public String getPapanumerotelefonico() {
		return this.papanumerotelefonico;
	}

	public void setPapanumerotelefonico(String papanumerotelefonico) {
		this.papanumerotelefonico = papanumerotelefonico;
	}

	public String getPapanumerotrabajo() {
		return this.papanumerotrabajo;
	}

	public void setPapanumerotrabajo(String papanumerotrabajo) {
		this.papanumerotrabajo = papanumerotrabajo;
	}

	public String getPapaocupacion() {
		return this.papaocupacion;
	}

	public void setPapaocupacion(String papaocupacion) {
		this.papaocupacion = papaocupacion;
	}

	public String getPapareligion() {
		return this.papareligion;
	}

	public void setPapareligion(String papareligion) {
		this.papareligion = papareligion;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPromedioanterior() {
		return this.promedioanterior;
	}

	public void setPromedioanterior(String promedioanterior) {
		this.promedioanterior = promedioanterior;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSemestres() {
		return this.semestres;
	}

	public void setSemestres(String semestres) {
		this.semestres = semestres;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getSistemacobach() {
		return this.sistemacobach;
	}

	public void setSistemacobach(Boolean sistemacobach) {
		this.sistemacobach = sistemacobach;
	}

	public String getTelefonoescuela() {
		return this.telefonoescuela;
	}

	public void setTelefonoescuela(String telefonoescuela) {
		this.telefonoescuela = telefonoescuela;
	}

	public Integer getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public String getTiposangre() {
		return this.tiposangre;
	}

	public void setTiposangre(String tiposangre) {
		this.tiposangre = tiposangre;
	}

	public Boolean getUltimaboleta() {
		return this.ultimaboleta;
	}

	public void setUltimaboleta(Boolean ultimaboleta) {
		this.ultimaboleta = ultimaboleta;
	}

	public String getUltimaescuela() {
		return this.ultimaescuela;
	}

	public void setUltimaescuela(String ultimaescuela) {
		this.ultimaescuela = ultimaescuela;
	}

	public String getUltimogradocursado() {
		return this.ultimogradocursado;
	}

	public void setUltimogradocursado(String ultimogradocursado) {
		this.ultimogradocursado = ultimogradocursado;
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

	public List<Calificacionesprep> getCalificacionespreps() {
		return this.calificacionespreps;
	}

	public void setCalificacionespreps(List<Calificacionesprep> calificacionespreps) {
		this.calificacionespreps = calificacionespreps;
	}

	public Calificacionesprep addCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().add(calificacionesprep);
		calificacionesprep.setAlumno(this);

		return calificacionesprep;
	}

	public Calificacionesprep removeCalificacionesprep(Calificacionesprep calificacionesprep) {
		getCalificacionespreps().remove(calificacionesprep);
		calificacionesprep.setAlumno(null);

		return calificacionesprep;
	}

	public List<Calificacionesprim> getCalificacionesprims() {
		return this.calificacionesprims;
	}

	public void setCalificacionesprims(List<Calificacionesprim> calificacionesprims) {
		this.calificacionesprims = calificacionesprims;
	}

	public Calificacionesprim addCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().add(calificacionesprim);
		calificacionesprim.setAlumno(this);

		return calificacionesprim;
	}

	public Calificacionesprim removeCalificacionesprim(Calificacionesprim calificacionesprim) {
		getCalificacionesprims().remove(calificacionesprim);
		calificacionesprim.setAlumno(null);

		return calificacionesprim;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setAlumnoBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setAlumnoBean(null);

		return reporte;
	}

	public List<TareasAlumno> getTareasAlumnos() {
		return this.tareasAlumnos;
	}

	public void setTareasAlumnos(List<TareasAlumno> tareasAlumnos) {
		this.tareasAlumnos = tareasAlumnos;
	}

	public TareasAlumno addTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().add(tareasAlumno);
		tareasAlumno.setAlumnoBean(this);

		return tareasAlumno;
	}

	public TareasAlumno removeTareasAlumno(TareasAlumno tareasAlumno) {
		getTareasAlumnos().remove(tareasAlumno);
		tareasAlumno.setAlumnoBean(null);

		return tareasAlumno;
	}

}