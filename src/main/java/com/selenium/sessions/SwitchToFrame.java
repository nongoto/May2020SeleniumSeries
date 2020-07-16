package com.selenium.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrame {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//By framename = By.xpath("frame[@name='mainpanel']");

		driver.get("https://www.crmpro.com/index.html");
		
		By username = By.name("username");
		By password = By.name("password");
		By loginbtn = By.cssSelector("input.btn.btn-small");

		doWaitForElementPresent(driver, 10, username).sendKeys("batchautomation");
		//driver.findElement(username).sendKeys("batchautomation");
		driver.findElement(password).sendKeys("password123");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		doWaitForElementPresent(driver, 10, loginbtn).click();
		//driver.findElement(loginbtn).click();

	}
	public static WebElement doWaitForElementPresent(WebDriver driver, int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
