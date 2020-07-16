/**
 * 
 */
package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Nick
 *
 */
public class TestNGBasics {

	//preconditions starting with @Before
	@BeforeSuite
	public void setUp() {
		System.out.println("SetUp system property for chrome");

	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("launch chrome browser");

	}

	@BeforeMethod
	public void enterURL() {
		System.out.println("enter URL");
	}

	@BeforeTest
	public void login() {
		System.out.println("login to app");
	}

	//test cases starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("Google Title Test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("search Test");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("Google logo Test");
	}

	//post conditions starting with @After
	@AfterMethod
	public void logOut() {
		System.out.println("logout from app");

	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("delete all cookies");

	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}

	@AfterSuite
	public void generateTestResults() {
		System.out.println("generate test results");
	}

}
