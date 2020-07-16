package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.joran.action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		By loginbtn = By.cssSelector("input.signinbtn");
		
		TestUtil testUtil = new TestUtil(driver);
		System.out.println(testUtil.doWaitForPageCurrentUrl(10, "login"));
		testUtil.clickElementWhenReady(loginbtn, 10);
		Alert alert = testUtil.doWaitForAlertPresent(10);
		System.out.println(alert.getText());
		alert.accept();
		
		

		//driver.findElement(By.cssSelector("input.signinbtn")).click();

//WebDriverWait wait = new WebDriverWait(driver, 10);
//wait.until(ExpectedConditions.alertIsPresent());

//driver.switchTo().alert().accept();

//	Alert alert = doWaitForAlertPresent(driver, 10);
//	System.out.println(alert.getText());
//	alert.accept();
//	
		// driver.quit();

	}
	
//	public static Alert doWaitForAlertPresent(WebDriver driver, int timeout) {
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		return wait.until(ExpectedConditions.alertIsPresent());
	
}

