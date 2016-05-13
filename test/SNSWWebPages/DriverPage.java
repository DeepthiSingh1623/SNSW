package SNSWWebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DriverPage {
	
	static WebDriver driver; 
	public DriverPage(WebDriver driver)
	{
		this.driver=driver;   
		//System.out.println("Driver title from super class:"+driver.getCurrentUrl());
		
	} 

	public void open(String url) {
		driver.get(url);
	}

	public void close() {
		driver.quit();
	}

	public String getTitle() {
	return driver.getTitle();
	}
	
	public static WebDriver getDriverInstance() {
		return driver;
	}

	public WebElement explicitFluentWait(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
	public boolean isElementExist(WebElement elemetName){
	
		boolean present=true;
		try {
			
			if(elemetName.isDisplayed())
				present = true;
			else 
				present = false;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		
		return present;
	}
	
	public String getBodyText(){
		
		return driver.findElement(By.tagName("body")).getText();
		
	}
	
	public List<WebElement> isTextPresentOnScreen(String text) {
		
		return driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
	}

public String getGlobalErrorMsgText() {
		
		return driver.findElement(By.xpath("//div[@class='alert alert-danger alert-with-icon alert-validation-summary']")).getText();
	}

@FindBy(xpath="/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[8]/a")
private WebElement logoutLink;

@FindBy(xpath="//button[text()='Log out']")
private WebElement logoutPbtn;

public void pressLogoutButton() throws InterruptedException {
	logoutLink.click();
    Thread.sleep(2000);
    driver.switchTo().activeElement();
    logoutPbtn.click();
    driver.switchTo().defaultContent();
    Thread.sleep(5000);
}

	
}
