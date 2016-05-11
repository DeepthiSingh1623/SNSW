/**
 * 
 */
package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author dev
 *
 */
public class LoginPage extends DriverPage{

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="loginBtn")
	private WebElement loginBtn;
	
	public void enterUserName(String uName){
		userName.sendKeys(uName);
	}
	
	public void enterPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void pressLoginBtn(){
		loginBtn.click();
	}
	
	public ServiceNSWDashboardPage loginMain(String uName,String pwd){
		enterUserName(uName);
		enterPassword(pwd);
		pressLoginBtn();
		return  PageFactory.initElements(driver, ServiceNSWDashboardPage.class);
	}

}
