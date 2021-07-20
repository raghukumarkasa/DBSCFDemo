package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
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
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();		
	}
}
