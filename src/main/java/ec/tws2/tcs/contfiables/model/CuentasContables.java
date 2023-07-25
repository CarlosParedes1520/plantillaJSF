/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.contfiables.model;

import lombok.Data;

/**
 *
 * @author marcatoma
 */
@Data
public class CuentasContables {
    private String idCuenta;
    private String codigo;
    private String nombreCuenta;

    public CuentasContables(String idCuenta, String codigo, String nombreCuenta) {
        this.idCuenta = idCuenta;
        this.codigo = codigo;
        this.nombreCuenta = nombreCuenta;
    }
    
}
