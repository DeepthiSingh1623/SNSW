package r1regression;

import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SNSWWebPages.DemeritPointsPage;
import SNSWWebPages.DemeritsTAndC;
import SNSWWebPages.LoginPage;

import SNSWWebPages.TransAuthentication;
import TestHelpers.Utilities;

public class CheckDemeritsTest extends R1RegressionTestBase{
  @Test
  public void checkDemritPointsTest() throws IOException {
	  
	  driver.get(env.getCheckDemeritURL());
		String[] data = Utilities.getXLDataLatestByRow("test\\r1regression\\testdata.xlsx", "R1 Regression", 6);
		//Login to the application with valid credentials
		TransAuthentication transAuth = PageFactory.initElements(driver, TransAuthentication.class);
		LoginPage login=transAuth.pressLoginBtn();
		DemeritsTAndC tandcpage=login.demeritsLogin(data[1], data[2]);
		tandcpage.selectTermsAndConditions();
		DemeritPointsPage dmPage=tandcpage.pressNextBtn();
		
		assertTrue(dmPage.getDemeritPoints().contains("0"));
		System.out.println("Demerit points text:"+dmPage.pointTable.getText());
		assertTrue(dmPage.pageTitle.isDisplayed());
		assertTrue(dmPage.pointTable.getText().contains("Licence class C: CAR UNRESTRICTED"));
		assertTrue(dmPage.pointTable.getText().contains("Class C has a maximum of 13 demerit points"));
		//assertTrue(dmPage.pointTable.getText().contains("Licence class R: UNRESTRICTED RIDER OF CYCLE"));
		//assertTrue(dmPage.pointTable.getText().contains("Class R has a maximum of 13 demerit points"));
		assertTrue(dmPage.pointTable.getText().contains("Total demerit points:"));
		
		
		assertTrue(dmPage.getDemeritPointsForSingleLicence().contains("0"));
		//assertTrue(dmPage.getDemeritPointsForSecondInDualLicence().contains("0"));
		
		dmPage.pressFinishBtn();
		
		
	
  }
}
