/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.contfiables.service;

import ec.tws2.tcs.contfiables.model.CuentasContables;
import ec.tws2.contfiables.enviroments.Enviroments;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marcatoma
 */
public class CuentaContableRestConsumer {

    private RestTemplate restTemplate;
    private final String serverCrud = Enviroments.SERVER;

    public List<CuentasContables> obtenerCuentasContables() {
        List<CuentasContables> cuentas = new ArrayList<>();
        cuentas.add(new CuentasContables("1", "010101", "caja"));
        cuentas.add(new CuentasContables("1", "010101", "caja"));
        cuentas.add(new CuentasContables("1", "010101", "caja"));
        cuentas.add(new CuentasContables("1", "010101", "caja"));
        return cuentas;
    }
}
