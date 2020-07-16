package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSportLoginPageWaitConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://www.hubspot.com/login");

		//driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("nongoto@gmail.com");
		//driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Hubsportpassword123");
		driver.findElement(By.id("loginBtn")).click();
		
		String title = doGetPageTitle(driver, 10, "HubSpot");
		System.out.println(title);
		
		driver.findElement(By.xpath("//span[text()='7975611']//parent::td//preceding-sibling::td/div/div/span/span/span/a/span/span/span")).click();
		

	}
	
	public static String doGetPageTitle(WebDriver driver, int timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		
	}

}
