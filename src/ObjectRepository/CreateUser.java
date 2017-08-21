package ObjectRepository;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.commonMethods;

public class CreateUser {
	
	WebDriver driver;
	//This is constructor required to initialize driver
	public CreateUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page factory model
	@FindBy(xpath=".//*[@id='edit-location']")
	WebElement enterLocation;

	
	
	
	//Enter location defined in data source
	public WebElement EnterLocation()
	{
		return enterLocation;
	}

}
