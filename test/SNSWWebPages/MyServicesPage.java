package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyServicesPage extends DriverPage
{

	public MyServicesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Click Connect Button 	
	@FindBy(xpath="//a[@href='#/linkRMSProvideLicenseDetails']")
	private WebElement connectBtn;
	
	public LicenceDetailsOptionBPage PressRMSConnectBtn()
	{
		explicitFluentWait(connectBtn);
		connectBtn.click();
		return PageFactory.initElements(driver, LicenceDetailsOptionBPage.class);
	}
	
	//Click Manage Button
	@FindBy(xpath="//a[text()='Manage']")
	private WebElement RMSManageBtn;
	
	public ManageRMSPage PressRMSManageBtn()
	{
		explicitFluentWait(RMSManageBtn);
		RMSManageBtn.click();
		return PageFactory.initElements(driver, ManageRMSPage.class);
	}
	
	

}
