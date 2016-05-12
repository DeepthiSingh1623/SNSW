package r1regression;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import SNSWWebPages.FeedbackPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import TestHelpers.Utilities;

	
	public class FeedBackTest extends R1RegressionTestBase{
		FeedbackPage feedbackSrn;
		@Test
		public void testFeedBackVerify() throws IOException
		{   
			//Load the URL
			driver.get(env.getLoginURL());
			String[] data;
			
			data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 1);
			
			//Login to the application with valid credentials
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			ServiceNSWDashboardPage dashboardSrn=login.loginMain(data[1], data[2]);
			
			//click the feedback button on the Dash board
			feedbackSrn=dashboardSrn.pressFeedbackButton();
	        
			//Verifying if the below elements exits in the the Feedback page
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.FeedBackpageTitle));
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.FeedBackPrivacyStatement));
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.Submit));
		}
		
}
