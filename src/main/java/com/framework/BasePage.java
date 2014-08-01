package com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.workshop.pages.HomePage;
import com.workshop.pages.LoginPage;

public class BasePage {

	

	public LoginPage loginPage;
	public HomePage homePage;

	public void initPages(WebDriver driver) {

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
}
