/**
 * 
 */
package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author deepthi
 *
 */
public class SettingsPage extends DriverPage
{

	public SettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@href='#/securitySettings/securityQuestions']")
	private WebElement SecurityEditBtn;
	
	public VerifyPassword PressSecurityEditBtn()
	{
		explicitFluentWait(SecurityEditBtn);
		SecurityEditBtn.click();
		return PageFactory.initElements(driver, VerifyPassword.class);
	}
	
	@FindBy(xpath="//span[text()='New security questions and answers have been saved.']")
	public WebElement SavedSecurityMsg;
	
	
	
	
	

}
