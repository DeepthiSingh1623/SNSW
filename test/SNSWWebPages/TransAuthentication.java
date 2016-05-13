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
	
	public LoginPage pressLoginBtn(){
		explicitFluentWait(loginBtn);
		loginBtn.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	

}
