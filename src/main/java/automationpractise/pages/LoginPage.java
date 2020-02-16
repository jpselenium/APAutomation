package automationpractise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationpractise.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory
	@FindBy(id= "email")
	WebElement username;
	
	@FindBy(id= "passwd")
	WebElement password;	
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();		
	}
	
}
