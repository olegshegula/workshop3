package com.workshop.pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	public WebDriver driver;
	public Set<Cookie> n = new HashSet<Cookie>();

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public String getElementText(WebElement el) {
		return el.getText();
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getURL() {

		return driver.getCurrentUrl();
	}

	public boolean isOnTheHomePage(WebElement el){
		return el.isDisplayed();
		
	}	
	
	public boolean isOnTheLoginPage(WebElement el){
		return el.isDisplayed();
		
	}	
		
	
	public Set<Cookie> getAllCookies() {

		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
			System.out.println(String.format("%s -> %s",
					loadedCookie.getName(), loadedCookie));
		}
		n=allCookies;
		return allCookies;

	}
	
	
	public void setAllCookies() {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		for(Cookie cookie : n){
			Cookie cookie1 = new Cookie.Builder(cookie.getName(), cookie.getValue()).build();
			driver.manage().addCookie(cookie1);
			
			System.out.println(String.format("%s -> %s",
					cookie1.getName(), cookie1));
		}
		
	}
	
	public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
	
	 public void checkThatCookiesDeleted() {
	        Set<Cookie> allCookies = driver.manage().getCookies();
	        if (!allCookies.isEmpty() ){
	            throw new AssertionError(true);
	        }
	    }

	public boolean isElementDisplayed(WebElement element) {
		boolean result = false;
		try {
			if (element.isDisplayed()) {
				result = true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return result;
	}
	
	 public void reloadPage() {
	        Navigation navi = driver.navigate();
	        navi.refresh();
	    }

	public void waitForElementVisibility(WebElement el) {
		boolean visible = false;
		while (!visible) {
			try {
				(new WebDriverWait(driver, 10)).until(ExpectedConditions
						.visibilityOf(el));
				visible = true;
			} catch (TimeoutException e) {
				throw new NoSuchElementException("The '" + el.toString()
						+ "'  element not found on the page.");
			}
		}

	}

	public void waitForElement() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void waitForElementInsivibility(WebElement el) {

		WebDriverWait waiting = new WebDriverWait(driver, 30, 1000);
		waiting.until(ExpectedConditions.stalenessOf(el));
	}

}
