/**
 * 
 */
package r1regression;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import SNSWWebPages.LoginPage;
import TestHelpers.Environment;

/**
 * @author dev
 *
 */
public class R1RegressionTestBase {
	
	 WebDriver driver ;

		
		@BeforeClass
		@Parameters({"Env", "Browser"})
		public void setUp( String Environment , String Browser) throws IOException, ParseException {
			
			
			driver = initiateBrowser(Browser);
			getEnvURL(Environment);
		}
		
		
		

		@AfterClass(alwaysRun=true)
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
				
				System.setProperty("webdriver.chrome.driver" , "drivers\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else if (Browser.equalsIgnoreCase("Safari")){
				
				driver = new SafariDriver();
				
			}
			
			else{
				
				System.setProperty("webdriver.chrome.driver" , "drivers\\chromedriver\\chromedriver.exe");
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