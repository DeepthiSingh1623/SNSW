package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import SNSWWebPages.LicenceDetailsOptionBPage;
import SNSWWebPages.LicenceDetailsOptionCPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ManageRMSPage;
import SNSWWebPages.MyServicesPage;
import SNSWWebPages.RMSLinkSucessMsgPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import TestHelpers.Utilities;

public class LinkingOptionCTest extends R1RegressionTestBase{
  @Test
  public void testLinkingOptionC() throws IOException {
	  
	  driver.get(env.getLoginURL());
		String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 5);
		System.out.println("Data length:"+data.length);
		//Login to the application with valid credentials
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
		
		//click the MyServices tab on the Dash board
		MyServicesPage ServicesPg = dashboardSrn.pressmyServicesTab();
		
		//Click Connect Button on My Services
		LicenceDetailsOptionBPage licDetails = ServicesPg.PressRMSConnectBtn();
		
		//Click Try Linking PageC
		LicenceDetailsOptionCPage licDetailsC = licDetails.pressTrylinkingOptionC();
		
		licDetailsC.enterOptionCDetails(data[8], data[7], data[9], data[10], data[11], data[3]);
		RMSLinkSucessMsgPage linkSucc=licDetailsC.pressNextBtn();
		
		linkSucc.explicitFluentWait(linkSucc.SucessLinkLicenceDetailsMsg);
		assertTrue(linkSucc.isElementExist(linkSucc.SucessLinkLicenceDetailsMsg));
		
		//Click Next Button on the Success Page
		MyServicesPage servicesPg1 = linkSucc.PressNextBtnSucessMsgScrn();
		
		//Click Manage Button
		ManageRMSPage manageRMS = servicesPg1.PressRMSManageBtn();
		
		//Verify residential and Mailing Address
		manageRMS.explicitFluentWait(manageRMS.ResAddress);
		Assert.assertEquals(manageRMS.ResAddress.getText(),data[12]);
		manageRMS.explicitFluentWait(manageRMS.MailAddres);
		Assert.assertEquals(manageRMS.MailAddres.getText(),data[13]);
		
  }
}