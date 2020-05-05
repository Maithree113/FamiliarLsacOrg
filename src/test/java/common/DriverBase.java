package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverBase {
	
	enum browserType
	{   
		chrome ,
		IE,
		firefox,
		android,
		iOS
		
	}
	
	/** Sets and returns driver object based on browser value set in envronmentDetail.properties file 
	 * @throws MalformedURLException **/
	
	 public WebDriver createDriver(String browser) throws MalformedURLException
	    {
		   WebDriver driver=null;
		  
		   DesiredCapabilities capabilities= new DesiredCapabilities();
		
	    	switch(browserType.valueOf(browser))
	    	{
	    	  case chrome : System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/driver/chromedriver.exe");
	    		            driver = new ChromeDriver();
	    		            break;
	    	  case IE     : System.setProperty("webdriver.IE.driver",System.getProperty("user.dir")+"/src/test/java/driver/IEDriverServer.exe");
    		                driver = new InternetExplorerDriver();
	    		            break;
	    	  case firefox: System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/java/driver/geckodriver.exe");
	    	                DesiredCapabilities capabilitie = DesiredCapabilities.firefox();
	    	                capabilitie.setCapability("marionette",true);
	    	                driver= new FirefoxDriver(capabilitie);
	    		            break;
	    	  case android: capabilities.setCapability("pCloudy_Username", "Rakeshswain@eurofins.com");
	                        capabilities.setCapability("pCloudy_ApiKey", "9h7z88mtsv5jt88dvtbw4dzq");
	                        capabilities.setCapability("pCloudy_DeviceManafacturer", "Samsung");
	                        capabilities.setCapability("pCloudy_DeviceVersion", "9.0.0");
	                        capabilities.setCapability("newCommandTimeout", 600);
	                        capabilities.setCapability("pCloudy_DurationInMinutes", "10");
	                        capabilities.setCapability("launchTimeout", 90000);
	                        capabilities.setCapability("platformName", "Android");
	                        capabilities.setBrowserName("Chrome");
	                        driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"),capabilities);
	                        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			                break;	            
	    	  case iOS    : capabilities.setCapability("pCloudy_Username", "Rakeshswain@eurofins.com");
                            capabilities.setCapability("pCloudy_ApiKey", "9h7z88mtsv5jt88dvtbw4dzq");
                            capabilities.setCapability("pCloudy_DeviceManafacturer", "iPhone");
                            capabilities.setCapability("pCloudy_DeviceVersion", "11.0.0");
                            capabilities.setCapability("newCommandTimeout", 600);
                            capabilities.setCapability("pCloudy_DurationInMinutes", "10");
                            capabilities.setCapability("launchTimeout", 90000);
	    		            capabilities.setCapability("platformName", "iOS");
	    		            capabilities.setBrowserName("Safari");
	    		            driver = new IOSDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"),capabilities);
	    		            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    		            break;
	    	  default :
	    		driver = null;
	    		
	    	}
	    	
	    	return driver;
	    }
}
