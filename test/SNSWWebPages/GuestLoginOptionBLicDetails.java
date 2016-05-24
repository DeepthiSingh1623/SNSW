package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestLoginOptionBLicDetails extends DriverPage{

	public GuestLoginOptionBLicDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Enter Last Name on Option B page 
	@FindBy(xpath ="//input[@id='formly_3_input_lastName_2']")
	private WebElement lastName;
	
	//Enter License_Number/Card Number on Option B page
	@FindBy(xpath ="//input[@id='formly_3_input_photoIdNumber_3']")
	private WebElement nswPhotoCardNumber;
	
	//Enter Number of the Back of the Card on Option B page
	@FindBy(xpath ="//input[@id='formly_3_input_cardNumber_5']")
	private WebElement cardIDNumber;
	
		
		//Click Next Button
	@FindBy(xpath="//input[@value ='Next']")
	private WebElement guestDetailsNextBtn;
	
	//Last Name Enter
	public void enterSurName(String surName)
	{
		explicitFluentWait(lastName);
		lastName.sendKeys(surName);
	}
	
	//Enter License_Number/Card Number
	public void enterPhotoCardNum(String photoCardNum)
	{
		explicitFluentWait(nswPhotoCardNumber);
		nswPhotoCardNumber.sendKeys(photoCardNum);
	}
		
	//Enter Back of the Card Number
	public void enterLicCardIdNum(String cardIdNumBr)
	{
		explicitFluentWait(cardIDNumber);
		cardIDNumber.sendKeys(cardIdNumBr);
	}
	
	//Click Next Button on the License Details Option B
	public void PressGuestLicPgeNextBtn()
	{	
		explicitFluentWait(guestDetailsNextBtn);
		guestDetailsNextBtn.click();	
	}
			
	public GuestAddressChangePage addChangeAsGuest(String surName,String photoCardNum, String cardIdNumBr)
	{
		enterSurName(surName);
		enterPhotoCardNum(photoCardNum);
		enterLicCardIdNum(cardIdNumBr);
		explicitFluentWait(guestDetailsNextBtn);
		PressGuestLicPgeNextBtn();
		return PageFactory.initElements(driver, GuestAddressChangePage.class);
		
	}
	
	


}
