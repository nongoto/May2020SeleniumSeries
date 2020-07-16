package com.selenium.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OHRMSignUp {

	public static void main(String[] args) {

		String browser = "chrome";
		WebDriverUtil wu = new WebDriverUtil();

		WebDriver driver = wu.launchBrowser(browser);
		wu.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(wu.getPageTitle());

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
		// By imageSelector = By.id("1");
		By submitButton = By.id("Form_submitForm_action_request");

		TestUtil tu = new TestUtil(driver);
		tu.doSendKeys(userUrl, "orangehrm.com");
		tu.doSendKeys(userFirstName, "firstname");
		tu.doSendKeys(userLastName, "lastname");
		tu.doSendKeys(userNoOfEmployees, "199");
		tu.doSelectValueByvalue(countrySelector, "United States");

		wu.CloseBrowser();

	}

}
