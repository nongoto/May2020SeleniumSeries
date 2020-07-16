package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ch.qos.logback.core.joran.action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggAndDropHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		Actions ac = new Actions(driver);
		
		//ac.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
		
		//ac.dragAndDrop(sourceElement, targetElement).build().perform();
		ac.dragAndDrop(sourceElement, targetElement).perform();
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
