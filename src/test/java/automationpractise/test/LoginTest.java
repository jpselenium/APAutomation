package automationpractise.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationpractise.base.TestBase;
import automationpractise.pages.HomePage;
import automationpractise.pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}	
	
	//@Test
	
	
	
	/*
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	*/
}
