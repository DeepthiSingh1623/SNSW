package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.EditSecurityQuestionsPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import SNSWWebPages.SettingsPage;
import SNSWWebPages.VerifyPassword;


public class SNSWEditSecurityQTest extends R1RegressionTestBase
{
	@Test
	public void VerifyEditQuestionsPage()
	{
	driver.get("https://it2-snsw.cs31.force.com/MyServiceNSW");
				
	//Login to the application with valid credentials
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	ServiceNSWDashboardPage dashboardSrn=login.loginMain("test1623@mailinator.com","Snsw123#");
	
	//click the Settings tab on the Dash board
	SettingsPage settingsPage=dashboardSrn.pressSettingsTab();
	
	//Press Edit Button 
	VerifyPassword verPwd  = settingsPage.PressSecurityEditBtn();
	
	//Enter Password and Verify 
	
	EditSecurityQuestionsPage editQScrn = verPwd.verifyPwdBtn("Snsw123#");
	
	//Verify user is able to edit below mentioned questions and Click Save Icon
	editQScrn.EditQuestions("Test1", "Test2", "Test3");
	
	//Verifying the result page message :The edits are saved
	assertTrue(settingsPage.isElementExist(settingsPage.SavedSecurityMsg));
	
	
	
	
	
	
	}
}
