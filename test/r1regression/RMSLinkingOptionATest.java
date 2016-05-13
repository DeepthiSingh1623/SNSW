package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import SNSWWebPages.LicenceDetailsOptionAPage;
import SNSWWebPages.LicenceDetailsOptionBPage;
import SNSWWebPages.LicenceDetailsOptionCPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ManageRMSPage;
import SNSWWebPages.MyServicesPage;
import SNSWWebPages.RMSLinkSucessMsgPage;
import SNSWWebPages.RMSUnlinkSucessPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.VerifyPassword;
import TestHelpers.Utilities;

public class RMSLinkingOptionATest extends R1RegressionTestBase{

		
	@Test
	public void rmsLinkOptionB() throws IOException
	{
	driver.get(env.getLoginURL());
	String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 4);
	//Login to the application with valid credentials
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
	
	//click the MyServices tab on the Dash board
	MyServicesPage ServicesPg = dashboardSrn.pressmyServicesTab();
	
	//Click Connect Button on My Services
	LicenceDetailsOptionBPage licDetails = ServicesPg.PressRMSConnectBtn();

	//Click Try Linking PageC
	LicenceDetailsOptionCPage licDetailsC = licDetails.pressTrylinkingOptionC();
	
	//Click Try Linking PageA
	LicenceDetailsOptionAPage licDetailsA =licDetailsC.pressTrylinkingOptionA();
	
	//	Enter Card Number and Password,Terms and Condition and Next Button
	RMSLinkSucessMsgPage linkSucessMsg = licDetailsA.enterRtaLicDetails(data[3], data[4]);

	//Assert Success Message	
	linkSucessMsg.explicitFluentWait(linkSucessMsg.SucessLinkLicenceDetailsMsg);
	assertTrue(linkSucessMsg.isElementExist(linkSucessMsg.SucessLinkLicenceDetailsMsg));
	
	
	//Click Next Button on the Success Page
	MyServicesPage servicesPg1 = linkSucessMsg.PressNextBtnSucessMsgScrn();
			
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
