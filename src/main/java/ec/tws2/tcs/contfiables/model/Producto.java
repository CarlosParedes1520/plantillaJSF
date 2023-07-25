/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.contfiables.model;

import java.util.Objects;

/**
 *
 * @author marcatoma
 */
public class Producto {

    private long id;
    private String codigo;
    private String nombreProducto;
    private double precioUnitario;
    private String informacionAdicional;
    private IDTarifaIva idTarifaIva;
    private IDCodigoIce idCodigoIce;

    public Producto() {
    }

    public Producto(long id, String codigo, String nombreProducto, double precioUnitario, String informacionAdicional, IDTarifaIva idTarifaIva, IDCodigoIce idCodigoIce) {
        this.id = id;
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.informacionAdicional = informacionAdicional;
        this.idTarifaIva = idTarifaIva;
        this.idCodigoIce = idCodigoIce;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public IDTarifaIva getIdTarifaIva() {
        return idTarifaIva;
    }

    public void setIdTarifaIva(IDTarifaIva idTarifaIva) {
        this.idTarifaIva = idTarifaIva;
    }

    public IDCodigoIce getIdCodigoIce() {
        return idCodigoIce;
    }

    public void setIdCodigoIce(IDCodigoIce idCodigoIce) {
        this.idCodigoIce = idCodigoIce;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", nombreProducto=" + nombreProducto + ", precioUnitario=" + precioUnitario + ", informacionAdicional=" + informacionAdicional + ", idTarifaIva=" + idTarifaIva.getDescripcion() + ", idCodigoIce=" + "tostring codigo ice" + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nombreProducto);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precioUnitario) ^ (Double.doubleToLongBits(this.precioUnitario) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.informacionAdicional);
        hash = 97 * hash + Objects.hashCode(this.idTarifaIva);
        hash = 97 * hash + Objects.hashCode(this.idCodigoIce);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.precioUnitario) != Double.doubleToLongBits(other.precioUnitario)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombreProducto, other.nombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.informacionAdicional, other.informacionAdicional)) {
            return false;
        }
        if (!Objects.equals(this.idTarifaIva, other.idTarifaIva)) {
            return false;
        }
        return Objects.equals(this.idCodigoIce, other.idCodigoIce);
    }

}
