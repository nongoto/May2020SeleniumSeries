/**
 * 
 */
package com.brokenlinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Nick
 *
 */
public class CountLinksOnPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://na134.lightning.force.com/lightning/page/home");
		driver.findElement(By.id("username")).sendKeys("nongoto-cc94@force.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();

	}

}
