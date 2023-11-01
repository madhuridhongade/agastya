package com.agastya.config;

import java.io.FileInputStream;

import com.agastya.utilites.FileUtil;

public class Configuration {

	public String getAppUrl(String env) {
		
		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "app."+env+".url");
	}
	
}
