package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.Driver;

public class commonMethods {
	WebDriver driver;
	static ExtentTest test;
	//SoftAssert Soft_Assert = new SoftAssert();
	public commonMethods(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	


public static WebElement waitUntilClickable(WebElement webElement){
	WebElement element = null;		
	WebDriverWait wait = new WebDriverWait(Driver.dr, 40);
	try{
	 element = wait.until(ExpectedConditions.elementToBeClickable(webElement));	
	
	}
	catch(NoSuchElementException e)
	{
		String[] e1=e.getMessage().split("}");
		//commonMethods.xmlFile.write("<results>"+"<Title>"+"WebElement Name:  "+webElement.getAttribute("name")+"  check box"+"</Title>"+"<MethodName>"+e.getStackTrace()[4].getMethodName()+"()"+"</MethodName>"+"<Exception>"+e1[0]+"</Exception>"+"<PassFail>Fail</PassFail>"+"</results>");		
	}
	catch(Exception e){
		String[] e1=e.getMessage().split(":");
		//commonMethods.xmlFile.write("<results>"+"<Title>"+"WebElement Name:  "+webElement.getAttribute("name")+"</Title>"+"<MethodName>"+e.getStackTrace()[4].getMethodName()+"()"+"</MethodName>"+"<Exception>"+e1[0]+"</Exception>"+"<PassFail>Fail</PassFail>"+"</results>");	
	}
	return element;
 }

public static boolean IsElementDisplayed(WebElement webElement) throws InterruptedException
{
	try{
			//waitUntilClickable(webElement);	
		   Thread.sleep(15000);
			return webElement.isDisplayed();
		}
	catch(NoSuchElementException e)
	{
		//String[] e1=e.getMessage().split("}");
		//commonMethods.xmlFile.write("<results>"+"<Title>"+"WebElement Name:  "+webElement.getAttribute("name")+"  requested option not available"+"</Title>"+"<MethodName>"+e.getStackTrace()[2].getMethodName()+"()"+"</MethodName>"+"<Exception>"+e1[0]+"</Exception>"+"<PassFail>Fail</PassFail>"+"</results>");	
		return false;
	}	
}

  public static WebElement getWebElement(WebDriver driver, String id) {
        WebElement myDynamicElement = null;
        try {
            myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By
                            .id(id)));
            return myDynamicElement;
        } catch (NoSuchElementException ex) {
            return null;
        }
    }
  
  public static String takeSnapShot(WebDriver webdriver,String fileName) throws Exception{
	  
	    //Convert web driver object to TakeScreenshot
		fileName = fileName+GetCurrentDateTime()+".png";
	  String directory = "\\Users\\tarunbansal\\Desktop\\Automation Results\\Screenshots\\";
	    TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	    //Call getScreenshotAs method to create image file

	            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(SrcFile, new File(directory + fileName));
	            String destination = directory + fileName;
	            return destination;
	}

  
  public static String GetDate(int days)
  {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  Calendar c = Calendar.getInstance();
	  c.setTime(new Date()); // Now use today date.
	  c.add(Calendar.DATE, days); // Adding 5 days
	  String outputDate = sdf.format(c.getTime());
	return outputDate;  
  }
  
  public static String GetCurrentDateTime()
  {
	    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");  
	    Date date = new Date();
	   String currentDate = dateFormat.format(date);
	return currentDate;  
  }
  
  public static String GetCurrentDate()
  {
	    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");  
	    Date date = new Date();
	   String currentDate = dateFormat.format(date);
	return currentDate;  
  }
 
 public static String GetEnvironment(WebDriver driver, String url)
 {
	 String env = null;
	 if(url.contains("cafetown"))
	 {
		 env = "CafeTownSend";
	 }
	 return env;
 }
 
 
 public static void CheckPageIsLoaded(WebDriver driver)
 {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
	  //You can replace your value with 25 If you wants to Increase or decrease wait time.
	  for (int i=0; i<25; i++){ 
	   try {
	    Thread.sleep(1000);
	    System.out.println(i);
	    }catch (InterruptedException e) {} 
	   //To check page ready state.
	   if (js.executeScript("return document.readyState").toString().equals("complete")){
		   System.out.println("Page loaded successfully");
	    break; 
	   }   
	  }
 }
 


}
