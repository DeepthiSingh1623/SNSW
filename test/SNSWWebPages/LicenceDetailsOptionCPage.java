package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenceDetailsOptionCPage extends DriverPage {

	public LicenceDetailsOptionCPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//click Try linking another way for option A
		@FindBy(xpath="//a[text()='Try linking another way.']")
		private WebElement TryAnotherLink;
		
		public LicenceDetailsOptionAPage pressTrylinkingOptionA()

		{	

			explicitFluentWait(firstName);
			TryAnotherLink.click();
			return PageFactory.initElements(driver, LicenceDetailsOptionAPage.class);
			
		}
		
		@FindBy(id="lastName")
		private WebElement lastName;
		
		//Enter License_Number/Card Number on Option B page
		@FindBy(id="customerNumber")
		private WebElement customerNumber;
		
		//Enter Number of the Back of the Card on Option B page
		@FindBy(id="firstName")
		private WebElement firstName;
		
		@FindBy(name="dateOfBirth")
		private WebElement dateOfBirth;
		
		@FindBy(id="street")
		private WebElement streetName;
		
		@FindBy(name="postcode")
		private WebElement postCode;
		
		@FindBy(name="optionsRadioCustomerNumber")
		private WebElement optionsRadioCustomerNumber;
		
		public void enterOptionCDetails(String fName, String lName, String dob, String street, String postcode, String customerID){
			explicitFluentWait(firstName);
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			dateOfBirth.sendKeys(dob);
			streetName.sendKeys(street);
			postCode.sendKeys(postcode);
			optionsRadioCustomerNumber.click();
			customerNumber.sendKeys(customerID);
						
			
		}
		
		
		@FindBy(id="termsAndConditionsLinkRMS")
		private WebElement termsNCond;
		
		@FindBy(xpath="//button[text()='Next']")
		private WebElement nextBtn;
		
		public RMSLinkSucessMsgPage pressNextBtn(){
		
			termsNCond.click();
			nextBtn.click();	
			return PageFactory.initElements(driver, RMSLinkSucessMsgPage.class);
			
		}
		
}
