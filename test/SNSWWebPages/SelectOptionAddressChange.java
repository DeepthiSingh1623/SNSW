package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOptionAddressChange extends DriverPage{

	public SelectOptionAddressChange(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Select the first Option
	@FindBy(xpath="//label[@id='formly_1_radio-panel_selectedOption_0']")
	private WebElement AddChangeStep1FirstOptionRadioBtn;

	//Next Button of Change Address and Contain Step1
	@FindBy(xpath="//input[@value='Next']")
	private WebElement AddChangeStep1NextBtn;
	
	public void selectOption1()
	{
		AddChangeStep1FirstOptionRadioBtn.click();
	}
	
	public void NextBtn()
	{
		AddChangeStep1NextBtn.click();
	}
	
		
	public ChangeAddressPage pressAddChangeSelectOption()
	{
		explicitFluentWait(AddChangeStep1FirstOptionRadioBtn);
		selectOption1();
		NextBtn();
		return PageFactory.initElements(driver, ChangeAddressPage.class);
	}
	
	public GuestAddressChangePage pressGuestAddChangeSelectOption()
	{
		explicitFluentWait(AddChangeStep1FirstOptionRadioBtn);
		selectOption1();
		NextBtn();
		return PageFactory.initElements(driver, GuestAddressChangePage.class);
	}
	
}
