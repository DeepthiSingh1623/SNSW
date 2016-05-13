package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicenceDetailsOptionCPage extends DriverPage {

	public LicenceDetailsOptionCPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//click Try linking another way option A
		@FindBy(xpath="//a[text()='Try linking another way.']")
		private WebElement TryAnotherLink;
		
		public LicenceDetailsOptionAPage pressTrylinkingOptionA()
		{
			TryAnotherLink.click();
			return PageFactory.initElements(driver, LicenceDetailsOptionAPage.class);
			
		}

}
