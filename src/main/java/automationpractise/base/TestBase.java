package automationpractise.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream fl = new FileInputStream("C:\\Users\\Swami\\eclipse-workspace\\AutomationPractise\\src\\main\\java\\automationpractise\\configs\\config.properties");
		
		prop.load(fl);		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	
	public void initialize()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Swami\\Desktop\\SeleniumDivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		  
	    String url = prop.getProperty("url");
		
	    driver.get(url);
	    driver.findElement(By.xpath("//a[@class='login']")).click();
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);    
	    
	}
	
	
}
	

