/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

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
    }
    
    @After
    public void tearDown() {
    }

    
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void checkForErrorMessages() {
        System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer32.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(caps);
        wdwait = new WebDriverWait(driver, 60);

        CreateAccountTests.checkForErrorMessages(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void verifyTCMandatory() {
        System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer32.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(caps);
        wdwait = new WebDriverWait(driver, 60);

        CreateAccountTests.verifyTCMandatory(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void invalidEmailAddress1() {
        System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer32.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(caps);
        wdwait = new WebDriverWait(driver, 60);

        CreateAccountTests.invalidEmailAddress1(driver, wdwait, env);
    }
    
}
