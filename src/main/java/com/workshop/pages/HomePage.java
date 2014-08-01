package com.workshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

	public HomePage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(id ="userNavigationLabel")
	WebElement userNav;
	@FindBy(css = ".uiLinkButtonInput")
	WebElement exit;
	@FindBy (css =".fbxWelcomeBoxName")
	public WebElement atr;
	
	public void logout() {
		
		userNav.click();
		exit.click();
	}

}
