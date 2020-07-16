package com.selenium.sessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinkList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.freshworks.com/");

		By locator = By.cssSelector("ul.footer-nav >li >a");
		TestUtil testUtil = new TestUtil(driver);
		
		List<WebElement> footerLinkList = testUtil.doWaitForVisibilityOfAllElements(locator, 10);
		System.out.println(footerLinkList.size());
		
		for(WebElement ele: footerLinkList) {
			System.out.println(ele.getText());
		}
		
		
		

	}

}
