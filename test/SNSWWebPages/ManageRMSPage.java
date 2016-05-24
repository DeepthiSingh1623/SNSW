package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageRMSPage extends DriverPage {

	public ManageRMSPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="residentialAddress")
	public WebElement ResAddress;
	
	@FindBy(id="mailingAddress")
	public WebElement MailAddres;
	
	//Click Unlink Button on the RMS Manage Screen
	@FindBy(xpath="//a[text()='Unlink']")
	private WebElement UnlinkBtn;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	private WebElement UnlinkYesBtn;
	
	public VerifyPassword unlinkRMS() {
		 	UnlinkBtn.click();
		   explicitFluentWait( driver.switchTo().activeElement());
		   driver.switchTo().activeElement();
		    UnlinkYesBtn.click();
		    driver.switchTo().defaultContent();
		    return PageFactory.initElements(driver, VerifyPassword.class);
	    }
	
	
	
			
			
	}
