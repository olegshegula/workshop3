package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String INTERNET_EXPLORER = "ie";
	public static final String HTML_UNIT = "htmlunit";
	private static WebDriver webDriver = null;

	public static WebDriver getInstance(Browser browser) {

		if (webDriver != null) {
			return webDriver;
		}

		if (CHROME.equals(browser.getName())) {
			webDriver = new ChromeDriver();

		} else if (FIREFOX.equals(browser.getName())) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.startup.homepage", "http://www.facebook.com");

			webDriver = new FirefoxDriver(profile);

		} else if (INTERNET_EXPLORER.equals(browser.getName())) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			webDriver = new InternetExplorerDriver(caps);

		} else if (HTML_UNIT.equals(browser.getName())) {
			webDriver = new HtmlUnitDriver();

		}

		return webDriver;
	}

}
