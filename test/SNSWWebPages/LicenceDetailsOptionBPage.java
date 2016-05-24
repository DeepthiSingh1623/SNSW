package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenceDetailsOptionBPage extends DriverPage{

	public LicenceDetailsOptionBPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter Last Name on Option B page 
	@FindBy(id="lastName")
	private WebElement lastName;
	
	//Enter License_Number/Card Number on Option B page
	@FindBy(id="licenseOrCardNumber")
	private WebElement licenseOrCardNumber;
	
	//Enter Number of the Back of the Card on Option B page
	@FindBy(id="backNumber")
	private WebElement CardbackNumber;
	
		
	//Check the Terms and Condition Flag
	@FindBy(id="termsAndConditionsLinkRMS")
	private WebElement FlagTermsAndCondition;
	

	//click Try linking another way
	@FindBy(xpath="//a[text()='Try linking another way.']")
	private WebElement TryAnotherLink;
	
	
	//Click Next Button
	@FindBy(xpath="//button[contains(text(),'Next')]")
	private WebElement LicDetailsOptBNextBtn;
	
	//Last Name Enter
	public void enterLastName(String LastName)
	{
		explicitFluentWait(lastName);
		lastName.sendKeys(LastName);
	}
	
	//Enter License_Number/Card Number
	public void enterLicNum(String LicOrCardNum)
	{
		licenseOrCardNumber.sendKeys(LicOrCardNum);
	}
		
	//Enter Back of the Card Number
	public void enterLicCardNum(String CardNum)
	{
		CardbackNumber.sendKeys(CardNum);
	}
	
	public void pressTermsAndConditionsOptB()
	{
		explicitFluentWait(FlagTermsAndCondition);
		FlagTermsAndCondition.click();
	}
		
	//Click Next Button on the License Details Option B
	public void PressLicenceDetailsPgeNextBtn()
	{	
		explicitFluentWait(LicDetailsOptBNextBtn);
		LicDetailsOptBNextBtn.click();	
	}
			
	
	public RMSLinkSucessMsgPage RMSLinkOptionB(String LastName,String LicOrCardNum, String CardNum)
	{
		enterLastName(LastName);
		enterLicNum(LicOrCardNum);
		enterLicCardNum(CardNum);
		pressTermsAndConditionsOptB();
		explicitFluentWait(LicDetailsOptBNextBtn);
		PressLicenceDetailsPgeNextBtn();
		return PageFactory.initElements(driver, RMSLinkSucessMsgPage.class);
		
	}
	
	public LicenceDetailsOptionCPage pressTrylinkingOptionC()
	{
		explicitFluentWait(CardbackNumber);
		TryAnotherLink.click();
		return PageFactory.initElements(driver, LicenceDetailsOptionCPage.class);
		
	}
	
	
		
	
	
	
}
