package com.workshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PropertyLoader;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "#email")
	public WebElement mailField;
	@FindBy(css = "#pass")
	public WebElement passField;
	@FindBy(id = "loginbutton")
	public WebElement loginBtn;
	

	public void login() {
		mailField.clear();
		passField.clear();		
		
		mailField.sendKeys(PropertyLoader.loadProperty("user.username"));
		passField.sendKeys(PropertyLoader.loadProperty("user.password"));
		loginBtn.click();
		
		

	}

}
