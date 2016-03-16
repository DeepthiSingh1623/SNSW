package SNSWTests;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import TestHelpers.Environment;






public class SNSWTestBase {
	
	public WebDriver driver ;

	
	@BeforeTest
	@Parameters({"Env", "Browser"})
	public void setUp( String Environment , String Browser) throws IOException, ParseException {
		
		
		driver = initiateBrowser(Browser);
		getEnvURL(Environment);
	}
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception{
		try{
			driver.close();
			driver.quit();
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	public WebDriver initiateBrowser(String Browser){
		if (Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(Browser.equalsIgnoreCase("ie")){
			//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver" , "drivers\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
			driver =  new InternetExplorerDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver" , "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (Browser.equalsIgnoreCase("Safari")){
			
			driver = new SafariDriver();
			
		}
		
		else{
			
			System.setProperty("webdriver.chrome.driver" , "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	static Environment env;
	public void getEnvURL(String environ){
		
		
		if(environ.equalsIgnoreCase("IT2")){
			 env = new Environment(Environment.Env.IT2);
		}
		
		else if(environ.equalsIgnoreCase("IT3")){
			 env = new Environment(Environment.Env.IT3);
		}
		
		else if(environ.equalsIgnoreCase("PSM")){
			 env = new Environment(Environment.Env.PSM);
		}
		
		
	}

}
