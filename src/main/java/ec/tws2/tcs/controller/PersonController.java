
package ec.tws2.tcs.controller;

import ec.tws2.tcs.contfiables.model.PersonDemo;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author juanc
 */
@Named
@ViewScoped
public class PersonController implements Serializable{

    private static final Logger LOG = Logger.getLogger(PersonController.class.getName());
    
    private PersonDemo persona=new PersonDemo();
    
    
    @PostConstruct
    public void init() {
        LOG.info("Iniciando pantalla ");
    }
    
    public void guardarPersona(){
        LOG.info("--------------------------- action");
        if(persona!=null)
        LOG.info(persona.getName()+"/"+persona.getEmail()+"/"+persona.getAge());
    }

    public PersonDemo getPersona() {
        return persona;
    }

    public void setPersona(PersonDemo persona) {
        this.persona = persona;
    }
    
}
