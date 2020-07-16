package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {

public WebDriver driver;
	
	/**
	 * This method is used to launch the browser in the basis of the given browser name
	 * @param browser
	 * @return driver
	 */
	public WebDriver launchBrowser(String browser) {
		
		System.out.println("browser value is :" + browser);
		
		if(browser.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
		else if(browser.equalsIgnoreCase("firefox"))
		{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari"))
		{
	WebDriverManager.getInstance(SafariDriver.class).setup();
	driver = new SafariDriver();
		}
		
		else {
			System.out.println("Please pass the correct browser" + browser);
		}
		return driver;
	}

	
/**
 * This is used to get the page url
 * @param url
 * @return url
 */
public void launchUrl(String url) {
	driver.get(url);
}

/*
 * This is used to get the page title
 * @return title
 */
public String getPageTitle() {
	return driver.getTitle();
}

/*
 * This is used to get the page current url
 * @return current page url
 */
public String getPageCurrentUrl() {
	return driver.getCurrentUrl();
}

public void CloseBrowser() {
	driver.close();
}

}
