package automationpractise.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationpractise.base.TestBase;
import automationpractise.pages.ContactPage;
import automationpractise.pages.HomePage;
import automationpractise.pages.LoginPage;
import automationpractise.util.TestUtil;



public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	
	public HomePageTest() {
		super();
	}
	
	@DataProvider
	public  Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.GetDataFromExcel();
		return testData.iterator();
	} 
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}	
	
	/*	
	@Test
	public void validatePhoneIcon() {
		boolean flag = homePage.ValidatePhoneIcon();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateTitle() {
		String title = homePage.validateTitle();
		Assert.assertEquals(title, "My account - My Store");
	} 
	
	
	@Test
	public void sendMessage() {
		homePage.ClickOnContactLink();
		
		contactPage = new ContactPage();
		
		//contactPage.createMessage("Customer service", "trainerjp4u@gmail.com", "cancel order");
		
		contactPage.createMessage();
	} */
	

	@Test(dataProvider="getTestData")

	public void createMessage(String title, String email, String message) {
		homePage.ClickOnContactLink();

		Select select = new Select(driver.findElement(By.id("id_contact")));
		select.selectByVisibleText(title);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("message")).sendKeys(message);		
	}
	
	
	/*
	
	@AfterMethod	
	public void close() {
		driver.quit();		
	}  
	
	*/
	
	/*
	@DataProvider
	public  Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.GetDataFromExcel();
		return testData.iterator();
	}  */
}
