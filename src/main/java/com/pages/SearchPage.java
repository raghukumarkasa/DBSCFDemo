package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	private WebDriver driver;

	// Objects
	private By searchBox = By.name("q");

	//Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions
	public String getSearchPageTitle() {
		return driver.getTitle();
	}

	public SearchResultPage searchText(String searchText) {
		driver.findElement(searchBox).sendKeys(searchText);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
		return new SearchResultPage(driver);
	}

}
