package com.workshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseTest;

public class FacebookTest extends BaseTest {

	// login into Facebook print and delete cookies
	@Test
	public void loginAndSaveCookiesTest() {
		loginPage.login();
		Assert.assertEquals(homePage.getPageTitle(), "Facebook");

		homePage.getAllCookies();
		homePage.deleteAllCookies();
		homePage.checkThatCookiesDeleted();
		homePage.reloadPage();
		Assert.assertTrue(loginPage.isOnTheHomePage(loginPage.mailField));

	}

	// login into Facebook with saved cookies
	@Test
	public void loginWithSavedCookies() {
		loginPage.login();
		homePage.getAllCookies();
		homePage.logout();

		loginPage.n = homePage.n;

		loginPage.setAllCookies();

		homePage.reloadPage();
		// Assert.assertEquals(loginPage.getPageTitle(),"Facebook");

	}

}
