/*
   Copyright 2009-2021 PrimeTek.

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.primefaces.rain.view;

import ec.tws2.contfiables.service.SpringRestConsumer;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.IOUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

import ec.tws2.tcs.contfiables.model.Cliente;
import ec.tws2.tcs.contfiables.model.FileSignature;
import ec.tws2.tcs.contfiables.model.RespSimple;
import ec.tws2.tcs.contfiables.util.ContfiablesEnum;
import ec.tws2.tcs.contfiables.util.PropertiesUtil;
import ec.tws2.tcs.controller.UserSession;

@Named
@ViewScoped
public class DashboardView implements Serializable {

    private String saludo;
    private String server = "";
    private String validateUserWs = "existeUsuario";
    private String almacenarArchivoWs = "completarRegistro";
    private FileSignature fileSignature;
    private UploadedFile file;
    private String codificacion;
    private String saludoApi;
    
    SpringRestConsumer restConsumer = new SpringRestConsumer();

    @Inject
    UserSession userSession;

    @Inject
    private PropertiesUtil prop;

    private Logger log = Logger.getLogger(DashboardView.class.getName());

    @PostConstruct
    public void init() {
        
        
       // saludoApi = restConsumer.consumeApi();       
    
        /* try {
        	this.ordersThisWeek = this.service.getOrders(25);
            this.ordersLastWeek = this.service.getOrders(25);
            this.orders = this.ordersThisWeek;
			log.info("ENTRO EN EL CONTROLADOR DEL DASHBOARD ");
			this.saludo = "HOLA MUNDO";
			//server = prop.getPropiedad("parametros.properties", "urlServerSpring");
			server = "http://localhost:7070/";
			this.validateUser();
		}catch (Exception e) {
			log.log(Level.SEVERE, "ERROR AL INICIALIZAR EL CONTROLADOR DEL DASHBOARD ",e);
		}*/
    }

    public void validateUser() {
        try {
            Map<String, String> header = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            Cliente usuario = new Cliente();
            //usuario.setUser(userSession.getUserLogin().getUser());
       
            /*RespSimple rest = new RestClientNuevo(server, validateUserWs, usuario, header, "POST", userSession.getUserLogin().getToken()).entity(RespSimple.class);
            log.info(rest.getError());
            if (rest.getError().equals(ContfiablesEnum.TRANSACCION_ERROR.getId())) {
                fileSignature = new FileSignature();
                fileSignature.setCliente(new Cliente());
                PrimeFaces current = PrimeFaces.current();
                current.executeScript("PF('dlg1').show();");
            }*/
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR EN EL VALIDATE USER ", e);
        }
    }

    public void upload(org.primefaces.event.FileUploadEvent event) {
        try {
            file = event.getFile();
            if (file != null) {
                FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", file.getFileName() + " is uploaded."));

                InputStream inputStream = file.getInputStream();
                byte[] bytes = IOUtils.toByteArray(inputStream);
                codificacion = Base64.getEncoder().encodeToString(bytes);
                log.info(codificacion);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR EN EL UPLOAD ", e);
        }
    }

    public void completarRegistro() {
        try {
/*
            fileSignature.setFile64(codificacion);
            Map<String, String> header = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            RespSimple rest = new RestClientNuevo(server, almacenarArchivoWs, fileSignature, header, "POST", userSession.getUserLogin().getToken()).entity(RespSimple.class);
            log.info(rest.getError());
            if (rest.getError().equals(ContfiablesEnum.TRANSACCION_OK.getId())) {
                log.info("registro almacenado correctamente");
            }*/
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR AL COMPLETAR EL REGISTRO ", e);
        }
    }

    public void cargarBoton() {
        try {
            if (file != null) {
                FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", file.getFileName() + " is uploaded."));

                InputStream inputStream = file.getInputStream();
                byte[] bytes = IOUtils.toByteArray(inputStream);
                codificacion = Base64.getEncoder().encodeToString(bytes);
                System.out.println(codificacion);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR AL CARGAR EL ARCHIVO ", e);
        }
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public FileSignature getFileSignature() {
        return fileSignature;
    }

    public void setFileSignature(FileSignature fileSignature) {
        this.fileSignature = fileSignature;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getSaludoApi() {
        return saludoApi;
    }

    public void setSaludoApi(String saludoApi) {
        this.saludoApi = saludoApi;
    }
    
    

}
