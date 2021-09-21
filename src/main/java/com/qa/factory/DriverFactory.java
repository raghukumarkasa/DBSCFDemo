package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//This function initializes the driver with browser type, delete cookies, maximizes it
	public void init_driver(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());			
		}
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());			
		}
		if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver());			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();		
	}
	
	//This method is to get the thread instance of the driver
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();		
	}
}
