package SNSWWebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemeritPointsPage extends DriverPage {

	public DemeritPointsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Finish']")
	public WebElement finishBtn;
	
		
	@FindBy(xpath="//button[text()='Do more online']")
	public WebElement doneBtn;
	
	
	@FindBy(xpath="//h2[@title='2. Demerit points']")
	public WebElement pageTitle;
	
	@FindBy(xpath="//table[@class='table table-bordered']")
	public WebElement pointTable;
	
	public void pressFinishBtn()  {
		// TODO Auto-generated method stub
		
		finishBtn.click();
		//Thread.sleep(2000);
		explicitFluentWait(driver.switchTo().activeElement());
		driver.switchTo().activeElement();
		doneBtn.click();
	    driver.switchTo().defaultContent();
	
	}
	
	public String getDemeritPoints(){
		explicitFluentWait(finishBtn);
		List<WebElement> elem= isTextPresentOnScreen("Total demerit points:");
		System.out.println("Element size:"+elem.size());
		WebElement points = null;
		if(elem.size()>0){
			points=elem.get(0).findElement(By.xpath("../td[2]"));
			System.out.println(points.getText());
		}
		return points.getText();
		
	}
	
	public String getDemeritPointsForSingleLicence(){
		
	return driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]")).getText();
		
	}
	
	public String getDemeritPointsForSecondInDualLicence(){
		
		return pointTable.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]")).getText();
			
		}

}
