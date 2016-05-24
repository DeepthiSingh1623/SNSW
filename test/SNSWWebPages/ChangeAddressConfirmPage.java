package SNSWWebPages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeAddressConfirmPage extends DriverPage{

	public ChangeAddressConfirmPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//div[@ng-if='changeDetails.model.residentialAddress.dpid']")
	private WebElement ChangedAddress;
	
	@FindBy(xpath = "//input[@id='formly_5_checkbox-label-with-action_termsAndConditions_0']")
	private WebElement tAndcConfirmPageBtn;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement AddChngConfirmPageSubmitBtn;
	
	@FindBy(xpath = "//*[text()='Email address:']/../../div[2]")
	private WebElement emailId;
	
	
	@FindBy(xpath = "//*[text()='Mobile number:']/../../div[2]")
	private WebElement mobileNum;
	
	public String getTextAddList()
	{
		return ChangedAddress.getText();
		
	}
	
	public String getChangedEmailid()
	{
		return emailId.getText();
	}
	
	public String getChangedMobileNum()
	{
		return mobileNum.getText();
	}
	public void pressTandCConfirmPageBtn()
	{
		tAndcConfirmPageBtn.click();
		
	}
	
	
	public void SubmitBtn()
	{
		AddChngConfirmPageSubmitBtn.click();
	}
	
	public ChangeAddressSucessPage pressAddChngdditionalSubmitBtn()
	{
			try
			{
			explicitFluentWait(tAndcConfirmPageBtn);
			}
			catch(TimeoutException e){
			
			}
			pressTandCConfirmPageBtn();
		
		explicitFluentWait(AddChngConfirmPageSubmitBtn);
		SubmitBtn();
		return PageFactory.initElements(driver, ChangeAddressSucessPage.class);
	}
	

}
