/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.controller;

import ec.tws2.contfiables.service.ProductosRestConsumer;
import ec.tws2.tcs.contfiables.model.IDTarifaIva;
import ec.tws2.tcs.contfiables.model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marcatoma
 */
@ManagedBean
@RequestScoped
@Named
@ViewScoped
public class ProductosController implements Serializable {

    private Producto producto;
    private List<Producto> productosLista;
    private Producto productoSeleccionado;
    private ProductosRestConsumer rest;
    private List<IDTarifaIva> ivaTarifa;
    private IDTarifaIva iva;

    @PostConstruct
    public void init() {
        productoSeleccionado = new Producto();
//        rest = new ProductosRestConsumer();
        producto = new Producto();
        iva = new IDTarifaIva();
        productosLista = new ArrayList<>();
        //productosLista = obtenerLista2();
        ivaTarifa = new ArrayList<>();
        //obtener la lisa de iva
//        try {
//            ivaTarifa = rest.obtenerListaIva();
//            System.out.println("contenido de iva: " + ivaTarifa.size());
//            for (IDTarifaIva val : ivaTarifa) {
//                System.out.println(val.getDescripcion());
//            }
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }

    }

    public void valueChangedListener() {
        System.out.println("entro al evento");
        System.out.println("id" + productoSeleccionado.getId());

        rest = new ProductosRestConsumer();

        try {
            producto.setId(productoSeleccionado.getId());
            productoSeleccionado = rest.obtenerProducto(productoSeleccionado.getId() + "");
            producto.setCodigo(productoSeleccionado.getCodigo());
            producto.setNombreProducto(productoSeleccionado.getNombreProducto());
            producto.setPrecioUnitario(productoSeleccionado.getPrecioUnitario());
            producto.setInformacionAdicional(productoSeleccionado.getInformacionAdicional());
            producto.setIdTarifaIva(productoSeleccionado.getIdTarifaIva());
            iva = producto.getIdTarifaIva();
            //System.out.println(iva.getDescripcion());
            //System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void guardarProducto() {
        System.out.println("----ingreso al guardar de productos controller");
        producto.setIdTarifaIva(iva);
        rest = new ProductosRestConsumer();
        rest.guardarProducto(producto);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductosLista() {
        rest = new ProductosRestConsumer();
        productosLista = rest.obtenerListaProductos();
        System.out.println(productosLista);
        return productosLista;
    }

    public void setProductosLista(List<Producto> productosLista) {
        this.productosLista = productosLista;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public List<IDTarifaIva> getIvaTarifa() {
        ivaTarifa = rest.obtenerListaIva();
        return ivaTarifa;
    }

    public void setIvaTarifa(List<IDTarifaIva> ivaTarifa) {
        this.ivaTarifa = ivaTarifa;
    }

    public IDTarifaIva getIva() {
        return iva;
    }

    public void setIva(IDTarifaIva iva) {
        this.iva = iva;
    }

}
