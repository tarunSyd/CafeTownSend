package TestPlans;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.CreatePage;
import ObjectRepository.Driver;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utility.DataProviderSource;
import Utility.ExtentReport;
import Utility.commonMethods;

//@Listeners(TestMethodListener.class)
public class ManageUser {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void BeforeClass()
	{
		report = ExtentReport.getInstance();
	}
	
	@Test(dataProvider="CafeData", dataProviderClass=DataProviderSource.class)
	public void CreateNewUser(String userName, String pwd, String browser, String url, String email, String runFlag) throws IOException, InterruptedException
	{
		test = report.startTest("Create new user for Cafe Townsend site --" + browser);
		test.log(LogStatus.INFO, "This Testcase login into cafe Townsend site and create new user and"
				+ "once created successfully. It checks in list of employees and if not found test fail else test pass");	
		WebDriver driver = Driver.BrowserName(browser);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Windows maximised");
		driver.get(url);
		commonMethods.CheckPageIsLoaded(driver);
		test.log(LogStatus.INFO, "This test is running on '"+commonMethods.GetEnvironment(driver, url)+"' site");
		test.log(LogStatus.INFO, "Cafe Townsend site opened in browser... " + browser);
		commonMethods.CheckPageIsLoaded(driver);
		test.log(LogStatus.PASS, "Login page loaded successfully");
		LoginPage login = new LoginPage(driver);
		login.EnterUserName().sendKeys(userName);
		login.EnterPassword().sendKeys(pwd);
		login.ClickLogin().click();
		HomePage home = new HomePage(driver);
		Thread.sleep(3000);
		Assert.assertFalse(commonMethods.IsElementDisplayed(login.InValidUserPasswordMessage()), "Unable to Login into Cafe Townsend site....Login Failed");
		Assert.assertTrue(commonMethods.IsElementDisplayed(home.LogOut()), "Unable to Login into Cafe Townsend site....Login Failed");
		test.log(LogStatus.PASS, "User login into Cafe Townsend site successfully");
		commonMethods.waitUntilClickable(home.AddNewUser());
		home.AddNewUser().click();
		CreatePage create = new CreatePage(driver);
		String fName = "Tarun -"+commonMethods.GetCurrentDateTime();
		commonMethods.waitUntilClickable(create.FirstName());
		create.FirstName().sendKeys(fName);
		create.LastName().sendKeys("Bansal -"+commonMethods.GetCurrentDateTime());
		create.StartDate().sendKeys("2017-08-21");
		create.Email().sendKeys(email);
		create.AddUser().click();
		Thread.sleep(15000);
		Assert.assertTrue(home.CheckEmployeeInList(fName), "Employee not create and not showing in list");
		test.log(LogStatus.PASS, "Employee created successfully");
		home.LogOut().click();
		Assert.assertTrue(commonMethods.IsElementDisplayed(login.EnterUserName()), "Unable to logout of Cafe Townsend site....Logout Failed");
		test.log(LogStatus.PASS, "User Logout of Cafe Townsend site successfully");
	}	
		
	
	@AfterMethod
	public void TearDown(ITestResult testResult) throws Exception
	{
		if(testResult.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Following test completed and Passed ----- Test End");
		}
		if(testResult.getStatus() == ITestResult.FAILURE)
		{
			String path = commonMethods.takeSnapShot(Driver.dr, testResult.getName());
			String imagePath = test.addScreenCapture(path);
		    test.log(LogStatus.FAIL, testResult.getThrowable().getMessage());
			test.log(LogStatus.FAIL, "Test Failed" , imagePath);
		}
		if(testResult.getStatus() == ITestResult.SKIP)
		{
			if(testResult.getThrowable() !=null)
			{
				test.log(LogStatus.SKIP, testResult.getThrowable().getMessage());
			}
		}
	    Driver.dr.quit();
	    report.endTest(test);
	    report.flush();
		}
}
