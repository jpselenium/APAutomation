package automationpractise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automationpractise.base.TestBase;
import automationpractise.util.Xls_reader;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//span[@class='shop-phone']//i[@class='icon-phone']")
	WebElement PhoneIcon;
	
	@FindBy(id="contact-link")
	WebElement ContactLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public String validateUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean ValidatePhoneIcon() {
		return PhoneIcon.isDisplayed();
	}
	
	
	public void ClickOnContactLink() {
		ContactLink.click();
	}
	
}
