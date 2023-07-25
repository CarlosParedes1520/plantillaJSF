/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.contfiables.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

/**
 *
 * @author tatia
 */
public class Propiedades  implements Serializable {
    
    	private transient final Logger LOG = Logger.getLogger(Propiedades.class.getName());
        
   	private transient static final long serialVersionUID = 1L;

	private transient Properties properties;
        
        private static final String ERROR_GET_PROPERTIES = "ERROR AL RECUPERAR PROPERTIES GENERAL";

        private static final String ERROR_CLOSE_PROPERTIES = "ERROR AL CERRAR PROPERTIES GENERAL";
        
	@PostConstruct
	public void init() {
		properties = new Properties();
	}

	public String getPropiedadServer(String data) throws IOException {

		properties = getGenericProperties("parametros", properties);

		
		return properties.getProperty(data);
	} 
    
    	public Properties getGenericProperties(String fileName,Properties prop) {
		InputStream inputProp = null;
		try {
			
			
			if(fileName == null) {
				LOG.info(ERROR_GET_PROPERTIES);
				return null;
			}
			
			String fileNameExt = fileName.trim() + ".properties";
			inputProp = Propiedades.class.getClassLoader().getResourceAsStream(fileNameExt);
			
			if(inputProp == null) {
				LOG.info(ERROR_GET_PROPERTIES);
				return null;
			}
			
			if(prop == null)
				prop = new Properties();
			
			prop.load(inputProp);
			return prop;
			
		} catch (IOException e) {
			LOG.log(Level.SEVERE,ERROR_GET_PROPERTIES, e);
			return null;
		}catch (Exception e) {
			LOG.log(Level.SEVERE,ERROR_GET_PROPERTIES, e);
			return null;
		} finally {
			closeInputStream(inputProp);
		}
	}
    
    	private void closeInputStream(InputStream inputStream) {
		try {
			if(inputStream != null)
				inputStream.close();
		} catch (IOException e) {
			LOG.log(Level.SEVERE,ERROR_CLOSE_PROPERTIES, e);
		}catch (Exception e) {
			LOG.log(Level.SEVERE,ERROR_CLOSE_PROPERTIES, e);
		}
	}
}
