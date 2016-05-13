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
	
	@FindBy(xpath="//a[@href='#/linkRMSProvideLicenseDetails']")
	private WebElement connectBtn;
	
	public LicenceDetailsPage PressRMSConnectBtn()
	{
		explicitFluentWait(connectBtn);
		connectBtn.click();
		return PageFactory.initElements(driver, LicenceDetailsPage.class);
	}
	

}
