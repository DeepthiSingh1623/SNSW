package r1regression;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import SNSWWebPages.LoginPage;
import SNSWWebPages.ServiceNSWDashboardPage;
import TestHelpers.Utilities;

public class UpdateSecQns extends R1RegressionTestBase {
  @Test
  public void updateSecurityQuestionsTest() {
	  try {
		String[] data = Utilities.getXLDataLatestByRow("test\\dlpregression\\testdata.xlsx", "R1 Regression", 2);
	//System.out.println("data length:"+Arrays.deepToString(data));
	//System.out.println("data length:"+data.length);
	for(int i=0;i<data.length;i++)
				System.out.println("Data values: "+data[i]);
		driver.get(env.getLoginURL());
		LoginPage loginSrn =  PageFactory.initElements(driver, LoginPage.class);
		loginSrn.loginMain(data[1], data[2]);
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
