package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ch.qos.logback.core.joran.action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.get("https://app.hubspot.com/login");
		
		Thread.sleep(3000);
				
		By email = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");
		
//		Actions ac = new Actions(driver);
//		
//		ac.sendKeys(getElement(email), "tom@gmail.com").perform();
//		ac.sendKeys(getElement(password), "tom@123").perform();
//		ac.click(getElement(loginButton)).perform();
		
		doActionsSendKeys(email, "tom@gmail.com");
		doActionsSendKeys(password, "tome@123");
		doActionsClick(loginButton);
		
		
		Thread.sleep(3000);
		//driver.quit();
		
	}

	public static WebElement getElement(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created: " + locator);
		}
		return element;
	}
	
	public static void doActionsClick(By locator) {
		Actions ac = new Actions(driver);
		ac.click(getElement(locator)).perform();
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions ac = new Actions(driver);
		ac.sendKeys(getElement(locator), value).perform();
	}
}
