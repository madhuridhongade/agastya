package com.agastya.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.agastya.config.Configuration;

public class TestBase {
	
	public Configuration config;
	public static RemoteWebDriver driver;
	
	public RemoteWebDriver getDriver() {
		return driver;
	}
	
	@Parameters("browser-name")
	@BeforeMethod
	public void setUp(@Optional String browserName) {
		
		config = new Configuration();
		
		if(browserName == null)
		{
			browserName="Chrome";
		}
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		}else {
			System.err.println("Invalid browser name: "+browserName);
		}
		
		driver.get(config.getAppUrl("beta"));

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
