package ec.tws2.tcs.contfiables.util;

public enum ContfiablesEnum {
	
	TRANSACCION_OK("0","Transaccion exitosa"),
	TRANSACCION_ERROR("1","Transaccion erronea");
	
	private String id;
	private String descripcion;
	
	private ContfiablesEnum(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
