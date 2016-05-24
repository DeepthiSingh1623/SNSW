package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeAddressSucessPage extends DriverPage{

	public ChangeAddressSucessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Changed Residential Address 
	@FindBy(xpath="//div[@ng-if='changeDetails.model.residentialAddress.dpid']")
	public WebElement ChangedResidentialAddress;
	
	
	//Changed Mailing Address
	@FindBy(xpath="//div[@ng-if='changeDetails.model.sameAddress && changeDetails.model.residentialAddress.dpid']")
	public WebElement ChangedMailingAddress;
	
	//Changed Email Id
	@FindBy(xpath="//div[@ng-if='changeDetails.emailChanged()']")
	public WebElement changedEmailId;
	
	//Changed Mobile Number
	@FindBy(xpath="//div[@ng-if='changeDetails.mobileChanged() && changeDetails.model.mobileNumber']")
	public WebElement changedMobileNum;
		
	
	//Successfully Address changed message
	@FindBy(xpath="//p[text()='You have changed your contact details with Roads and Maritime Services.']")
	public WebElement AddChangeSucessMessage;

}
