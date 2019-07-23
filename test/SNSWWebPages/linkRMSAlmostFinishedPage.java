package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class linkRMSAlmostFinishedPage extends DriverPage {

	public linkRMSAlmostFinishedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//select email option
	@FindBy(xpath="//*[@id='security_email']")
	//@FindBy(id="security_email")
   	private WebElement emailAddress;
	
	//select mobile option
	//@FindBy(xpath="//*[@id='security_mobile']")
	@FindBy (id="security_mobile")
	private WebElement mobileNumber;
	
	//Send Button
	@FindBy(xpath="//button[contains(text(),'Send')]")
	private WebElement sendButton;	
	
	//Verification code text box
	@FindBy(xpath="//*[@type= 'text']")
	private WebElement veriCode;
	
	
	// Enter button
	@FindBy(xpath="//button[contains(text(),'Enter')]")
	private WebElement enterButton;
	
	public void selectEmailOption()
	{
		mobileNumber.click();
	}
	public void enterSecurityCodeEmail(String verificationCode)
	{
		veriCode.sendKeys(verificationCode);
	}
	
	public RMSLinkSucessMsgPage RMSAlmostFinished(String verificationCode)
	{
		//explicitFluentWait(emailAddress);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectEmailOption();
		enterSecurityCodeEmail(verificationCode);
		//explicitFluentWait(LicDetailsOptBNextBtn);
		//PressLicenceDetailsPgeNextBtn();
		return PageFactory.initElements(driver, RMSLinkSucessMsgPage.class);
		
	}
	
}