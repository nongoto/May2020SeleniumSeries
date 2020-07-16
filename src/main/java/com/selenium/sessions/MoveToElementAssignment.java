package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");

		WebElement menuLink = driver.findElement(By.cssSelector("a#ctl00_HyperLinkLogin"));

		Actions ac = new Actions(driver);
		ac.moveToElement(menuLink).perform();
		ac.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).perform();
		driver.findElement(By.linkText("Member Login")).click();

		Thread.sleep(3000);

		//driver.quit();
	}

}
