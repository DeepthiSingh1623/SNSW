package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeAddressAdditionalPage extends DriverPage{

	public ChangeAddressAdditionalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Email id Change on the Change Address Additional Page
	@FindBy(xpath="//input[@id ='formly_4_input_emailAddress_1']")
	private WebElement changeEmailId;
	
	//Mobile Number Change on the Change Address Additional Page
	@FindBy(xpath="//input[@id='formly_4_input_mobileNumber_3']")
	private WebElement changeMobileNum;
	
	//Next Button on the Change Address Additional Page
	@FindBy(xpath="//input[@value='Next']")
	private WebElement AddressChangedAdditionalNextBtn;
	
	public void enterEmailId(String emailId)
	
	{
		
		changeEmailId.clear();
		changeEmailId.sendKeys(emailId);
	}
	
	public void enterMobileNum(String MobileNum)
	
	{
		
		changeMobileNum.clear();
		changeMobileNum.sendKeys(MobileNum);
	}
	
	public ChangeAddressConfirmPage pressAddressChangedAdditionalNextBtn()
	
	{
		explicitFluentWait(AddressChangedAdditionalNextBtn);
		AddressChangedAdditionalNextBtn.click();
		return PageFactory.initElements(driver, ChangeAddressConfirmPage.class);
	}
	
	public ChangeAddressConfirmPage pressMobileAndEmailChangeNextBtn(String emailId, String MobileNum)
	{
		explicitFluentWait(changeEmailId);
		enterEmailId(emailId);
		explicitFluentWait(changeMobileNum);
		enterMobileNum(MobileNum);
		try{
			explicitFluentWait(changeEmailId);
		    }
		catch(Exception e){
			
		}
		explicitFluentWait(AddressChangedAdditionalNextBtn);
		AddressChangedAdditionalNextBtn.click();		
		return PageFactory.initElements(driver, ChangeAddressConfirmPage.class);
		
	}
	
	
	

}
