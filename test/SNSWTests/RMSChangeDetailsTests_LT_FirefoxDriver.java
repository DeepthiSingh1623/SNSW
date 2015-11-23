/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import TestHelpers.Environment;
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
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Kurt
 */
public class RMSChangeDetailsTests_LT_FirefoxDriver {
    
    
    
    
    static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;
    static Date today;
    static String filePathSnapshot;
    
    public RMSChangeDetailsTests_LT_FirefoxDriver() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        env = new Environment(Environment.Env.LTCS6);
        today = Calendar.getInstance().getTime();
        
        DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        filePathSnapshot = ".\\results\\RMSChangeDetails_FireFox\\LTCS6\\" + df.format(today);
        new File(filePathSnapshot).mkdirs();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        wdwait = new WebDriverWait(driver, 60);
    }
    
    @After
    public void tearDown() {
        //wdwait = null;
        //driver.close();
        //driver = null;
    }


    
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC20_AU001_checkRMSChangeDetailsElements() {
        String filepath = filePathSnapshot + "\\UC20_AU001_checkRMSChangeDetailsElements_";
        RMSChangeDetailsTests.UC20_AU001_checkRMSChangeDetailsElements(driver, wdwait, env, filepath);
    }
}
