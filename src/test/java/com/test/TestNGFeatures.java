package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGFeatures {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	@Test
	public void loginPage() {
		System.out.println("Login Page");
	}

	@Test(dependsOnMethods = "loginPage" )
	public void HomePage() {
		System.out.println("Home Page");
	}
	
//	@Test
//	public void SearchPage() {
//		System.out.println("Search Page");
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
