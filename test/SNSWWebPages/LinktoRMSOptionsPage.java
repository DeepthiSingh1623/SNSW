package SNSWWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinktoRMSOptionsPage extends DriverPage {

	public LinktoRMSOptionsPage(WebDriver driver) {
		super(driver);
	}

//select option B on RMSLinking page
   @FindBy(id="option1")
   	private WebElement linkOptionB;

 //select option A on RMSLinking page
 @FindBy(id="option2")
   //@FindBy (xpath="//*[@id='option3']")
 	private WebElement linkOptionA;
 	
 //select option C on RMSLinking page
  	@FindBy(id="option2")
 	private WebElement linkOptionC;
  	
 // click next button
  	@FindBy(xpath="//button[contains(text(),'Next')]")
  	private WebElement linkToRMSOptionNext;
  	
 //select option A for linking 
 public void clickOptionA()
 {
	 linkOptionA.click();
 }
 
 //select option B for linking
 public void clickOptionB()
 {
	 linkOptionB.click();
 }
 
 //click on Next
 public void PressRMSLinkOptionNextBtn()
 {
	 linkToRMSOptionNext.click();
 }
 
 public LicenceDetailsOptionAPage selectLinkOptionA()
	{
		
	clickOptionA();
	PressRMSLinkOptionNextBtn();
	return PageFactory.initElements(driver, LicenceDetailsOptionAPage.class);
	
	}
 
 public LicenceDetailsOptionBPage selectLinkOptionB()
 {
	 clickOptionB();
	 PressRMSLinkOptionNextBtn();
	 return PageFactory.initElements(driver, LicenceDetailsOptionBPage.class);
 } 
 
} 
 
 	
  	
 	
 	
 	

