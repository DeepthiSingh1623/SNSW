package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.ChangeAddressAdditionalPage;
import SNSWWebPages.ChangeAddressConfirmPage;
import SNSWWebPages.ChangeAddressPage;
import SNSWWebPages.ChangeAddressSucessPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.SelectOptionAddressChange;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.TransAuthentication;
import TestHelpers.Utilities;

public class ChangeMobileAndEmailTest extends R1RegressionTestBase 
{
	private static final String Add = null;

	@Test
	public void ChangeAddressDetails() throws IOException
	{
		  
		    driver.get(env.getLoginURL());
			String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 9);
			System.out.println("Data length:"+data.length);
			//Login to the application with valid credentials
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
			
			driver.get(env.getRMSChangeDetailsURL());
			SelectOptionAddressChange selectOptAddChng = PageFactory.initElements(driver, SelectOptionAddressChange.class);
			
			//select first radio button 
			ChangeAddressPage chgAddPg = selectOptAddChng.pressAddChangeSelectOption();
			
			TransAuthentication transAuth = PageFactory.initElements(driver, TransAuthentication.class);
			transAuth.pressLoginBtnRedirects();
			
			selectOptAddChng = PageFactory.initElements(driver, SelectOptionAddressChange.class);
			
			//select first radio button 
			ChangeAddressPage addChgPg = selectOptAddChng.pressAddChangeSelectOption();
			
			ChangeAddressAdditionalPage chgAddPage = addChgPg.enterChangedAddressNextBtn();
						
			//Press Next Button on Additional Page
			ChangeAddressConfirmPage  confirmPg= chgAddPage.pressMobileAndEmailChangeNextBtn(data[14], data[15]);
			
			confirmPg = PageFactory.initElements(driver, ChangeAddressConfirmPage.class);
			
			//capturing the Changed Email and Mobile Numbers
			String expectedChangeEmailId = confirmPg.getChangedEmailid();
			System.out.println("Expected Results of Email Id Changed "+ expectedChangeEmailId);
			
			String expectedChangeMobileNum = confirmPg.getChangedMobileNum();
			System.out.println("Expected Results of Mobile Number Changed "+ expectedChangeMobileNum);
			
			//Click and T & C and Click Submit on Confirmation Page is displayed
			ChangeAddressSucessPage AddChgSucessPg = confirmPg.pressAddChngdditionalSubmitBtn();
			
			//Contacts Changed Message Verification
			AddChgSucessPg.explicitFluentWait(AddChgSucessPg.AddChangeSucessMessage);
			assertTrue(AddChgSucessPg.isElementExist(AddChgSucessPg.AddChangeSucessMessage)); 
			
			//Success Page - Verification //Verify Email and Mobile 
			AddChgSucessPg.isElementExist(AddChgSucessPg.changedEmailId);
			String chngEmailid = AddChgSucessPg.changedEmailId.getText();
			System.out.println("Actual Results of Email Id Changed "+ chngEmailid);
			
			AddChgSucessPg.isElementExist(AddChgSucessPg.changedMobileNum);
			String chngMobNum = AddChgSucessPg.changedMobileNum.getText();
			System.out.println("Actual Results of Mobile Num Changed "+ chngMobNum);
			
			//verifying the email id is changed as expected
			assertTrue(chngEmailid.equalsIgnoreCase(chngEmailid));
			
			//verifying the mobile number is changed as expected
			assertTrue(chngMobNum.equalsIgnoreCase(expectedChangeMobileNum));
						
			
			

}
}