package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPMLandingPage {
	private WebDriver driver;
	
	//Objects 
	private By jpmLogo = By.cssSelector(".logo-desktop-only a");
	
	//Constructor
	public JPMLandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Actions
	public List<WebElement> getJPMLogoList(){
		return driver.findElements(jpmLogo);
	}
}
