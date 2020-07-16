package com.brokenlinks;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {


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
//		driver.findElement(By.id("username")).sendKeys("nongoto-cc94@force.com");
//		driver.findElement(By.id("password")).sendKeys("password123");
//		driver.findElement(By.id("Login")).click();
	}
	
	@Test
	public void countBrokenLinks() {
		//1. get all links and images
List<WebElement> linkList = driver.findElements(By.tagName("a"));
linkList.addAll(driver.findElements(By.tagName("img")));

System.out.println("Number of all links is: " +linkList.size());

//2. get all active links in an array list
List<WebElement> activelinks = new ArrayList<WebElement>();

//3. iterate linkList to locate all active links(links that don't have href attribute)
for( int i=0; i<linkList.size(); i++) {
	if(linkList.get(i).getAttribute("href") != null){
		activelinks.add(linkList.get(i));
	}
}

//4. get the number of all active links
int numOfCompleteActiveLinks = activelinks.size();
System.out.println("Number of all complete active links is: " + numOfCompleteActiveLinks);
System.out.println(activelinks);
		
	}
	
//	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
