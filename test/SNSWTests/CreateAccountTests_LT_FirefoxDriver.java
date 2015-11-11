/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import static SNSWTests.SNSWSeleniumTests.driver;
import static SNSWTests.SNSWSeleniumTests.env;
import SNSWWebPages.CreateAccountPage;
import TestHelpers.Environment;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 *
 * @author Kurt
 */
public class CreateAccountTests_LT_FirefoxDriver {
    
    
    static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;

    
    
    public CreateAccountTests_LT_FirefoxDriver() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void checkForErrorMessages() {
        driver = new FirefoxDriver();
        wdwait = new WebDriverWait(driver, 30);

        CreateAccountTests.checkForErrorMessages(driver, wdwait, env);
    }
}
