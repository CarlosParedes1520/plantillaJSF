package ec.tws2.tcs.contfiables.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PropertiesUtil {
	
	private Properties properties;
	private Logger log = Logger.getLogger(Properties.class.getName());
	
	@PostConstruct
	public void init() {
		properties = new Properties();
	}
	
	public String getPropiedad(String propertie, String data) {
		InputStream archivo = null;
		try {
			archivo = Properties.class.getClassLoader().getResourceAsStream(propertie);
			properties.load(archivo);
		} catch (Exception e) {
			log.log(Level.SEVERE, "ERROR AL OBTENER LOS PROPERTIES ", e);
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties.getProperty(data);
	}
}
