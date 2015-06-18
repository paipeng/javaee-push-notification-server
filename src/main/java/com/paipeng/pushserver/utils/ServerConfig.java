package com.paipeng.pushserver.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

public class ServerConfig {
	private String gcmApiKey;
	
	public ServerConfig() {
		try {
			readProperties();
		} catch (IOException e) {
			//log.log(Level.SEVERE, "exception " + e.getMessage());
		} catch (NullPointerException e) {
			//log.log(Level.SEVERE, "exception " + e.getMessage());			
		}
	}
	
	private void readProperties() throws IOException, NullPointerException {
		InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("/server-config.properties");
		
        Properties properties = new Properties();
         
        //log.info("InputStream is: " + inputStream);
        
        //load the inputStream using the Properties
        properties.load(inputStream);
        //get the value of the property
        this.gcmApiKey = properties.getProperty("gcm_apikey");
        
        //System.out.println("Property value is: " + this.gcmApiKey);
	}
	
	public String getGcmApiKey() {
		return this.gcmApiKey;
	}
}
