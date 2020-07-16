package com.selenium.sessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	static WebDriver driver;
	static By context = By.xpath("//span[text()= 'right click me']");
	static By rightClickMenu = By
			.xpath("//ul[@class='context-menu-list context-menu-root']" + "/li[contains(@class,'context-menu-icon')]");

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		ContextRightClickConcept(context, rightClickMenu, "copy");

		Thread.sleep(3000);

		driver.quit();

	}

	public static void ContextRightClickConcept(By contextLocator, By rightClickMenuLocator, String value) {

		WebElement rightClickMe = driver.findElement(context);

		Actions ac = new Actions(driver);
		ac.contextClick(rightClickMe).perform();

		// cssSelector: ul.context-menu-list.context-menu-root li.context-menu-icon
		List<WebElement> rightClickOptions = driver.findElements(rightClickMenu);

		for (int i = 0; i < rightClickOptions.size(); i++) {
			String text = rightClickOptions.get(i).getText();
			if (text.equalsIgnoreCase(value)) {
				rightClickOptions.get(i).click();
				break;
			}
		}

	}

}
