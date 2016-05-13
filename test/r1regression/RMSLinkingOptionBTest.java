package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import SNSWWebPages.LicenceDetailsOptionBPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ManageRMSPage;
import SNSWWebPages.MyServicesPage;
import SNSWWebPages.RMSLinkSucessMsgPage;
import SNSWWebPages.RMSUnlinkSucessPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.VerifyPassword;
import TestHelpers.Utilities;

public class RMSLinkingOptionBTest extends R1RegressionTestBase{
	
		
		@Test
		public void rmsLinkOptionB() throws IOException
		{
		driver.get(env.getLoginURL());
		String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 3);
		System.out.println("Data length:"+data.length);
		//Login to the application with valid credentials
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
		
		//click the MyServices tab on the Dash board
		MyServicesPage ServicesPg = dashboardSrn.pressmyServicesTab();
		
		//Click Connect Button on My Services
		LicenceDetailsOptionBPage LicDetails = ServicesPg.PressRMSConnectBtn();
		
		//Enter Last Name,Card id,Back of Card Number in the License Details Page and Click Next Button
		RMSLinkSucessMsgPage linkSucess = LicDetails.RMSLinkOptionB(data[7],data[5],data[6]);
		
		//Verifying the Successfully Linked  Message
		linkSucess.explicitFluentWait(linkSucess.SucessLinkLicenceDetailsMsg);
		assertTrue(linkSucess.isElementExist(linkSucess.SucessLinkLicenceDetailsMsg));
		
		//Click Next Button on the Success Page
		MyServicesPage servicesPg1 = linkSucess.PressNextBtnSucessMsgScrn();
		
		//Click Manage Button
		ManageRMSPage manageRMS = servicesPg1.PressRMSManageBtn();
		
		//Verify residential and Mailing Address
		manageRMS.explicitFluentWait(manageRMS.ResAddress);
		Assert.assertEquals(manageRMS.ResAddress.getText(),data[12]);
		manageRMS.explicitFluentWait(manageRMS.MailAddres);
		Assert.assertEquals(manageRMS.MailAddres.getText(),data[13]);
		
		//Click on Unlink Link
		VerifyPassword VerifyPass = manageRMS.unlinkRMS();
		
		//Enter Password and Verify
		RMSUnlinkSucessPage unlinkSucess = VerifyPass.EnterPwdUnink(data[2]);
		
		//Verifying the Successfully UnLinked  Message
		unlinkSucess.explicitFluentWait(unlinkSucess.UnlinkSucessMsg);
		assertTrue(unlinkSucess.isElementExist(unlinkSucess.UnlinkSucessMsg));
			
		}
		
		
}	
		
			

