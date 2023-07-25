package ec.tws2.tcs.controller;

import ec.tws2.contfiables.service.SpringRestConsumer;
import ec.tws2.tcs.contfiables.model.UserLogin;
import ec.tws2.tcs.contfiables.util.Propiedades;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@SessionScoped
public class UserSession implements Serializable {

    private Logger log = Logger.getLogger(UserSession.class.getName());

    @Inject
    private HttpServletRequest request;

    @Inject
    private Propiedades prop;

    private UserLogin userLogin;

    private String server = "";
    private String methodTerminos = "admin/aceptaTerminos";
    private String methodSaveTerminos = "admin/guardaTerminos";

    private Boolean verTerminos = false;

    private StreamedContent pdf;

    String fileName = "";

    private boolean aceptaTerminos;
    private boolean habilitaBoton;
    private boolean dialogVisible;

    private SpringRestConsumer apiCall;

    @PostConstruct
    public void initSesion() {
        try {

            server = prop.getPropiedadServer("urlServerSpring");
            //fileName = prop.getPropiedad("parametros.properties", "fileTerminos");
            //cargarPdf();
            this.getData();

            habilitaBoton = true;
            mantenerDialogoEnRecarga();
        } catch (IOException ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarPdf() {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(fileName));
            pdf = DefaultStreamedContent.builder().contentType("application/pdf").name("reporte").stream(() -> is).build();
        } catch (IOException ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void killSession() {
        try {
            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        try {
            apiCall = new SpringRestConsumer();
            userLogin = new UserLogin();
            KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
            String username = principal.getKeycloakSecurityContext().getIdToken().getPreferredUsername();
            String name = principal.getKeycloakSecurityContext().getIdToken().getName();
            String email = principal.getKeycloakSecurityContext().getIdToken().getEmail();
            userLogin.setUser(username);
            userLogin.setName(name);
            userLogin.setEmail(email);
            //String token = principal.getKeycloakSecurityContext().getTokenString();
            if (apiCall.obtenerUsuario(username) == null) {
                dialogVisible = true;
            } else {
                dialogVisible = false;
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR AL INICIAR LA SESION ", e);
        }
    }

    public void mantenerDialogoEnRecarga() {
        if (dialogVisible) {
            PrimeFaces.current().executeScript("PF('dlg3').show();");
        }
    }

    public boolean obtenerTerminos(String m_user) {
        boolean ban = false;
        /*   try {
            Map<String, String> header = new HashMap<>();
            String val = new RestClientNuevo(server, methodTerminos, m_user, header, "POST", userLogin.getToken()).entity(String.class);
            if (val.equals("0")) {
                ban = true;
            }           
        } catch (IOException ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return ban;
    }

    public void onIdle() {        //1800000
        try {
            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            String contexto = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
            FacesContext.getCurrentInstance().getExternalContext().redirect(contexto + "/landingPage.xhtml");
        } catch (IOException ex) {
            log.log(Level.SEVERE, "ERROR AL CERRAR LA SESION POR INACTIVIDAD", ex);
        } catch (ServletException ex) {
            log.log(Level.SEVERE, "ERROR AL CERRAR LA SESION POR INACTIVIDAD", ex);
        }
    }

    public void addMessage() {
        log.info("aceptaTerminos =" + aceptaTerminos);
        if (aceptaTerminos) {
            habilitaBoton = true;
            log.info("disableeee =" + habilitaBoton);
        } else {
            habilitaBoton = false;
            log.info("enableeee =" + habilitaBoton);
        }
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public StreamedContent getPdf() {
        return pdf;
    }

    public void setPdf(StreamedContent pdf) {
        this.pdf = pdf;
    }

    public boolean isAceptaTerminos() {
        return aceptaTerminos;
    }

    public void setAceptaTerminos(boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }

    public boolean isHabilitaBoton() {
        return habilitaBoton;
    }

    public void setHabilitaBoton(boolean habilitaBoton) {
        this.habilitaBoton = habilitaBoton;
    }

}
