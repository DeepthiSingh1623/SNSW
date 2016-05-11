package r1regression;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.FeedbackPage;
import SNSWWebPages.LoginPage;
import SNSWWebPages.ServiceNSWDashboardPage;

	
	public class SNSWFeedBackTest extends R1RegressionTestBase{
		
		@Test
		public void FeedBackVerify()
		{   
			//Load the URL
			driver.get("https://it2-snsw.cs31.force.com/MyServiceNSW");
						
			//Login to the application with valid credentials
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			ServiceNSWDashboardPage dashboardSrn=login.loginMain("test1623@mailinator.com", "Snsw123#");
			
			//click the feedback button on the Dash board
			FeedbackPage feedbackSrn=dashboardSrn.pressFeedbackButton();
	        
			//Verifying if the below elements exits in the the Feedback page
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.FeedBackpageTitle));
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.FeedBackPrivacyStatement));
			assertTrue(feedbackSrn.isElementExist(feedbackSrn.Submit));
		}

	}
