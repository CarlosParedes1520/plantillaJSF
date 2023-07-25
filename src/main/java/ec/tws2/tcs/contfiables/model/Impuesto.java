package ec.tws2.tcs.contfiables.model;

public class Impuesto {

	public String codigo;
    public String codigoPorcentaje;
    public int tarifa;
    public int baseImponible;
    public int valor;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoPorcentaje() {
		return codigoPorcentaje;
	}
	public void setCodigoPorcentaje(String codigoPorcentaje) {
		this.codigoPorcentaje = codigoPorcentaje;
	}
	public int getTarifa() {
		return tarifa;
	}
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	public int getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(int baseImponible) {
		this.baseImponible = baseImponible;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
    
    
}
