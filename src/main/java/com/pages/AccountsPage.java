package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	//Accounts Page object locators
	private By accountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<WebElement> sectionElementList= driver.findElements(accountSections);
		List<String> sectionList=new ArrayList<String>();
		for(WebElement e:sectionElementList) {
			sectionList.add(e.getText());
		}
		return sectionList;
	}	
}
