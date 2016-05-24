package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransAuthentication extends DriverPage{

	public TransAuthentication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//span[text()='Continue as guest']")
	private WebElement loginAsGuestBtn;
	
	public void LoginBtn()
	{
		loginBtn.click();
	}
	
	public LoginPage pressLoginBtn(){
		explicitFluentWait(loginBtn);
		LoginBtn();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	

	public SelectOptionAddressChange pressLoginBtnRedirects(){
		explicitFluentWait(loginBtn);
		LoginBtn();
		return PageFactory.initElements(driver, SelectOptionAddressChange.class);
	}
	
	public void GuestBtn()
	{
		loginAsGuestBtn.click();
	}
	
	public GuestLoginOptionBLicDetails pressContAsGuestBtn(){
		explicitFluentWait(loginAsGuestBtn);
		GuestBtn();
		return PageFactory.initElements(driver, GuestLoginOptionBLicDetails.class);
	}
	
	
	
	

}
