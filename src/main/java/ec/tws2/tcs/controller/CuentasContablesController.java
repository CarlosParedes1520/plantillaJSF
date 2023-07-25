/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.controller;

import ec.tws2.tcs.contfiables.model.CuentasContables;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marcatoma
 */
@Named
@ViewScoped
public class CuentasContablesController implements Serializable {

    private CuentasContables cuentasContables;
    private Logger log = Logger.getLogger(FacturacionController.class.getName());

    @PostConstruct
    public void init() {
        log.info("controlador de cuentas contables");
    }
}
