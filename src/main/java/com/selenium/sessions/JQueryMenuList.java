package com.selenium.sessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryMenuList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/");
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//div[@id = 'navbar-collapse']//li]")).click();
		By allChoices = By.xpath("//div[@id = 'navbar-collapse']//li");

		SelectChoiceValues(allChoices, "Sign Up");
		//SelectChoiceValues(allChoices, "choice 6", "choice 6 2", "choice 6 2 3", "choice 7");
		//SelectChoiceValues(allChoices, "all");

		Thread.sleep(3000);
//driver.close();
	}

	public static void SelectChoiceValues(By locator, String... value) {

		List<WebElement> choiceList = driver.findElements(locator);
		if (!value[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();

				for (int k = 0; k < value.length; k++) {
					if (text.equals(value[k])) {
						choiceList.get(i).click();
						break;
					}
				}

			}
		}
		// select all values
		else {
			try {
				for (int all = 0; all < choiceList.size(); all++) {
					choiceList.get(all).click();
				}
			} catch (Exception e) {
			}
		}
	}

}
