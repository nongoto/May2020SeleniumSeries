package com.selenium.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSSSelector2 {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		By locator = By.cssSelector("ul.footer-nav>li>a");

		driver.get("https://www.freshworks.com/");

		System.out.println(footerLinks(driver, locator));

	}

	public static List<String> footerLinks(WebDriver driver, By locator) {

		List<String> footerLinkList = new ArrayList<String>();
		List<WebElement> footerLinks = driver.findElements(locator);

		for (int i = 0; i < footerLinks.size(); i++) {

			String text = footerLinks.get(i).getText();
			footerLinkList.add(text);
		}
		return footerLinkList;
	}

}
