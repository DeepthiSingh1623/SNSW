package SNSWWebPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DriverPage {
	
	static WebDriver _driver; 
	public DriverPage(WebDriver driver)
	{
		_driver=driver;   
	} 

	public void open(String url) {
		_driver.get(url);
	}

	public void close() {
		_driver.quit();
	}

	public String getTitle() {
	return _driver.getTitle();
	}
	
	public static WebDriver getDriverInstance() {
		return _driver;
	}

	public WebElement explicitFluentWait(WebElement element){
		WebDriverWait wait = new WebDriverWait(_driver, 60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
	public boolean isElementExist(WebElement elemetName){
	
		boolean present=true;
		try {
			
			elemetName.click();
			present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		
		return present;
	}

	
	
}
