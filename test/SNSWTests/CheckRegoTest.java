package SNSWTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CheckRegoTest extends SNSWTestBase{
	
	 static String filePathSnapshot;
	
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void testFreeRegoReport() {
        String filepath = filePathSnapshot + "\\UC01_AU001_checkForErrorMessages_";
        driver.get(env.getCheckRegoURL());
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        WebElement plateNo=driver.findElement(By.id("plateNumber"));
        plateNo.sendKeys("GN170");
        //WebElement chkBox=driver.findElement(By.cssSelector("input[id=formly_1_checkbox-label-with-action_termsAndConditions_1][type=checkbox]"));
        WebElement chkBoxs=driver.findElement(By.id("formly_2_checkbox-label-with-action_termsAndConditions_1"));
        JavascriptExecutor js = (JavascriptExecutor)driver; 
        js.executeScript("arguments[0].click();", chkBoxs);
        
        //This we are using toto manully select captch during this time. Once captch has been switched OFF, we can remove this line.
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        WebElement nextBtn=driver.findElement(By.xpath("//button[text()='Next']"));
        nextBtn.click();
        
    
    }
    

}
