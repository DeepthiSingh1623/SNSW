/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import org.openqa.selenium.By;
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
public class ServiceNSWDashboardPage extends DriverPage{
    
    
    
    public ServiceNSWDashboardPage(WebDriver driver) {
        super(driver);
    }

    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[8]/a")));
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
    
  //Deepthi adding Feedback Button
    @FindBy(xpath="//a[text()='Give feedback']")
    private WebElement FeedbackBtn;
    
    public FeedbackPage pressFeedbackButton(){
    	explicitFluentWait(FeedbackBtn);
    	FeedbackBtn.click();
    	return PageFactory.initElements(driver,FeedbackPage.class); 
    }        
    
    //DS adding Setting tab 
    @FindBy(xpath="//a[text()='Settings']")
    private WebElement SettingsTab;
    
    public SettingsPage pressSettingsTab()
    {
    	explicitFluentWait(SettingsTab);
    	SettingsTab.click();
    	return PageFactory.initElements(driver, SettingsPage.class);
    }
}
