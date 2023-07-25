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
public class IDTarifaIva {

    private long idTarifaIva;
    private String descripcion;
    private long porcentaje;
    private String codigoSri;

    public long getIdTarifaIva() {
        return idTarifaIva;
    }

    public void setIdTarifaIva(long idTarifaIva) {
        this.idTarifaIva = idTarifaIva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCodigoSri() {
        return codigoSri;
    }

    public void setCodigoSri(String codigoSri) {
        this.codigoSri = codigoSri;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.idTarifaIva ^ (this.idTarifaIva >>> 32));
        hash = 79 * hash + Objects.hashCode(this.descripcion);
        hash = 79 * hash + (int) (this.porcentaje ^ (this.porcentaje >>> 32));
        hash = 79 * hash + Objects.hashCode(this.codigoSri);
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
        final IDTarifaIva other = (IDTarifaIva) obj;
        if (this.idTarifaIva != other.idTarifaIva) {
            return false;
        }
        if (this.porcentaje != other.porcentaje) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.codigoSri, other.codigoSri);
    }

    @Override
    public String toString() {
        return "IDTarifaIva{" + "idTarifaIva=" + idTarifaIva + ", descripcion=" + descripcion + ", porcentaje=" + porcentaje + ", codigoSri=" + codigoSri + '}';
    }

}
