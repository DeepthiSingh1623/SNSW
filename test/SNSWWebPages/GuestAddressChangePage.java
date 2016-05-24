package SNSWWebPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestAddressChangePage extends DriverPage{

	public GuestAddressChangePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
		//Enter the  guest Changed address 
		@FindBy(xpath="//input[@id='formly_4_address_residentialAddress_2']")
		private WebElement guestchangeAddress;
	
		
		//guest AddressList
	
		@FindBy(xpath="//input[@id='formly_4_address_residentialAddress_2']/../ul/li/a]")
		private WebElement guestAddressList;
	
	
		@FindBy(xpath="//input[@value='Next']")
		private WebElement guestAddressChangedNextBtn;
	
		public void enterStrGuestChangedAdd(String Add)
		{
		guestchangeAddress.sendKeys(Add);
		}
	
		public void selectfromguestAddList()
		{
		guestAddressList.click();
		}

		public void pressGuestAddressChgNextBtn()
		{
			guestAddressChangedNextBtn.click();
		}
	
			
		public void enterGuestChangedAddress(String Add) 
		{
		explicitFluentWait(guestchangeAddress);
		enterStrGuestChangedAdd(Add);
		try{
		explicitFluentWait(guestAddressList);
		}
		catch(TimeoutException e){
			
		}
		guestchangeAddress.sendKeys(Keys.ENTER);
		}
	
		public GuestConfirmPage enterGuestChangedAddressNextBtn() 
		{
		explicitFluentWait(guestAddressChangedNextBtn);	
		pressGuestAddressChgNextBtn();		
		return PageFactory.initElements(driver, GuestConfirmPage.class);
		}
	
	
}	
	
	
	




