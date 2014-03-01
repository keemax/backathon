package com.maxkeener.backathon.constant;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 3/1/14
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesGetter {
    private Properties properties;
    private static PropertiesGetter instance = null;

    public PropertiesGetter() {
        properties = new Properties();
        try {
            properties.load(PropertiesGetter.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch(Exception e) {
            System.err.println("Error loading properties file");
            e.printStackTrace();
        }
    }

    public static PropertiesGetter getInstance() {
        if (instance == null) {
            return new PropertiesGetter();
        }
        return instance;
    }

    public String get(String prop) {
        return properties.getProperty(prop);
    }
}
