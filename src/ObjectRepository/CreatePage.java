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

public class CreatePage {
	
	WebDriver driver;
	//This is constructor required to initialize driver
	public CreatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page factory model
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[1]/input")
	WebElement firstName;
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[2]/input")
	WebElement lastName;
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[3]/input")
	WebElement startDate;
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/label[4]/input")
	WebElement email; 
	@FindBy(xpath="html/body/div[1]/div/div/form/fieldset/div/button[2]")
	WebElement add; 

	
	
	
	//Enter location defined in data source
	public WebElement FirstName()
	{
		return firstName;
	}
	public WebElement LastName()
	{
		return lastName;
	} 
	public WebElement StartDate()
	{
		return startDate;
	}
	public WebElement Email()
	{
		return email;
	}
	public WebElement AddUser()
	{
		return add;
	} 
	

}
