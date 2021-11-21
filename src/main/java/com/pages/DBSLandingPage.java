package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DBSLandingPage {
	private WebDriver driver;

	// Objects
	private By dbsLogo = By.cssSelector(".img-logo.bg-none>img");
	private By login = By.linkText("Login");
	private By digiLoginOption = By.linkText("digibank by DBS");
	// Constructor
	public DBSLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions
	public List<WebElement> getDBSLogoList() {
		return driver.findElements(dbsLogo);
	}
	
	public void clickLogin() {
		driver.findElement(login).click();		
	}
	
	public boolean checkDigiLoginOptionExist() {				
		List<WebElement> digiLoginOptions= driver.findElements(digiLoginOption);
		if(digiLoginOptions.size()==1)
			return true;
		
		return false;
	}
}
