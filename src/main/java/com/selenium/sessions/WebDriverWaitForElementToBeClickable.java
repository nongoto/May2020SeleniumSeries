package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForElementToBeClickable {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.hubspot.com/login");
		By username = By.id("username");
		By password = By.id("password");
		By loginbtn = By.id("loginBtn");

		doWaitForElementPresent(driver, 10, username).sendKeys("nongoto@gmail.com");

		driver.findElement(password).sendKeys("Hubsportpassword123");

		doWaitForElementPresent(driver, 10, loginbtn).click();

	}

	public static WebElement doWaitForElementPresent(WebDriver driver, int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

}
