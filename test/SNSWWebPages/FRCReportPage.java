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
public class FRCReportPage extends DriverPage{

	/**
	 * @param driver
	 */
	public FRCReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Finish']")
	private WebElement finishBtn;
	
	@FindBy(xpath="//a[text()='Back']")
	private WebElement backBtn;
	
	@FindBy(xpath="//a[text()='Buy Vehicle History Report']")
	private WebElement buyVHCBtn;
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-8']")
	private WebElement reportContent;
	
	
	
	public void waitforPageLoad(){
		
		explicitFluentWait(finishBtn);
		
	}
	
	public String getFRCReportContent(){
		return reportContent.getText();
	}
	
	public VHCConfirmationPage pressBuyVHC(){
		buyVHCBtn.click();
		return PageFactory.initElements(driver, VHCConfirmationPage.class);
	}
	
	public void pressFinish(){
		finishBtn.click();
	}
	
	public VHCConfirmationPage pressBackBtn(){
		backBtn.click();
		return PageFactory.initElements(driver, VHCConfirmationPage.class);
	}

}
