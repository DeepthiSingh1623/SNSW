package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.EditSecurityQuestionsPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.SettingsPage;
import SNSWWebPages.VerifyPassword;
import TestHelpers.Utilities;


public class UpdateSecurityQTest extends R1RegressionTestBase
{
	@Test
	public void verifyUpdateQuestionsPage() throws IOException
	{
	driver.get(env.getLoginURL());
	String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 2);
	//Login to the application with valid credentials
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1],data[2]);
	
	//click the Settings tab on the Dash board
	SettingsPage settingsPage=dashboardSrn.pressSettingsTab();
	
	//Press Edit Button 
	VerifyPassword verPwd  = settingsPage.PressSecurityEditBtn();
	
	//Enter Password and Verify 
	
	EditSecurityQuestionsPage editQScrn = verPwd.verifyPwdBtn(data[2]);
	
	//Verify user is able to edit below mentioned questions and Click Save Icon
	editQScrn.EditQuestions("Test1", "Test2", "Test3");
	
	//Verifying the result page message :The edits are saved
	settingsPage.explicitFluentWait(settingsPage.SavedSecurityMsg);
	assertTrue(settingsPage.isElementExist(settingsPage.SavedSecurityMsg));
	
	
	}
}
