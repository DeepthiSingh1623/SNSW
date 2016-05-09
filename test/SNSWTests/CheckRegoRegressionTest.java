package SNSWTests;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.FRCEnterPlateDetails;
import SNSWWebPages.FRCReportPage;


public class CheckRegoRegressionTest extends SNSWTestBase{
	
	 static String filePathSnapshot;
	 
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void viewFreeRegoReport_04() {
        String filepath = filePathSnapshot + "\\UC01_AU001_checkForErrorMessages_";
        driver.get(env.getCheckRegoURL());
        System.out.println("Driver title from tets case:"+driver.getTitle());
        FRCEnterPlateDetails epd = PageFactory.initElements(driver, FRCEnterPlateDetails.class);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        
             
        epd.setPlateNumber("GN170");
        epd.setTermsnConditions(true);
                       
        //This we are using toto manully select captch during this time. Once captch has been switched OFF, we can remove this line.
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       FRCReportPage report=epd.pressNextButton();
       report.waitforPageLoad();
       String reportcont=report.getFRCReportContent();
       assertTrue("Tare weight didnt match",  reportcont.contains("1,240 kg"));
       assertTrue("CTP insurance date doesnt match",  reportcont.contains("15/03/2006"));
       assertTrue("CTP Insurance company doesnt match",  reportcont.contains("Allianz"));
       assertTrue("CTP insurance code doesnt match",  reportcont.contains("32"));
       assertTrue("Concessions message doenst match",  reportcont.contains("There are no concessions on this registration."));
       assertTrue("Registration expiry date doesnt natch",  reportcont.contains("15/03/2006"));
       
       
    }
    FRCEnterPlateDetails epd;
    
    @Test
    public void frcTransactionStartPage_01() {
    	
    	driver.get(env.getCheckRegoURL());
    	epd = PageFactory.initElements(driver, FRCEnterPlateDetails.class);
        env.takeSnapshot(driver, "frcTransactionStartPage_01_01.png");
        assertEquals("NSW Plate Number hint text do not match","Enter the vehicle plate number without spaces or dots",epd.getPlateNoFieldHint());
        assertTrue("Heading Text not found!", epd.isTextPresentOnScreen("Registration check").size()>0);   
        assertTrue("Step No Text not found!", epd.isTextPresentOnScreen("Step 1/3").size()>0);
        assertTrue("Page Heading Text not found!", epd.isTextPresentOnScreen("Enter plate number").size()>0);
        assertTrue("Plate no label not found!", epd.isTextPresentOnScreen("NSW plate number").size()>0);
        
        assertTrue("Terms and Conditions Text modal has not been displayed",epd.openTermsAndConditionsText().contains("Terms & Conditions: Free registration check"));
        assertNotNull("Terms and Conditions checkbox has not been displayed",epd.weTermsAndConditionsId);
        
        assertTrue("Capcha has not been displayed",epd.selectCaptchBox());
        
       
    	
    }
    @Test
    public void tncSelected_02() {
    	
    	driver.get(env.getCheckRegoURL());
    	epd = PageFactory.initElements(driver, FRCEnterPlateDetails.class);
        env.takeSnapshot(driver, "frcTransactionStartPage_01_01.png");
        epd.setPlateNumber("GN170");
        epd.pressNextButton();
        
        assertTrue("TnC field message has not been found", epd.isTextPresentOnScreen("Please accept the Terms and Conditions to continue").size()>0);
        assertTrue("Global error message message has not been found", epd.getGlobalErrorMsgText().contains("Please check the following 2 errors:"));
        assertTrue("TnC mandatory message has not been found", epd.getGlobalErrorMsgText().contains("Terms and Conditions: Please accept the Terms and Conditions to continue"));
        assertTrue("Captcha message has not been found", epd.getGlobalErrorMsgText().contains("Captcha: This field is required"));
    	
    }

}
