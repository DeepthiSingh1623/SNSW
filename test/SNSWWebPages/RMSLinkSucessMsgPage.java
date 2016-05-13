package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RMSLinkSucessMsgPage extends DriverPage {
	
	
	public RMSLinkSucessMsgPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Success Message after Linking RMS
	@FindBy(xpath="//span[text()='Success!']")
	public WebElement SucessLinkLicenceDetailsMsg;
	
	//Next Button the Success Page Linking RMS
	@FindBy(xpath="//a[text()='Next']")
	private WebElement NextBtnSucessMsgPage;
	
	public void PressNextBtnSucessMsg()
	{
		NextBtnSucessMsgPage.click();
	}
	
	public MyServicesPage PressNextBtnSucessMsgScrn()
	{
		PressNextBtnSucessMsg();
		return PageFactory.initElements(driver, MyServicesPage.class);
	}

	
}
