package SNSWTests;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import SNSWWebPages.CreateAccountPage;
import TestHelpers.Environment;

public class CheckRegoTest {
	
	static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;
    static Date today;
    static String filePathSnapshot;

    
    
    @BeforeClass
    public static void setUpClass() {
        env = new Environment(Environment.Env.IT2);
        today = Calendar.getInstance().getTime();
        
        DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        filePathSnapshot = ".\\results\\CheckRego_IE\\IT2\\" + df.format(today);
        new File(filePathSnapshot).mkdirs();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.ie.driver", "C:\\protractorTest\\drivers\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(caps);
        wdwait = new WebDriverWait(driver, 60);
    }
    
    @After
    public void tearDown() {
        wdwait = null;
        driver.close();
        driver = null;
    }

    
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU001_checkForErrorMessages() {
        String filepath = filePathSnapshot + "\\UC01_AU001_checkForErrorMessages_";
        driver.get(env.getCheckRegoURL());
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        WebElement plateNo=driver.findElement(By.id("plateNumber"));
        plateNo.sendKeys("GN170");
;     
    }
    

}
