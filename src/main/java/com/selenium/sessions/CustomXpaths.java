package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpaths {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

//driver.get("https://classic.freecrm.com/");
//driver.findElement(By.name("username")).sendKeys("batchautomation");
//driver.findElement(By.name("password")).sendKeys("password123");
//driver.findElement(By.cssSelector("input.btn.btn-small")).click();

driver.get("https://www.crmpro.com/");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElement(By.name("username")).sendKeys("batchautomation");
driver.findElement(By.name("password")).sendKeys("password123");
driver.findElement(By.xpath("//*[@id=\'loginForm\']/div/div/input")).click();

//traversing back when creating an expaart
		
		//  //input[@name = 'username']/../../../..
		
		//move to immediate parent of the input tag(child to parent)
		// //input[@name = 'username']/parent::div
		
		//move to immediate child of the input tag(parent to child)
		// //div[@class='input-group']/child::input
		// move to the first input
		// (//div[@class='input-group']/child::input)[1] or (//div[@class='input-group']/child::input[position() = 1]
		
		//move to grand parent of a particular tag
		
		// //input[@name = 'username']//ancestor::div
		
		
		//moving to a checkbox using right side column cell(traverse left to access the checkbox)
		
		//a[@_name='Gladys Rim']//parent::td//preceding-sibling::td/input[@type ='checkbox']
 		
		
		
		

	}

}
