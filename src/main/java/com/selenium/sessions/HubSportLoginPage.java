package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSportLoginPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://www.hubspot.com/login");

		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("nongoto@gmail.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Hubsportpassword123");
		driver.findElement(By.id("loginBtn")).click();
System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().to("https://app.hubspot.com/contacts/7975611/contacts/list/view/all/");

		// //span[text()='test1
		// testing']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/..
		Thread.sleep(3000);
		
		selectCheckboxUsingPrecedtagingByXpath(driver, "test1 testing");
		selectCheckboxUsingPrecedtagingByXpath(driver, "test2 testing");
		getTestUsingFollowingTagByXpath(driver, "test2 testing" );
		// Thread.sleep(3000);

		// wf.CloseBrowser();

	}

	public static void selectCheckboxUsingPrecedtagingByXpath(WebDriver driver, String value) {
		driver.findElement(By.xpath("//span[text()='"+value+"']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/..")).click();
	}
	
	public static void getTestUsingFollowingTagByXpath(WebDriver driver, String value) {
		String text = driver.findElement(By.xpath("//span[text()='"+value+"']//ancestor::td//following-sibling::td//following-sibling::td/span")).getText();
		System.out.println(text);
	}
	

}
