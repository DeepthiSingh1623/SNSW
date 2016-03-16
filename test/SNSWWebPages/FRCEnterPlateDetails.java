package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FRCEnterPlateDetails extends DriverPage{
	
	
	private WebDriver driver;




	/**
	 * @param driver
	 */
	public FRCEnterPlateDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	private static final String plateNoId = "plateNumber";
    private static final String nextBtnXpath = "password";
    private static final String weTermsAndConditionsId = "tnc";
     
	
		 
	    
	    public void setTermsnConditions(boolean checked) {
	        WebElement a = this.driver.findElement(By.id(weTermsAndConditionsId));
	        boolean status = a.isSelected();
	        
	        if (status != checked) {
	            a.click();
	        }
	    }
	    
	    public void pressNextButton() {
	        WebElement a = this.driver.findElement(By.xpath(nextBtnXpath));
	        if(a.isEnabled()) {
	            a.click();
	        } else {
	            System.out.println("FRC Enter plate number screen - Next Button not enabled");
	        }
	    }
	    
	    public void setPlateNumber(String pltNo) {
	    	
	    	try{
	    		WebElement a = this.driver.findElement(By.id(plateNoId));
	    		a.sendKeys(pltNo);
	    	}
	    	catch (NoSuchElementException e) {
	            e.printStackTrace();
	        }
	    	
	    }

}
