package SNSWTests;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SNSWPerfectoPOCTest {
	
	WebDriver driver ;
	
  @Test
  public void testPOCScript() throws InterruptedException {
	  
	  	//	Login
	  	driver.findElement(By.id("username")).sendKeys("asrirupa@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("Pa$$w0rd");
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(7000);
		
		//Started linking to RMS
		driver.get(URL+"/index#/linkGovService");
		Thread.sleep(5000);
			
		WebElement connectRMSLink ;
		connectRMSLink=explicitFluentWait(By.xpath("//a[text()='Connect']"));
		connectRMSLink.click();
		Thread.sleep(5000);
		
		
		WebElement option1 ;
		option1=explicitFluentWait(By.linkText("Try linking another way."));
		option1.click();
		Thread.sleep(5000);
	
		
		WebElement option2 ;
		option2=explicitFluentWait(By.linkText("Try linking another way."));
		option2.click();
		Thread.sleep(5000);
		
		
		WebElement cardNo=explicitFluentWait(By.id("licenseOrCardNumber"));
		cardNo.sendKeys("19505664");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("snswtest1");
		driver.findElement(By.id("termsAndConditionsLinkRMS")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(10000);
			
		// Change address transaction
		driver.get(URL+"/index#/rms/changeDetails");
		Thread.sleep(5000);
						
		driver.findElement(By.xpath("//label[@id='formly_1_radio-panel_selectedOption_0']/span")).click();
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("sameAddress")).click();
		driver.findElement(By.id("formly_3_address_residentialAddress_2")).sendKeys("Unit 30, 552-554 Pacific Highway, Chatswood, NSW 2067");
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("emailAddress")).clear();
		driver.findElement(By.id("emailAddress")).sendKeys("it3report226@mailinator.com");
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(30000);
		
		
		String txt=driver.findElement(By.tagName("body")).getText();
		assertTrue("Message didnt match",txt.contains("You have changed your contact details with Roads and Maritime Services."));
		assertTrue("Message didnt match",txt.contains("We sent an activity alert about this transaction to the email on file with Roads and Maritime:"));
		driver.findElement(By.xpath("//button[text()='Send']")).click();
		Thread.sleep(5000);
		assertTrue("Message doidnt match", driver.findElement(By.tagName("body")).getText().contains("Receipt sent"));
		//Navigate to Dashboard screen
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[4]/a")).click();
		Thread.sleep(5000);
		
		// Unlink to RMS
		driver.get(URL+"/index#/linkGovService");
		Thread.sleep(5000);
				
		WebElement manageRMSLink ;
		manageRMSLink=explicitFluentWait(By.xpath("//a[text()='Manage']"));
		manageRMSLink.click();
		
		WebElement unLinkBtn ;
		unLinkBtn=explicitFluentWait(By.xpath("//a[text()='Unlink']"));
		unLinkBtn.click();
		
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pa$$w0rd");
		driver.findElement(By.xpath("//button[text()='Unlink']")).click(); 
		Thread.sleep(5000);
		
		//Logout user
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[8]/a")).click();
	    Thread.sleep(2000);
	    driver.switchTo().activeElement();
	    driver.findElement(By.xpath("//button[text()='Log out']")).click();
	    driver.switchTo().defaultContent();
	    Thread.sleep(5000);
		
  }
  String URL="https://it3-snsw.cs6.force.com/MyServiceNSW";
  @BeforeTest
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver" , "drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(URL);
		driver.manage().window().maximize();
		
  }
  public WebElement explicitFluentWait(By element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
		return element1;
	}
  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  
	  try{
			driver.close();
			driver.quit();
		}catch(WebDriverException e){
			e.printStackTrace();
		}
  }

}
