package com.brokenlinks;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		

	}
	
	public void countBrokenLinks() {
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
				System.out.println("There are 9 broken links");
			}

}
