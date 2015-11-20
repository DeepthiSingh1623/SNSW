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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    static Date today;
    static String filePathSnapshot;

    
    
    public CreateAccountTests_LT_ChromeDriver() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        env = new Environment(Environment.Env.LTCS6);
        today = Calendar.getInstance().getTime();
        
        DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        filePathSnapshot = ".\\results\\CreateAccount_Chrome\\LTCS6\\" + df.format(today);
        new File(filePathSnapshot).mkdirs();
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
        String filepath = filePathSnapshot + "\\UC01_AU001_checkForErrorMessages_";
        CreateAccountTests.UC01_AU001_checkForErrorMessages(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU002_verifyTCMandatory() {
        String filepath = filePathSnapshot + "\\UC01_AU002_verifyTCMandatory_";
        CreateAccountTests.UC01_AU002_verifyTCMandatory(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU003_invalidEmailAddress1() {
        String filepath = filePathSnapshot + "\\UC01_AU003_invalidEmailAddress1_";
        CreateAccountTests.UC01_AU003_invalidEmailAddress1(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU004_invalidEmailAddress2() {
        String filepath = filePathSnapshot + "\\UC01_AU004_invalidEmailAddress2_";
        CreateAccountTests.UC01_AU004_invalidEmailAddress2(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU005_invalidEmailAddress3() {
        String filepath = filePathSnapshot + "\\UC01_AU005_invalidEmailAddress3_";
        CreateAccountTests.UC01_AU005_invalidEmailAddress3(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU006_invalidEmailAddress4() {
        String filepath = filePathSnapshot + "\\UC01_AU006_invalidEmailAddress4_";
        CreateAccountTests.UC01_AU006_invalidEmailAddress4(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU007_invalidEmailAddress5() {
        String filepath = filePathSnapshot + "\\UC01_AU007_invalidEmailAddress5_";
        CreateAccountTests.UC01_AU007_invalidEmailAddress5(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU008_invalidEmailAddress6() {
        String filepath = filePathSnapshot + "\\UC01_AU008_invalidEmailAddress6_";
        CreateAccountTests.UC01_AU008_invalidEmailAddress6(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU009_invalidPassword1() {
        String filepath = filePathSnapshot + "\\UC01_AU009_invalidPassword1_";
        CreateAccountTests.UC01_AU009_invalidPassword1(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU010_invalidPassword2() {
        String filepath = filePathSnapshot + "\\UC01_AU010_invalidPassword2_";
        CreateAccountTests.UC01_AU010_invalidPassword2(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU011_invalidPassword3() {
        String filepath = filePathSnapshot + "\\UC01_AU011_invalidPassword3_";
        CreateAccountTests.UC01_AU011_invalidPassword3(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU012_passwordAndConfirmPasswordNotMatch() {
        String filepath = filePathSnapshot + "\\UC01_AU012_passwordAndConfirmPasswordNotMatch_";
        CreateAccountTests.UC01_AU012_passwordAndConfirmPasswordNotMatch(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU013_emailAddressMandatory() {
        String filepath = filePathSnapshot + "\\UC01_AU013_emailAddressMandatory_";
        CreateAccountTests.UC01_AU013_emailAddressMandatory(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU014_checkFieldsExist() {
        String filepath = filePathSnapshot + "\\UC01_AU014_checkFieldsExist_";
        CreateAccountTests.UC01_AU014_checkCreateAccountPageFieldsExist(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU015_checkCreateAccountValidateFieldsExist() {
        String filepath = filePathSnapshot + "\\UC01_AU015_checkCreateAccountValidateFieldsExist_";
        CreateAccountTests.UC01_AU015_checkCreateAccountValidateFieldsExist(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU016_existingEmailAccount() {
        String filepath = filePathSnapshot + "\\UC01_AU016_existingEmailAccount_";
        CreateAccountTests.UC01_AU016_existingEmailAccount(driver, wdwait, env, filepath);
    }
    
    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU017_resendEmailPressedOnce() {
        String filepath = filePathSnapshot + "\\UC01_AU017_resendEmailPressedOnce_";
        CreateAccountTests.UC01_AU017_resendEmailPressedOnce(driver, wdwait, env, filepath);
    }

    
    //@Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void UC01_AU018_resendEmailPressedTwice() {
        String filepath = filePathSnapshot + "\\UC01_AU018_resendEmailPressedTwice_";
        CreateAccountTests.UC01_AU018_resendEmailPressedTwice(driver, wdwait, env, filepath);
    }
}
