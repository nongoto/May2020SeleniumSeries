package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathCriketScoreCard {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(
				"https://www.espncricinfo.com/series/14222/scorecard/299006/pakistan-vs-south-africa-1st-odi-south-africa-tour-of-pakistan-2007-08");
//
//		String text = driver.getTitle();
//
//		System.out.println(text);
		
		String text = driver.findElement(By.xpath("//a[text() ='GC Smith']/..//ancestor::td//following-sibling::td/span/span")).getText();
		
		System.out.println(text);

	}

}
