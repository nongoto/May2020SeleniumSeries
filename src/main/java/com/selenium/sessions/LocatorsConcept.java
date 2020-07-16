/**
 * 
 */
package com.selenium.sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Nick
 *
 */
public class LocatorsConcept {

	/**
	 * @param args
	 */
	
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	
	
	By userUrl = By.id("Form_submitForm_subdomain");
	By userFirstName = By.id("Form_submitForm_FirstName");
	By userLastName = By.id("Form_submitForm_LastName");
	By userEmail = By.id("Form_submitForm_Email");
	By userJobTitle = By.id("Form_submitForm_JobTitle");
	By userNoOfEmployees = By.id("Form_submitForm_NoOfEmployees");
	By userCompanyName = By.id("Form_submitForm_CompanyName");
	By industrySelector = By.id("Form_submitForm_Industry");
	By userContact = By.id("Form_submitForm_Contact");
	By countrySelector = By.id("Form_submitForm_Country");
	By dummyData = By.cssSelector("input#Form_submitForm_SetDummyData");
	//By imageSelector = By.id("1");
	By submitButton = By.id("Form_submitForm_action_request");
	
//	getElement(userFirstName).sendKeys("userUrl");
//	getElement(userUrl).sendKeys("userUrl");
	
	doSendKeys(userUrl, "nick.orangehrmlive.com");
	doSendKeys(userFirstName, "nick");
	doSendKeys(userLastName, "orangehrm");
	doSendKeys(userEmail, "norangehrm@orangehrmlive.com");
	doSendKeys(userJobTitle, "manager");
	doSelectValueByvalue(userNoOfEmployees, "701 - 800");
	doSendKeys(userCompanyName, "nick's orange");
	doSendKeys(userContact, "nick orange");
	doSelectValueByVisibleText(industrySelector, "Education" );
	doSelectValueByIndex(countrySelector, 126 );
	doClick(dummyData);
	doClick(submitButton);

	
}
	public static WebElement getElement(By locator) {
		WebElement element= driver.findElement(locator);
		return element;
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doSelectValueByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectValueByvalue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void doSelectValueByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
}




	

