/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import SNSWWebPages.ActivateAccountLingGovernmentServicePage;
import SNSWWebPages.CreateAccountPage;
import SNSWWebPages.CreateAccountValidate;
import SNSWWebPages.Yopmail;
import SNSWWebPages.ActivateAccountLoginPage;
import SNSWWebPages.ActivateAccountPersonalDetailsPage;
import SNSWWebPages.ActivateAccountSecurityQuestionsPage;
//import SNSWWebPages.ServiceNSWDashboardPage;
import TestHelpers.Environment;
import java.util.ArrayList;
//import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 *
 * @author Kurt
 */
public class SNSWSeleniumTests {
    static WebDriver driver;
    static Wait<WebDriver> wdwait;
    static Environment env;
    
    public SNSWSeleniumTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        env = new Environment(Environment.Env.IT2);
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
    public void createAccountViaYopmailSuccessfullyAllOptions() {
        try {
            driver = new FirefoxDriver();
            wdwait = new WebDriverWait(driver, 30);
            
            driver.get(env.getCreateAccountURL());
            System.out.println("Base Window Handle: " + driver.getWindowHandle());
            
            String emailAddress = Yopmail.getEmailAddress();
            String emailPwd = Yopmail.getEmailPwd();
            
            CreateAccountPage cap = new CreateAccountPage(driver);
            cap.waitForElements(wdwait);
            cap.setEmail(emailAddress);
            cap.setPassword(emailPwd);
            cap.setConfirmPassword(emailPwd);
            cap.setTermsAndConditions(true);
            
            //Srirupa : This wait has been implemented to wait until manual captch selection has been done. 
            //once the captcha is disabled on test env this line need to be removed. 
            Thread.sleep(60000);
            
            cap.pressRegisterAccountButton();
            
            
            
            CreateAccountValidate cav = new CreateAccountValidate(driver);
            cav.waitForElements(wdwait);
            Thread.sleep(10000);
            
            
            Yopmail yop = new Yopmail(driver);
            yop.get();
            yop.waitForElements(wdwait);
            yop.setEmail(emailAddress);
            yop.submit();
            while (!yop.checkEmailHasArrived()) {
                Thread.sleep(8000);
                yop.checkAgainForEmail();
            }
            
            String subject = yop.firstEmailInList(wdwait);
            if (!subject.equals("auto.confirm@service.nsw.gov.au")) {
                System.out.println("Subject did not match Expected: [" + subject + "]");
            } else {
                System.out.println("Email Subject Matches");
            }
            yop.clickFirstEmailInList(wdwait);
            yop.clickFinishRegistering(wdwait);
            Thread.sleep(10000);
            
            Set<String> handles = driver.getWindowHandles();
            handles.stream().forEach((h) -> {
                System.out.println("Handle Name: " + h);
            });
            
            //
            //  At this point there are two windows open when using FirefoxDriver
            //
            //driver.switchTo().window((String)handles.toArray()[1]);
            ActivateAccountLoginPage aalp = new ActivateAccountLoginPage(driver);
            aalp.waitForElements(wdwait);
            aalp.setUsername(emailAddress);
            aalp.setPassword(emailPwd);
            aalp.clickLoginButton();
            
            
            ActivateAccountSecurityQuestionsPage aasqp = new ActivateAccountSecurityQuestionsPage(driver);
            aasqp.waitForElements(wdwait);
            aasqp.setFirstSecurityQuestion();   // Need this twice as the first is ignored
            Thread.sleep(1000);
            aasqp.setFirstAnswer("John Smyth");
            aasqp.setFirstSecurityQuestion();   //  This is ugly but needed to get the dropdown to work.
            Thread.sleep(1000);
            aasqp.setSecondSecurityQuestion();
            aasqp.setSecondAnswer("Jane Smyth");
            Thread.sleep(1000);
            aasqp.setThirdSecurityQuestion();
            aasqp.setThirdAnswer("Peter Pann");
            aasqp.setFirstSecurityQuestion();
            Thread.sleep(2000);
            aasqp.pressNextButton();
            
            
            ActivateAccountPersonalDetailsPage aapdp = new ActivateAccountPersonalDetailsPage(driver);
            aapdp.waitForElements(wdwait);
            aapdp.setTitle();
            aapdp.setFirstname("John");
            aapdp.setMiddlename("Peter");
            aapdp.setLastname("Smyth");
            aapdp.pressNextButton();
            
            
            ActivateAccountLingGovernmentServicePage aa = new ActivateAccountLingGovernmentServicePage(driver);
            aa.waitForElements(wdwait);
            aa.pressLogoutButton();
            
            //
            //  Switched off the few steps below as an authorisation dialog is displayed
            //
            //Thread.sleep(4000);
            //ServiceNSWDashboardPage sdp = new ServiceNSWDashboardPage(driver);
            //sdp.pressLogoutButton();
            

            Thread.sleep(2000);
            
            driver.close();
            //driver.switchTo().window((String)handles.toArray()[0]);
            //driver.close();

        } catch (InterruptedException ex) {
            Logger.getLogger(SNSWSeleniumTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void createAccountViaYopmailSuccessfullyNoEmailNotifications() {
        try {
            driver = new FirefoxDriver();
            wdwait = new WebDriverWait(driver, 30);
            
            driver.get(env.getCreateAccountURL());
            System.out.println("Base Window Handle: " + driver.getWindowHandle());
            
            String emailAddress = Yopmail.getEmailAddress();
            String emailPwd = Yopmail.getEmailPwd();
            
            CreateAccountPage cap = new CreateAccountPage(driver);
            cap.waitForElements(wdwait);
            cap.setEmail(emailAddress);
            cap.setPassword(emailPwd);
            cap.setConfirmPassword(emailPwd);
            cap.setTermsAndConditions(true);
            cap.setEmailNotification(false);
            cap.pressRegisterAccountButton();
            
            
            CreateAccountValidate cav = new CreateAccountValidate(driver);
            cav.waitForElements(wdwait);
            Thread.sleep(10000);
            
            
            Yopmail yop = new Yopmail(driver);
            yop.get();
            yop.waitForElements(wdwait);
            yop.setEmail(emailAddress);
            yop.submit();
            while (!yop.checkEmailHasArrived()) {
                Thread.sleep(8000);
                yop.checkAgainForEmail();
            }
            
            String subject = yop.firstEmailInList(wdwait);
            if (!subject.equals("auto.confirm@service.nsw.gov.au")) {
                System.out.println("Subject did not match Expected: [" + subject + "]");
            } else {
                System.out.println("Email Subject Matches");
            }
            yop.clickFirstEmailInList(wdwait);
            yop.clickFinishRegistering(wdwait);
            Thread.sleep(10000);
            
            Set<String> handles = driver.getWindowHandles();
            handles.stream().forEach((h) -> {
                System.out.println("Handle Name: " + h);
            });
            
            //
            //  At this point there are two windows open when using FirefoxDriver
            //
            driver.switchTo().window((String)handles.toArray()[1]);
            ActivateAccountLoginPage aalp = new ActivateAccountLoginPage(driver);
            aalp.waitForElements(wdwait);
            aalp.setUsername(emailAddress);
            aalp.setPassword(emailPwd);
            aalp.clickLoginButton();
            
            
            ActivateAccountSecurityQuestionsPage aasqp = new ActivateAccountSecurityQuestionsPage(driver);
            aasqp.waitForElements(wdwait);
            aasqp.setFirstSecurityQuestion();   // Need this twice as the first is ignored
            Thread.sleep(1000);
            aasqp.setFirstAnswer("John Smyth");
            aasqp.setFirstSecurityQuestion();   //  This is ugly but needed to get the dropdown to work.
            Thread.sleep(1000);
            aasqp.setSecondSecurityQuestion();
            aasqp.setSecondAnswer("Jane Smyth");
            Thread.sleep(1000);
            aasqp.setThirdSecurityQuestion();
            aasqp.setThirdAnswer("Peter Pann");
            aasqp.setFirstSecurityQuestion();
            Thread.sleep(2000);
            aasqp.pressNextButton();
            
            
            ActivateAccountPersonalDetailsPage aapdp = new ActivateAccountPersonalDetailsPage(driver);
            aapdp.waitForElements(wdwait);
            aapdp.setTitle();
            aapdp.setFirstname("John");
            aapdp.setMiddlename("Peter");
            aapdp.setLastname("Smyth");
            aapdp.pressNextButton();
            
            
            ActivateAccountLingGovernmentServicePage aa = new ActivateAccountLingGovernmentServicePage(driver);
            aa.waitForElements(wdwait);
            aa.pressLogoutButton();
            
            
            //
            //  Switched off the few steps below as an authorisation dialog is displayed
            //
            //Thread.sleep(4000);
            //ServiceNSWDashboardPage sdp = new ServiceNSWDashboardPage(driver);
            //sdp.pressLogoutButton();
            

            Thread.sleep(2000);
            
            driver.close();
            driver.switchTo().window((String)handles.toArray()[0]);
            driver.close();

        } catch (InterruptedException ex) {
            Logger.getLogger(SNSWSeleniumTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Ignore("Test is ignored on purpose while building more tests")
    @Test
    public void createAccountViaYopmailSuccessfullyNoNews() {
        try {
            driver = new FirefoxDriver();
            wdwait = new WebDriverWait(driver, 30);
            
            driver.get(env.getCreateAccountURL());
            System.out.println("Base Window Handle: " + driver.getWindowHandle());
            
            String emailAddress = Yopmail.getEmailAddress();
            String emailPwd = Yopmail.getEmailPwd();
            
            CreateAccountPage cap = new CreateAccountPage(driver);
            cap.waitForElements(wdwait);
            cap.setEmail(emailAddress);
            cap.setPassword(emailPwd);
            cap.setConfirmPassword(emailPwd);
            cap.setTermsAndConditions(true);
            cap.setNews(false);
            cap.pressRegisterAccountButton();
            
            
            CreateAccountValidate cav = new CreateAccountValidate(driver);
            cav.waitForElements(wdwait);
            Thread.sleep(10000);
            
            
            Yopmail yop = new Yopmail(driver);
            yop.get();
            yop.waitForElements(wdwait);
            yop.setEmail(emailAddress);
            yop.submit();
            while (!yop.checkEmailHasArrived()) {
                Thread.sleep(8000);
                yop.checkAgainForEmail();
            }
            
            String subject = yop.firstEmailInList(wdwait);
            if (!subject.equals("auto.confirm@service.nsw.gov.au")) {
                System.out.println("Subject did not match Expected: [" + subject + "]");
            } else {
                System.out.println("Email Subject Matches");
            }
            yop.clickFirstEmailInList(wdwait);
            yop.clickFinishRegistering(wdwait);
            Thread.sleep(10000);
            
            Set<String> handles = driver.getWindowHandles();
            handles.stream().forEach((h) -> {
                System.out.println("Handle Name: " + h);
            });
            
            //
            //  At this point there are two windows open when using FirefoxDriver
            //
            driver.switchTo().window((String)handles.toArray()[1]);
            ActivateAccountLoginPage aalp = new ActivateAccountLoginPage(driver);
            aalp.waitForElements(wdwait);
            aalp.setUsername(emailAddress);
            aalp.setPassword(emailPwd);
            aalp.clickLoginButton();
            
            
            ActivateAccountSecurityQuestionsPage aasqp = new ActivateAccountSecurityQuestionsPage(driver);
            aasqp.waitForElements(wdwait);
            aasqp.setFirstSecurityQuestion();   // Need this twice as the first is ignored
            Thread.sleep(1000);
            aasqp.setFirstAnswer("John Smyth");
            aasqp.setFirstSecurityQuestion();   //  This is ugly but needed to get the dropdown to work.
            Thread.sleep(1000);
            aasqp.setSecondSecurityQuestion();
            aasqp.setSecondAnswer("Jane Smyth");
            Thread.sleep(1000);
            aasqp.setThirdSecurityQuestion();
            aasqp.setThirdAnswer("Peter Pann");
            aasqp.setFirstSecurityQuestion();
            Thread.sleep(2000);
            aasqp.pressNextButton();
            
            
            ActivateAccountPersonalDetailsPage aapdp = new ActivateAccountPersonalDetailsPage(driver);
            aapdp.waitForElements(wdwait);
            aapdp.setTitle();
            aapdp.setFirstname("John");
            aapdp.setMiddlename("Peter");
            aapdp.setLastname("Smyth");
            aapdp.pressNextButton();
            
            
            ActivateAccountLingGovernmentServicePage aa = new ActivateAccountLingGovernmentServicePage(driver);
            aa.waitForElements(wdwait);
            aa.pressLogoutButton();
            
            
            //
            //  Switched off the few steps below as an authorisation dialog is displayed
            //
            //Thread.sleep(4000);
            //ServiceNSWDashboardPage sdp = new ServiceNSWDashboardPage(driver);
            //sdp.pressLogoutButton();
            

            Thread.sleep(2000);
            
            driver.close();
            driver.switchTo().window((String)handles.toArray()[0]);
            driver.close();

        } catch (InterruptedException ex) {
            Logger.getLogger(SNSWSeleniumTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
