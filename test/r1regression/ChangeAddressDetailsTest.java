package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import SNSWWebPages.ChangeAddressAdditionalPage;
import SNSWWebPages.ChangeAddressConfirmPage;
import SNSWWebPages.ChangeAddressPage;
import SNSWWebPages.ChangeAddressSucessPage;
import SNSWWebPages.GuestAddressChangePage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.SelectOptionAddressChange;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.TransAuthentication;
import TestHelpers.Utilities;

public class ChangeAddressDetailsTest extends R1RegressionTestBase {
	  private static final String Add = null;

	@Test
	  public void ChangeAddressDetails() throws IOException {
		  
		  driver.get(env.getLoginURL());
			String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 7);
			System.out.println("Data length:"+data.length);
			//Login to the application with valid credentials
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
			
			
			driver.get(env.getRMSChangeDetailsURL());
			SelectOptionAddressChange selectOptAddChng = PageFactory.initElements(driver, SelectOptionAddressChange.class);
			
			//select first radio button 
			ChangeAddressPage chgAddPg = selectOptAddChng.pressAddChangeSelectOption();
			
			TransAuthentication TransAuth = PageFactory.initElements(driver, TransAuthentication.class);
			TransAuth.pressLoginBtnRedirects();
			
			selectOptAddChng = PageFactory.initElements(driver, SelectOptionAddressChange.class);
			
			//select first radio button 
			ChangeAddressPage AddChgPg = selectOptAddChng.pressAddChangeSelectOption();
			
			//DS ---
			AddChgPg.enterChangedAddress("Unit 6");
			ChangeAddressAdditionalPage enterAddress = AddChgPg.enterChangedAddressNextBtn();
						
			//Press Next Button on Additional Page
			ChangeAddressConfirmPage ConfirmPg = enterAddress.pressAddressChangedAdditionalNextBtn();
			
			String expectedResAdd = ConfirmPg.getTextAddList();
			System.out.println("Expected Results"+ expectedResAdd);
			//Click and T & C and Click Submit on Confirmation Page is displayed
			ChangeAddressSucessPage AddChgSucessPg = ConfirmPg.pressAddChngdditionalSubmitBtn();
			
			//Address Changed Message Verification
			AddChgSucessPg.explicitFluentWait(AddChgSucessPg.AddChangeSucessMessage);
			assertTrue(AddChgSucessPg.isElementExist(AddChgSucessPg.AddChangeSucessMessage)); 
			
			//Success Page - Verification //Verify residential and Mailing Address
			AddChgSucessPg.isElementExist(AddChgSucessPg.ChangedResidentialAddress);
			String chngResAdd = AddChgSucessPg.ChangedResidentialAddress.getText();
			System.out.println("Actual Results"+ chngResAdd);
			
			AddChgSucessPg.isElementExist(AddChgSucessPg.ChangedMailingAddress);
			assertTrue(chngResAdd.equalsIgnoreCase(expectedResAdd));
						
			
			
				
			
}

	

	}
