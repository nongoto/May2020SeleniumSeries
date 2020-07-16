package com.selenium.sessions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchOptionSelection {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement searchText = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
		searchText.click();
		searchText.sendKeys("selenium");
		Thread.sleep(2000);
		
		
		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@class='erkvQe']/li//span"));
		for(int i= 0; i<suggestionList.size(); i++) {
			if(suggestionList.get(i).getText().equalsIgnoreCase("selenium webdriver")) {
				suggestionList.get(i).click();
				break;
			}
		}	
		
	}
	public static void GoogleSearchOneOption(By locator, String value) {
		
	}

}
