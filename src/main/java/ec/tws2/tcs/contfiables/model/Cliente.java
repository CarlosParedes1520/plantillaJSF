package ec.tws2.tcs.contfiables.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lombok.Data;

public class Cliente {

    private String idCliente;
    private String identification;
    private String nombres;
    private String apellidos;
    private String clave;
    private String ciudad;
    private String telefono;
    private IDTipoIdentificacion tipo;
    private String emailCliente;
    private String user;
    private String archivoFirma;
    private String claveFirma;
    private String logo;
    private String logo64;
    private List<String> ciudades = Arrays.asList("Guayaquil", "Quito", "Machala");
    private boolean valorPresente;

    public void compararArrays() {

    }

    public void items() {
        System.out.println("ver input");
        if (ciudades.contains(ciudad)) {
            ciudades.remove(ciudad);

        } else {
            ciudades.add(ciudad);

        }
        valorPresente = Arrays.asList(ciudades).contains(ciudad);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public IDTipoIdentificacion getTipo() {
        return tipo;
    }

    public void setTipo(IDTipoIdentificacion tipo) {
        this.tipo = tipo;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getArchivoFirma() {
        return archivoFirma;
    }

    public void setArchivoFirma(String archivoFirma) {
        this.archivoFirma = archivoFirma;
    }

    public String getClaveFirma() {
        return claveFirma;
    }

    public void setClaveFirma(String claveFirma) {
        this.claveFirma = claveFirma;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo64() {
        return logo64;
    }

    public void setLogo64(String logo64) {
        this.logo64 = logo64;
    }

    public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    public boolean isValorPresente() {
        return valorPresente;
    }

    public void setValorPresente(boolean valorPresente) {
        this.valorPresente = valorPresente;
    }
    
    
}
