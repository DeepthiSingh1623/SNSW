package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RMSUnlinkSucessPage extends DriverPage 
{

	public RMSUnlinkSucessPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//p[text()='Your account has been unlinked.']")
	public WebElement UnlinkSucessMsg;
	
	@FindBy(xpath="//a[text()='View Linked Services']")
	private WebElement ViewlinkedServices;
	
	public void viewlinkedservicesBtn()
	{
		
		ViewlinkedServices.click();
	}
	
	public MyServicesPage PressViewLinkedServicesBtn()
	{
		viewlinkedservicesBtn();
		return PageFactory.initElements(driver, MyServicesPage.class);
	}

	
}
