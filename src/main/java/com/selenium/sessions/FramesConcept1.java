package com.selenium.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept1 {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.get("https://jqueryui.com/draggable/");



//Switch from by index
driver.switchTo().frame(driver.findElement(By.cssSelector("#content > iframe")));
boolean displayed = driver.findElement(By.id("draggable")).isDisplayed();
System.out.println(displayed);
driver.switchTo().defaultContent();
driver.findElement(By.linkText("Support")).click();


	}

}
