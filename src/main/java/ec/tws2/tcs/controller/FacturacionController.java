package ec.tws2.tcs.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.tws2.tcs.contfiables.model.CampoAdicional;
import ec.tws2.tcs.contfiables.model.Detalle;
import ec.tws2.tcs.contfiables.model.Detalles;
import ec.tws2.tcs.contfiables.model.Factura;
import ec.tws2.tcs.contfiables.model.Impuesto;
import ec.tws2.tcs.contfiables.model.Impuestos;
import ec.tws2.tcs.contfiables.model.InfoAdicional;
import ec.tws2.tcs.contfiables.model.InfoFactura;
import ec.tws2.tcs.contfiables.model.InfoTributaria;
import ec.tws2.tcs.contfiables.model.Pago;
import ec.tws2.tcs.contfiables.model.Pagos;
import ec.tws2.tcs.contfiables.model.TotalConImpuestos;
import ec.tws2.tcs.contfiables.model.TotalImpuesto;

@Named
@ViewScoped
public class FacturacionController implements Serializable {

    private String saludo;
    private Factura factura;

    private Logger log = Logger.getLogger(FacturacionController.class.getName());

    @PostConstruct
    public void init() {
        try {
            log.info("Entro en el controlador de la facturacion");
            saludo = "12333333333333333333";
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR AL INIT DEL FACTURACION ", e);
        }
    }

    public void modal() {
        System.out.println("holas");
    }

    public void sendFactura() {
        try {
            factura.setInfoTributaria(new InfoTributaria());
            factura.getInfoTributaria().setAmbiente("1");
            factura.getInfoTributaria().setTipoEmision("1");
            factura.getInfoTributaria().setRazonSocial("JUAN JOSE LUCERO");
            factura.getInfoTributaria().setRuc("0104282587001");
            factura.getInfoTributaria().setClaveAcceso("1711202201010428258700110011000000000021234567814");
            factura.getInfoTributaria().setCodDoc("01");
            factura.getInfoTributaria().setEstab("001");
            factura.getInfoTributaria().setPtoEmi("100");
            factura.getInfoTributaria().setSecuencial("000000002");
            factura.getInfoTributaria().setDirMatriz("Direccion Matriz");
            factura.getInfoTributaria().setContribuyenteRimpe("1");

            factura.setInfoFactura(new InfoFactura());
            Date fecha = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            factura.getInfoFactura().setFechaEmision(dateFormat.format(fecha));
            factura.getInfoFactura().setDirEstablecimiento("Direccion Establecimiento");
            factura.getInfoFactura().setObligadoContabilidad("SI");
            factura.getInfoFactura().setTipoIdentificacionComprador("05");
            factura.getInfoFactura().setRazonSocialComprador("WILLIAM ASTUDIKLLO");
            factura.getInfoFactura().setIdentificacionComprador("0104809462");
            factura.getInfoFactura().setDireccionComprador("Hugo vivar");
            factura.getInfoFactura().setTotalSinImpuestos(100);
            factura.getInfoFactura().setTotalDescuento(0);

            TotalImpuesto totalImpuesto = new TotalImpuesto();
            totalImpuesto.setCodigo("2");
            totalImpuesto.setCodigoPorcentaje("2");
            totalImpuesto.setBaseImponible(100);
            totalImpuesto.setTarifa(12);
            totalImpuesto.setValor(12);

            List<TotalImpuesto> lstTotalImpuesto = new ArrayList<>();
            lstTotalImpuesto.add(totalImpuesto);
            TotalConImpuestos totalConImpuesto = new TotalConImpuestos();
            totalConImpuesto.setTotalImpuesto(lstTotalImpuesto);

            factura.getInfoFactura().setTotalConImpuestos(totalConImpuesto);
            factura.getInfoFactura().setImporteTotal(12);

            Pagos pagos = new Pagos();
            Pago pago = new Pago();
            pago.setFormaPago("20");
            pago.setTotal(112);
            List<Pago> lstPago = new ArrayList<>();
            lstPago.add(pago);
            pagos.setPago(lstPago);
            factura.getInfoFactura().setPagos(pagos);

            Detalles detalles = new Detalles();
            Detalle detalle = new Detalle();
            detalle.setCodigoPrincipal("COD01");
            detalle.setCodigoAuxiliar("");
            detalle.setDescripcion("Producto 1");
            detalle.setCantidad(1);
            detalle.setPrecioUnitario(100);
            detalle.setDescuento(0);
            detalle.setPrecioTotalSinImpuesto(100);

            Impuestos impuestos = new Impuestos();
            Impuesto impuesto = new Impuesto();
            impuesto.setCodigo("2");
            impuesto.setCodigoPorcentaje("2");
            impuesto.setTarifa(12);
            impuesto.setBaseImponible(100);
            impuesto.setValor(12);

            List<Impuesto> lstImpuesto = new ArrayList<>();
            lstImpuesto.add(impuesto);
            impuestos.setImpuesto(lstImpuesto);
            detalle.setImpuestos(impuestos);
            List<Detalle> lstDetalle = new ArrayList<>();
            lstDetalle.add(detalle);
            detalles.setDetalle(lstDetalle);
            factura.setDetalles(detalles);

            InfoAdicional infoAdicional = new InfoAdicional();
            CampoAdicional campoAdicional = new CampoAdicional();
            campoAdicional.setValue("PRIMERA VERSION");
            campoAdicional.setNombre("prueba");
            List<CampoAdicional> lstCampoAdicional = new ArrayList<>();
            lstCampoAdicional.add(campoAdicional);
            infoAdicional.setCampoAdicional(lstCampoAdicional);
            factura.setInfoAdicional(infoAdicional);
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR AL ARMAR LA FACTURA ", e);
        }
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

}
