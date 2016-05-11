package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPassword extends DriverPage{
	
	public VerifyPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
		
	}
	
	@FindBy(xpath="//*[text()='Verify']")
	private WebElement VerifyBtn;
	
	public EditSecurityQuestionsPage verifyPwdBtn(String pwd) 
	{
		explicitFluentWait(password);
		enterPassword(pwd);
		VerifyBtn.click();
		return PageFactory.initElements(driver, EditSecurityQuestionsPage.class); 
	}
	
	

}
