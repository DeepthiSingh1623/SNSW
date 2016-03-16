package TestHelpers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import SNSWWebPages.DriverPage;

import java.io.File;


public class Screenshot extends TestListenerAdapter {
	
	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = DriverPage.getDriverInstance();
		File scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		String destDir = "target/testng-reports/screenshots";
		new File(destDir).mkdirs();
		String destFile = result.getName() + "_"+ dateFormat.format(new Date()) + ".png";
 
        try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=../screenshots/" + destFile + ">Screenshot</a>");
	}


	@Override

	public void onTestSkipped(ITestResult result) {

	// will be called after test will be skipped

	}

	@Override

	public void onTestSuccess(ITestResult result) {

	// will be called after test will pass 

	}

	

}
