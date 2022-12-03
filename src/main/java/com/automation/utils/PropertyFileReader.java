package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	Properties prop;
	FileInputStream fis;

	public PropertyFileReader() {
		prop = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file not found at location =" + filePath);
			System.exit(0);
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load config file at location =" + filePath);
			System.exit(0);
		}
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getBrowserVersion() {
		return prop.getProperty("browser_version");
	}

	public String getURL() {
		return prop.getProperty("url");
	}
}
