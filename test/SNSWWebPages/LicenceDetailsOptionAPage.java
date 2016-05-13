package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenceDetailsOptionAPage extends DriverPage {

	public LicenceDetailsOptionAPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="licenseOrCardNumber")
	private WebElement LicenceOrCardNum;
	
	@FindBy(id="password")
	private WebElement RtaPassword;
	
	@FindBy(xpath="//input[@id='termsAndConditionsLinkRMS']")
	private WebElement FlagTermsAndConditionRta;
	
	//Click Next Button
	@FindBy(xpath="//button[contains(text(),'Next')]")
	private WebElement LicDetailsOptANextBtn;
	
	//Enter License Number or Card Number
	public void enterRtaLicNum(String LicNum)
	{
		LicenceOrCardNum.sendKeys(LicNum);
	}
	
	//Enter Password for OptionA
	public void enterRtaPwd(String pwd)
	{
		RtaPassword.sendKeys(pwd);
	}
	
	public void ClickRtaTermsAndConditions()
	{
		FlagTermsAndConditionRta.click();
	}
	
	
	
	//Click Next Button on the License Details Option B
	public void PressLicenceDetailsPgeOptionANextBtn()
	{
		LicDetailsOptANextBtn.click();	
	}
	
				
		public RMSLinkSucessMsgPage enterRtaLicDetails(String LicNum, String pwd)
		{
		enterRtaLicNum(LicNum);
		enterRtaPwd(pwd);
		ClickRtaTermsAndConditions();
		PressLicenceDetailsPgeOptionANextBtn();
		return PageFactory.initElements(driver, RMSLinkSucessMsgPage.class);
		
		}
}
