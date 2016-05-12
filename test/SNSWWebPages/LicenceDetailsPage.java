package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenceDetailsPage extends DriverPage{

	public LicenceDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Enter Last Name on Option B page 
	@FindBy(id="lastName")
	private WebElement lastName;
	
	//Enter License_Number/Card Number on Option B page
	@FindBy(id="licenseOrCardNumber")
	private WebElement licenseOrCardNumber;
	
	//Enter Number of the Bank of the Card on Option B page
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
	private WebElement NextBtn;
	
	//Last Name Enter
	public void enterLastName(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	
	//Enter License_Number/Card Number
		public void enterLicNum(String LicOrCardNum)
		{
			licenseOrCardNumber.sendKeys(LicOrCardNum);
		}
	
	public MyServicesPage PressNextBtn()
	{
		explicitFluentWait(NextBtn);
		NextBtn.click();
		return PageFactory.initElements(driver, MyServicesPage.class);
		
	}
	
	
	
	
	
	
	
}
