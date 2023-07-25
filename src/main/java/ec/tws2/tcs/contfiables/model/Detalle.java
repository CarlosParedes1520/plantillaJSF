package ec.tws2.tcs.contfiables.model;

public class Detalle {
    public String codigoPrincipal;
    public String codigoAuxiliar;
    public String descripcion;
    public int cantidad;
    public int precioUnitario;
    public int descuento;
    public int precioTotalSinImpuesto;
    public Impuestos impuestos;
	public String getCodigoPrincipal() {
		return codigoPrincipal;
	}
	public void setCodigoPrincipal(String codigoPrincipal) {
		this.codigoPrincipal = codigoPrincipal;
	}
	public String getCodigoAuxiliar() {
		return codigoAuxiliar;
	}
	public void setCodigoAuxiliar(String codigoAuxiliar) {
		this.codigoAuxiliar = codigoAuxiliar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public int getPrecioTotalSinImpuesto() {
		return precioTotalSinImpuesto;
	}
	public void setPrecioTotalSinImpuesto(int precioTotalSinImpuesto) {
		this.precioTotalSinImpuesto = precioTotalSinImpuesto;
	}
	public Impuestos getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(Impuestos impuestos) {
		this.impuestos = impuestos;
	}
    
    
}
