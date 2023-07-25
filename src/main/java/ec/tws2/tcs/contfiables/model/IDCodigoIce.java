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
public class IDCodigoIce {

    private long id;
    private long codigoIce;
    private String descripcionIce;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodigoIce() {
        return codigoIce;
    }

    public void setCodigoIce(long codigoIce) {
        this.codigoIce = codigoIce;
    }

    public String getDescripcionIce() {
        return descripcionIce;
    }

    public void setDescripcionIce(String descripcionIce) {
        this.descripcionIce = descripcionIce;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + (int) (this.codigoIce ^ (this.codigoIce >>> 32));
        hash = 41 * hash + Objects.hashCode(this.descripcionIce);
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
        final IDCodigoIce other = (IDCodigoIce) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codigoIce != other.codigoIce) {
            return false;
        }
        return Objects.equals(this.descripcionIce, other.descripcionIce);
    }

}
