/**
 * 
 */
package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Deepthi
 *
 */
public class FeedbackPage extends DriverPage{

	/**
	 * @param driver
	 */
	public FeedbackPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[Text()='Customer feedback']")
	public WebElement FeedBackpageTitle;
	
	@FindBy(xpath="//a[Text()='Our privacy statement']")
	public WebElement FeedBackPrivacyStatement;
	
	@FindBy(xpath="//input[@name='op']")
	public WebElement Submit;
	
		
}