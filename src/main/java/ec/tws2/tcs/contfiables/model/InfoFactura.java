package ec.tws2.tcs.contfiables.model;

public class InfoFactura {
	public String fechaEmision;
    public String dirEstablecimiento;
    public String obligadoContabilidad;
    public String tipoIdentificacionComprador;
    public String razonSocialComprador;
    public String identificacionComprador;
    public String direccionComprador;
    public int totalSinImpuestos;
    public int totalDescuento;
    public TotalConImpuestos totalConImpuestos;
    public int importeTotal;
    public Pagos pagos;
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getDirEstablecimiento() {
		return dirEstablecimiento;
	}
	public void setDirEstablecimiento(String dirEstablecimiento) {
		this.dirEstablecimiento = dirEstablecimiento;
	}
	public String getObligadoContabilidad() {
		return obligadoContabilidad;
	}
	public void setObligadoContabilidad(String obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}
	public String getTipoIdentificacionComprador() {
		return tipoIdentificacionComprador;
	}
	public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
		this.tipoIdentificacionComprador = tipoIdentificacionComprador;
	}
	public String getRazonSocialComprador() {
		return razonSocialComprador;
	}
	public void setRazonSocialComprador(String razonSocialComprador) {
		this.razonSocialComprador = razonSocialComprador;
	}
	public String getIdentificacionComprador() {
		return identificacionComprador;
	}
	public void setIdentificacionComprador(String identificacionComprador) {
		this.identificacionComprador = identificacionComprador;
	}
	public String getDireccionComprador() {
		return direccionComprador;
	}
	public void setDireccionComprador(String direccionComprador) {
		this.direccionComprador = direccionComprador;
	}
	public int getTotalSinImpuestos() {
		return totalSinImpuestos;
	}
	public void setTotalSinImpuestos(int totalSinImpuestos) {
		this.totalSinImpuestos = totalSinImpuestos;
	}
	public int getTotalDescuento() {
		return totalDescuento;
	}
	public void setTotalDescuento(int totalDescuento) {
		this.totalDescuento = totalDescuento;
	}
	public TotalConImpuestos getTotalConImpuestos() {
		return totalConImpuestos;
	}
	public void setTotalConImpuestos(TotalConImpuestos totalConImpuestos) {
		this.totalConImpuestos = totalConImpuestos;
	}
	public int getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(int importeTotal) {
		this.importeTotal = importeTotal;
	}
	public Pagos getPagos() {
		return pagos;
	}
	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}
    
}