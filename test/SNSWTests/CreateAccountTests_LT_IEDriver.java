/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import static SNSWTests.CreateAccountTests_LT_ChromeDriver.driver;
import static SNSWTests.CreateAccountTests_LT_FirefoxDriver.driver;
import static SNSWTests.CreateAccountTests_LT_FirefoxDriver.env;
import TestHelpers.Environment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Kurt
 */
public class CreateAccountTests_LT_IEDriver {

    
    static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;

    
    
    public CreateAccountTests_LT_IEDriver() {
        env = new Environment(Environment.Env.LTCS6);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer32.exe");
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
    public void checkForErrorMessages() {

        CreateAccountTests.checkForErrorMessages(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void verifyTCMandatory() {

        CreateAccountTests.verifyTCMandatory(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress1() {

        CreateAccountTests.invalidEmailAddress1(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress2() {

        CreateAccountTests.invalidEmailAddress2(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress3() {

        CreateAccountTests.invalidEmailAddress3(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress4() {

        CreateAccountTests.invalidEmailAddress4(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress5() {

        CreateAccountTests.invalidEmailAddress5(driver, wdwait, env);
    }
    
}
