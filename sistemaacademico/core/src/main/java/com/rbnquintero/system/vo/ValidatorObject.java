package com.rbnquintero.system.vo;

public class ValidatorObject {
	private String campo;
	private String mensajeError;
	
	public ValidatorObject(String campo, String mensajeError){
		this.campo = campo;
		this.mensajeError = mensajeError;
	}

	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}
