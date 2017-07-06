package com.clearscore.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Consumer;

public class SystemProperties {
	private static String SYSTEM_PROPERTIES_FILE = "src/test/resources/properties/System.properties";
	public static final String LOGIN_ENDPOINT = getStringProperty("login.endpoint");
	public static final String LOGIN_WEBSITE = getStringProperty("clearscore.login");
	public static final String CALCULATOR_WEBSITE = getStringProperty("clearscore.calculator");

	private static Properties systemProperties;

	private static Properties getProperties() {
		if (systemProperties == null) {
			loadProperties();
		}
		return systemProperties;
	}

	private static void loadProperties() {

		if (System.getProperty("system.properties.file") != null) {
			try {
				SYSTEM_PROPERTIES_FILE = System.getProperty("system.properties.file");
			} catch (Exception e) {
				System.out.println("EXTERNAL PROPERTIES FILE NOT LOADED!!");
			}
		}
		systemProperties = new Properties();
		final Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(SYSTEM_PROPERTIES_FILE);

			prop.load(input);
		} catch (IOException e) {
		}

		prop.keySet().forEach(new Consumer<Object>() {
			public void accept(Object key) {
				systemProperties.put(key, prop.getProperty(key.toString(), key.toString()));
			}
		});
	}

	public static String getStringProperty(String key) {
		return getProperties().getProperty(key);
	}

}
