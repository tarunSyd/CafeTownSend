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

public class HomePage {
	
	WebDriver driver;
	//This is constructor required to initialize driver
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page factory model
	@FindBy(xpath="html/body/div[1]/header/div/p[1]")
	WebElement logOut;
	@FindBy(xpath=".//*[@id='bAdd']")
	WebElement addNewUser; 

	
	
	
	//Enter location defined in data source
	public WebElement LogOut()
	{
		return logOut;
	}
	public WebElement AddNewUser()
	{
		return addNewUser;
	} 

}
