package com.selenium.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.get("http://www.londonfreelance.org/courses/frames/");

//WebElement header = driver.findElement(By.tagName("h2"));
//WebElement header = driver.findElement(By.xpath("/html/body/h2"));

//WebElement header = driver.findElement(By.tagName("h2"));

//Switch from by index
driver.switchTo().frame(2);
WebElement header = driver.findElement(By.cssSelector("body > h2"));
System.out.println("Switch from by index......" + header.getText());
driver.switchTo().defaultContent();

//Switch to frame by name or id
driver.switchTo().frame("main");
header = driver.findElement(By.xpath("/html/body/h2"));
System.out.println("Switch to frame by name or id....." + header.getText());
driver.switchTo().defaultContent();


//Switch to frame by webelement
driver.switchTo().frame(driver.findElement(By.name("main")));
System.out.println("Switch to frame by webelement....." + header.getText());
driver.switchTo().defaultContent();


	}

}
