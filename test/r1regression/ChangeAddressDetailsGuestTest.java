package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.ChangeAddressAdditionalPage;
import SNSWWebPages.ChangeAddressConfirmPage;
import SNSWWebPages.ChangeAddressPage;
import SNSWWebPages.ChangeAddressSucessPage;
import SNSWWebPages.GuestAddressChangePage;
import SNSWWebPages.GuestConfirmPage;
import SNSWWebPages.GuestLoginOptionBLicDetails;
import SNSWWebPages.LicenceDetailsOptionBPage;
import SNSWWebPages.SelectOptionAddressChange;
import SNSWWebPages.TransAuthentication;
import TestHelpers.Utilities;

public class ChangeAddressDetailsGuestTest extends R1RegressionTestBase {
	  private static final String Add = null;

	@Test
	  public void ChangeAddressDetailsGuest() throws IOException {
		  
		  //driver.get(env.getLoginURL());
			String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 8);
			System.out.println("Data length:"+data.length);
			
			//Directly entered the URL Change Address
			driver.get(env.getRMSChangeDetailsURL());
			SelectOptionAddressChange selectOptAddChng = PageFactory.initElements(driver, SelectOptionAddressChange.class);
			
			//select first radio button 
			GuestAddressChangePage guestchgAddPg = selectOptAddChng.pressGuestAddChangeSelectOption();
			
			//Login as a guest into to the application with valid credentials
			TransAuthentication transAuth = PageFactory.initElements(driver, TransAuthentication.class);
			transAuth.pressContAsGuestBtn();
			
			//Press Login as Guest Button		
			//GuestLoginOptionBLicDetails licOptionB = transAuth.pressContAsGuestBtn();
			
			GuestLoginOptionBLicDetails licOptionB = PageFactory.initElements(driver, GuestLoginOptionBLicDetails.class);
			
			//Enter Option B Details
			GuestAddressChangePage chgAddPg1 = licOptionB.addChangeAsGuest(data[7],data[5],data[6]);
					
			chgAddPg1.enterGuestChangedAddress("Unit 8");
			GuestConfirmPage confirmPg = chgAddPg1.enterGuestChangedAddressNextBtn();
			
			
			confirmPg = PageFactory.initElements(driver, GuestConfirmPage.class);
			String expectedResAdd = confirmPg.getTextAddList();
			System.out.println("Expected Results"+ expectedResAdd);
			
			
			confirmPg = PageFactory.initElements(driver, GuestConfirmPage.class);
			//Click and T & C and Click Submit on Confirmation Page is displayed
			ChangeAddressSucessPage AddChgSucessPg = confirmPg.pressAddChngdditionalSubmitBtn();
			
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
