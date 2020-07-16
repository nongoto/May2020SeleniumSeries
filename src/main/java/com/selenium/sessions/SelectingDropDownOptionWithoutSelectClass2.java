package com.selenium.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectingDropDownOptionWithoutSelectClass2 {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By noOfEmployeeOption = By.xpath("//select[@id=\'Form_submitForm_NoOfEmployees\']/option");
		By industryOption = By.xpath("//select[@id=\'Form_submitForm_Industry\']/option");
		By countryOption = By.xpath("//select[@id=\'Form_submitForm_Country\']/option");
		
		SelectValuesFromDropDown(driver, noOfEmployeeOption, "451 - 500");
		SelectValuesFromDropDown(driver, industryOption, "Healthcare");
		SelectValuesFromDropDown(driver, countryOption, "Argentina");

	}

	public static void SelectValuesFromDropDown(WebDriver driver, By locator, String value) {
		List<WebElement> industryList = driver.findElements(locator);
		for (int i = 0; i < industryList.size(); i++) {
			String text = industryList.get(i).getText();
			if (text.equals(value)) {
				industryList.get(i).click();
				break;
			}
		}

	}

//	public static WebElement getElement(By locator) {
//
//		WebElement element = null;
//		try {
//			element = driver.findElement(locator);
//		} catch (Exception e) {
//			System.out.println("element could not be created: " + locator);
//		}
//		return element;
}
