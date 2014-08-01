package com.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import utils.Browser;
import utils.PropertyLoader;
import utils.WebDriverFactory;

public class BaseTest extends BasePage{
protected WebDriver driver;

@BeforeTest
public void setUp(){	
	
	Browser browser = new Browser();	
	browser.setName(PropertyLoader.loadProperty("selenium.browser"));
	driver = WebDriverFactory.getInstance(browser);
	driver.get(PropertyLoader.loadProperty("selenium.baseUrl"));	
   	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	initPages(driver);
}

@AfterSuite
public void tearDown(){	
	driver.close();
	driver.quit();
}

}
