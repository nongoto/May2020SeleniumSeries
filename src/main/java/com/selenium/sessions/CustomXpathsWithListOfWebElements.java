package com.selenium.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathsWithListOfWebElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get(
				"https://www.espncricinfo.com/series/14222/scorecard/299006/pakistan-vs-south-africa-1st-odi-south-africa-tour-of-pakistan-2007-08");

		System.out.println(batsmenScoreCard("HH Gibbs"));

	}

	public static List<String> batsmenScoreCard(String name) {
		List<String> batsmenStats = new ArrayList<String>();
		List<WebElement> scoreCard = driver.findElements(By.xpath("//a[text() ='" + name + "']//ancestor::tr/td"));

		for (int i = 0; i < scoreCard.size(); i++) {
			String text = scoreCard.get(i).getText();
			batsmenStats.add(text);
		}
		return batsmenStats;
	}

}
