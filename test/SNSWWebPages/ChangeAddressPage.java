package SNSWWebPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChangeAddressPage extends DriverPage{

	public ChangeAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Enter the  Changed address 
	@FindBy(xpath="//input[@id='formly_3_address_residentialAddress_2']")
	private WebElement changeAddress;
	
	@FindBy(xpath="//input[@id='formly_3_address_residentialAddress_2']/../ul/li/a]")
	private WebElement addressList;
	
	@FindBy(xpath="//*[text()='Back']/../input")
	private WebElement AddressChangedNextBtn;
	
	public void enterChangedAdd(String Add)
	{
		changeAddress.sendKeys(Add);
	}
	
		
	public void selectfromAddList()
	{
		addressList.click();
	}

	
	public void pressAddressChgNextBtn()
	{
		AddressChangedNextBtn.click();
	}
	
	
	
	public void enterChangedAddress(String Add) 
	{
		explicitFluentWait(changeAddress);
		enterChangedAdd(Add);
		try{
		explicitFluentWait(addressList);
		}
		catch(TimeoutException e){
			
		}
		changeAddress.sendKeys(Keys.ENTER);
	}
	
		
	
	public ChangeAddressAdditionalPage enterChangedAddressNextBtn() 
	
	{ 
		explicitFluentWait(AddressChangedNextBtn);
		pressAddressChgNextBtn();		
		return PageFactory.initElements(driver, ChangeAddressAdditionalPage.class);
	}
	
}
	
	
	
	

