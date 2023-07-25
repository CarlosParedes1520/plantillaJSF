package ec.tws2.tcs.contfiables.model;

import java.util.List;

public class RespSimple {
	
	private String error;
	private String mensaje;
	private String parametroRespuesta;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getParametroRespuesta() {
		return parametroRespuesta;
	}
	public void setParametroRespuesta(String parametroRespuesta) {
		this.parametroRespuesta = parametroRespuesta;
	}	
}
