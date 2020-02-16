package automationpractise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automationpractise.base.TestBase;
import automationpractise.util.Xls_reader;

public class ContactPage extends TestBase{

	@FindBy(id="id_contact")
	WebElement contactId;	
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="message")
	WebElement message;
	
	
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createMessage(String title, String emailAddress, String messageDetail) {
		
		Select select = new Select(contactId);
		select.selectByVisibleText(title);
		
		email.clear();
		email.sendKeys(emailAddress);
		message.sendKeys(messageDetail);
		
		
	}
	
	
	
	public void createMessage() {
		Xls_reader reader = new Xls_reader("C:\\Users\\Swami\\eclipse-workspace\\AutomationPractise\\src\\main\\java\\automationpractise\\testdata\\CreatMessage.xlsx");
		
		String sheetName = "message";
		
		 int rowCount = reader.getRowCount(sheetName);
		
		for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
			String title = reader.getCellData(sheetName, "title", rowNum);
			
			String email = reader.getCellData(sheetName, "email", rowNum);

			String message = reader.getCellData(sheetName, "message", rowNum);
			
			
			Select select = new Select(driver.findElement(By.id("id_contact")));
			select.selectByVisibleText(title);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("message")).sendKeys(message);
			driver.findElement(By.name("submitMessage")).click();
		}
		
		
	}
		// Xls_reader reader = new Xls_reader("C:\Users\Swami\eclipse-workspace\AutoPractices\src\main\java\ap\testdata\CreatMessage.xlsx");
		// String sheetName = "message";
		
		// int rowCount = reader.getRowCount(sheetName);
		
	
	
}
