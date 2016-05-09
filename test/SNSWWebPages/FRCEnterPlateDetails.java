package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FRCEnterPlateDetails extends DriverPage{
	
		
	/**
	 * @param driver
	 */
	public FRCEnterPlateDetails(WebDriver driver) {
		super(driver);
		
	}

	//private static final String plateNoId = "plateNumber";
   // private static final String nextBtnXpath = "password";
    //private static final String weTermsAndConditionsId = "tnc";
     
	
		 
	    @FindBy(id="plateNumber")
	    private WebElement plateNo; 
	    
	    
	    @FindBy(xpath="//button[text()='Next']")
	    private WebElement nextBtnXpath; 
	    
	    
	    @FindBy(id="formly_2_checkbox-label-with-action_termsAndConditions_1")
	    public WebElement weTermsAndConditionsId; 
	    
	    public void setTermsnConditions(boolean checked) {

	        boolean status = weTermsAndConditionsId.isSelected();
	        
	        if (status != checked) {
	        	 JavascriptExecutor js = (JavascriptExecutor)driver; 
	             js.executeScript("arguments[0].click();", weTermsAndConditionsId); 
	        }
	        
	       
	    }
	    
	    public FRCReportPage pressNextButton() {
	        
	        if(nextBtnXpath.isEnabled()) {
	        	nextBtnXpath.click();
	        } else {
	            System.out.println("FRC Enter plate number screen - Next Button not enabled");
	        }
			return PageFactory.initElements(driver, FRCReportPage.class);
	    }
	    
	    public void setPlateNumber(String pltNo) {
	    	
	    	try{
	    		explicitFluentWait(plateNo);
	    		plateNo.sendKeys(pltNo);
	    	}
	    	catch (Exception e) {
	            e.printStackTrace();
	        }
	    	
	    }
	    
	    @FindBy(id="plateNumberHint")
	    private WebElement plateNoHelpTextId;
	    
	    @FindBy(xpath="//a[text()='Terms and Conditions']")
	    private WebElement termsNCondLink;
	    
	    @FindBy(xpath="//div[@class='recaptcha-checkbox-checkmark']")
	    public WebElement captchaCheckBox;
	    
	    public String openTermsAndConditionsText() {
	    	
	    	String tncText = null;
	    	
	    	try{
	    		termsNCondLink.click();
	    		//driver.wait();
	    		driver.switchTo().activeElement();
	    		tncText=getBodyText();
	    		driver.findElement(By.xpath("//button[text()='Close']")).click();
	    		driver.switchTo().defaultContent();
	    		
	    		
	    	}
	    	catch (NoSuchElementException e) {
	    		 e.printStackTrace();
	        }
	    	
	    	return tncText;
	    	
	    }
	    
	    @FindBy(css="iframe[title='recaptcha widget']") 
	    private WebElement frameEle;
	    
	    public boolean selectCaptchBox() {
	    	
	    	boolean captchBox = false;
	    	
	    	try{
	    		
	    		driver.switchTo().frame(frameEle);	    		
	    		if(captchaCheckBox.isDisplayed())
	    			captchBox=true;
	    		captchaCheckBox.click();  			
	    		driver.switchTo().defaultContent();
	    		
	    		
	    	}
	    	catch (NoSuchElementException e) {
	            e.printStackTrace();
	        }
	    	 return captchBox;
	    	    	
	    }
	    public String getPlateNoFieldHint() {	    	
	    	
	    		return plateNoHelpTextId.getText();
	 	    	
	    }

}
