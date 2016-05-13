package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemeritsTAndC extends DriverPage {

	public DemeritsTAndC(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='demerit-terms-agree']")
	public WebElement tandc;
	public void selectTermsAndConditions() {
		// TODO Auto-generated method stub
		explicitFluentWait(nextBtn);
		tandc.click();
		
	}
	
	@FindBy(xpath="//button[text()='Next']")
	public WebElement nextBtn;
	public DemeritPointsPage pressNextBtn() {
		// TODO Auto-generated method stub
		nextBtn.click();
		return PageFactory.initElements(driver, DemeritPointsPage.class);
		
	}
	

}
