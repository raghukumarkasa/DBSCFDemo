package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	private WebDriver driver;
	
	//Objects
	private By firstSearchResult = By.cssSelector("div#rso a");
	
	//Constructor
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Actions
	public JPMLandingPage clickOnFirstSearchResult() {
		driver.findElement(firstSearchResult).click();		
		return new JPMLandingPage(driver);
	}	
	
}
