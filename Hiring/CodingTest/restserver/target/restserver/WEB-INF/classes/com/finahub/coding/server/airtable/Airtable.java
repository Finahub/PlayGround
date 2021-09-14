package com.finahub.coding.server.airtable;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import org.apache.http.HttpHost;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Airtable {

    public Properties properties;
    private AirtableConfiguration config;

    public Airtable configure() throws Exception  {
    	loadProperty();
		return configure(new AirtableConfiguration(properties.getProperty("ENDPOINT_URL"), properties.getProperty("AIRTABLE_API_KEY"), properties.getProperty("AIRTABLE_PROXY")));
        
    }

    private  void loadProperty(){
		String workingDirectory = System.getProperty("user.dir");
		properties = new Properties();
			try {
				FileInputStream fileInputStream = new FileInputStream(workingDirectory + "/properties/airtable.properties");
				properties.load(fileInputStream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
    public Airtable configure(AirtableConfiguration config) throws Exception {
     
        if (config.getAIRTABLE_API_KEY() == null) {
            throw new Exception("Missing Airtable API-Key");
        }
        if (config.getENDPOINT_URL() == null) {
            throw new Exception("Missing endpointUrl");
        }

        this.config = config;

        configureProxy(config.getENDPOINT_URL());
        return this;
    }

    public void setProxy(String proxy) {

        this.config.setAIRTABLE_PROXY(proxy);;
        if (proxy == null) {
            Unirest.setProxy(null);
        } else {
            Unirest.setProxy(HttpHost.create(this.config.getAIRTABLE_PROXY()));
        }

    }

   
    private void configureProxy(String endpointUrl) {
        if (this.config.getAIRTABLE_PROXY() == null) {
            final String Proxy = properties.getProperty("PROXY");
            if (Proxy != null) {
                setProxy(Proxy);
            }else {
                setProxy(null);
            }
        } else if ((endpointUrl.contains("127.0.0.1")|| endpointUrl.contains("localhost"))) {
            setProxy(null);
        } else {
            setProxy(this.config.getAIRTABLE_PROXY());
        }
    }

    public AirtableBase base() {
        String val = properties.getProperty("AIRTABLE_BASE");
        return new AirtableBase(val, this);
    }



    public AirtableConfiguration getConfig() {
        return config;
    }

    public void setConfig(AirtableConfiguration config) {
        this.config = config;
        configureProxy(config.getENDPOINT_URL());
    }


    public String endpointUrl() {
        return config.getENDPOINT_URL();
    }
   
    public String apiKey() {
    	return config.getAIRTABLE_API_KEY();
    }



    public void setEndpointUrl(String endpointUrl) {
        this.config.setENDPOINT_URL(endpointUrl);
        configureProxy(endpointUrl);
    }
}