package com.selenium.sessions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.crmpro.com/");

		By username = By.name("username");
		By password = By.name("password");
		By loginbtn = By.cssSelector("input.btn.btn-small");

		driver.findElement(username).sendKeys("nongoto");
		driver.findElement(password).sendKeys("CRMROOnyiego123");
		waitForElementWithFluentWaitCondition(driver, loginbtn, 10).click();
	}

	public static WebElement waitForElementWithFluentWaitCondition(WebDriver driver, final By locator, int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

//	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator, int timeOut) {
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(timeOut))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class);
//
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(locator);
//			}
//
//		});
//		return element;

}
