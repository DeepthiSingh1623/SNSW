/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Kurt
 */
public class RMSChangeDetailsPage extends DriverPage{
    
    
    private static final String weNextButton = "//input[@class='pull-right btn btn-primary ng-scope'][@type='submit'][@value='Next']";
    private static final String weHeading = "//h2[@title='1. Choose the details you want to change']";
    private static final String weStep1Title = "//div[contains(text(), \"Step 1/5\")]";
    private static final String weStepsCompleted = "//div[@class='ng-scope progress-bar progress-bar-success'][@ng-repeat='step in steps']";
    private static final String weStepsToDo = "//div[@class='ng-scope progress-bar progress-bar-transparent'][@ng-repeat='step in steps']";
    private static final String weOptionsSelection = "//span[@ng-bind-html='option.label']";

    
    
    //private final WebDriver driver; DS - Commented on 16 May 2016
    
    //DS - Commented on 16 May 2016
    /*public RMSChangeDetailsPage(WebDriver driver) {
        this.driver = driver;
    }*/ 
    
   //DS - Added the below constructor
    public RMSChangeDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
    //DS - Change Button
	@FindBy(xpath = "html/body/div[2]/div[2]/div/div[2]/div[2]/a")
	private WebElement AddressChangeBtn;
	
	public void pressAddressChange()
	{
		AddressChangeBtn.click();
	}
	
	    
	public SelectOptionAddressChange pressAddressChangebtn()
	{
		explicitFluentWait(AddressChangeBtn);
		pressAddressChange();
		return PageFactory.initElements(driver,SelectOptionAddressChange.class);
	}

    
    
    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RMSChangeDetailsPage.weNextButton)));
    }
    
    
    public boolean findHeading() {
        try {
            WebElement element = driver.findElement(By.xpath(RMSChangeDetailsPage.weHeading));
            return true;
        }  catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    
    public boolean findStep1Element() {
        try {
            WebElement element = driver.findElement(By.xpath(RMSChangeDetailsPage.weStep1Title));
            return true;
        }  catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    
    public boolean findNextButton() {
        try {
            WebElement element = driver.findElement(By.xpath(RMSChangeDetailsPage.weNextButton));
            return true;
        }  catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    
    public boolean findOptionElemnts(List<String> options) {
        try {
            List<WebElement> we = driver.findElements(By.xpath(RMSChangeDetailsPage.weOptionsSelection));
            System.out.println("Found the following elements: " + we.size());
            
            if (we.size() != options.size()) {
                System.out.println("The elements found: [" + we.size() + "], and expected: [" + options.size() + "] did not match.");
                System.out.println("Found Elements:");
                for (WebElement w : we) {
                    System.out.println("Found Element Text: [" + w.getText() + "]");
                }
                
                System.out.println("Expected Elements:");
                for (String s : options) {
                    System.out.println("Expected Element Text: [" + s + "]");
                }
                return false;
            }
            
            boolean success = true;
            int count = we.size();
            for (int i = 0; i < count; ++i) {
                if (!we.get(i).getText().equals(options.get(i))) {
                    System.out.println("Element: " + i + " not matching expected");
                    success = false;
                }
            }
            
            return success;
        }  catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
            
            
          

        }
    }
}
