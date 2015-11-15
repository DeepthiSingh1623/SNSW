/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import static SNSWTests.CreateAccountTests_LT_FirefoxDriver.driver;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Kurt
 */
public class CreateAccountTests_LT_ChromeDriver {
    
    
    static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;

    
    
    public CreateAccountTests_LT_ChromeDriver() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        env = new Environment(Environment.Env.LTCS6);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
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

        CreateAccountTests.UC01_AU001_checkForErrorMessages(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU002_verifyTCMandatory() {

        CreateAccountTests.UC01_AU002_verifyTCMandatory(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU003_invalidEmailAddress1() {

        CreateAccountTests.UC01_AU003_invalidEmailAddress1(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU004_invalidEmailAddress2() {

        CreateAccountTests.UC01_AU004_invalidEmailAddress2(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU005_invalidEmailAddress3() {

        CreateAccountTests.UC01_AU005_invalidEmailAddress3(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU006_invalidEmailAddress4() {

        CreateAccountTests.UC01_AU006_invalidEmailAddress4(driver, wdwait, env);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU007_invalidEmailAddress5() {

        CreateAccountTests.UC01_AU007_invalidEmailAddress5(driver, wdwait, env);
    }
}