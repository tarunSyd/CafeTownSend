package ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	public static WebDriver dr=null;
	
	public static WebDriver BrowserName(String browser) throws IOException
	{
	 if(browser.equals("firefox"))
	 {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumFiles\\Drivers\\geckodriver.exe");
		 dr = new FirefoxDriver();
	 }
	 else if(browser.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\Drivers\\chromedriver.exe");
		 dr = new ChromeDriver();
	 }
	 else if(browser.equals("IE"))
	 {
		 DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		 caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		 caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		 caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		 caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		 caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);    
		 System.setProperty("webdriver.ie.driver", "C:\\SeleniumFiles\\Drivers\\IEDriverServer.exe");
		 dr = new InternetExplorerDriver(caps);
	 }
	 else if(browser.equals("safari"))
	 {
		 dr = new SafariDriver();
	 }
	 
	 return dr;
	}

}
