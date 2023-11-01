package com.agastya.utilites;

//Save any file related utility
//code to write properties file that is Locator.properties
//The value get from getproperty method which return the value means locator Type and Locator value

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	
	public String getProperty(String filepath, String key) {
		String baseDir = System.getProperty("user.dir");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(baseDir+filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties pro = new Properties();
		
		String value ="";
		try {
			pro.load(fis);
			value = pro.getProperty(key);
		} catch (IOException e) { 
			
			e.printStackTrace();
		}
			return value;

	}

	public String getLocator(String locatorName) throws FileNotFoundException {
		
		String baseDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(baseDir+"/src/maim/resources/Locators.properties");
		
		Properties pro = new Properties();
		
		String value ="";
		try {
			pro.load(fis);
			value = pro.getProperty(locatorName);
		} catch (IOException e) { 
			
			e.printStackTrace();
		}
			return value;
	
	}
	
}
