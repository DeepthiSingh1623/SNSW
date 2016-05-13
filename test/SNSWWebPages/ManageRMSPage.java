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
	private WebElement ResAddress;
	
	@FindBy(id="mailingAddress")
	private WebElement MailAddres;
	
	@FindBy(xpath="//a[text()='Unlink']")
	private WebElement UnlinkBtn;
	
	public ManageRMSPage PressRMSUnlinkBtn()
	{
		explicitFluentWait(UnlinkBtn);
		UnlinkBtn.click();
		return PageFactory.initElements(driver, ManageRMSPage.class);
	}
	
	
			
			
	}
