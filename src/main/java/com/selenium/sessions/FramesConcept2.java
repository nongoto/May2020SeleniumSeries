package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept2 {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();
driver.manage().window().maximize();


driver.get("https://www.crmpro.com/");

By username = By.name("username");
By password = By.name("password");
By loginbtn = By.cssSelector("input.btn.btn-small");


driver.findElement(username).sendKeys("nongoto");
driver.findElement(password).sendKeys("CRMROOnyiego123");
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
//driver.findElement(loginbtn).click();




//driver.switchTo().frame("mainpanel");
//driver.findElement(By.linkText("Contacts")).click();	
//driver.switchTo().defaultContent();

////Switch from by index
//driver.switchTo().frame(driver.findElement(By.cssSelector("#content > iframe")));
//boolean displayed = driver.findElement(By.id("draggable")).isDisplayed();
//System.out.println(displayed);
//driver.switchTo().defaultContent();
//driver.findElement(By.linkText("Support")).click();



	}
	
//	public WebElement doWaitForElementToBeClickable(WebDriver, driver, By locator, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		return wait.until(ExpectedConditions.elementToBeClickable(locator));
//	}

	
}



