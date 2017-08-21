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

public class LoginPage {
	
	WebDriver driver;
	//This is constructor required to initialize driver
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page factory model
	@FindBy(xpath=".//*[@id='login-form']/fieldset/label[1]/input")
	WebElement enterUserName;
	@FindBy(xpath=".//*[@id='login-form']/fieldset/label[2]/input")
	WebElement enterPwd; 
	@FindBy(xpath=".//*[@id='login-form']/fieldset/button")
	WebElement clickLogin; 
	@FindBy(xpath=".//*[@id='login-form']/fieldset/p[1]")
	WebElement inValidUserPasswordMessage; 
	
	

	public WebElement EnterUserName()
	{
		return enterUserName;
	}
	public WebElement EnterPassword()
	{
		return enterPwd;
	}
	public WebElement ClickLogin()
	{
		return clickLogin;
	}
	public WebElement InValidUserPasswordMessage()
	{
		return inValidUserPasswordMessage;
	} 

}
