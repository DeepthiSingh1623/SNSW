/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import SNSWWebPages.CreateAccountPage;
import SNSWWebPages.Yopmail;
import TestHelpers.Environment;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

/**
 *
 * @author Kurt MacNamara
 * @date   12/11/2015
 */
public class CreateAccountTests {
    
    
    
    public static void checkForErrorMessages(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.pressRegisterAccountButton();
        if (!cap.checkForError("Please check the following", "Please check the following 4 errors:")) {
            Assert.fail("The error message did not match");
        }
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("Email Address: Invalid email address. Please enter an email address using the format example@email.com");
        errorMessages.add("Password: Please fill out this field.");
        errorMessages.add("Confirm Password: Please fill out this field.");
        errorMessages.add("Terms and Conditions: Please accept the Terms and Conditions to continue.");
        cap.numberForErrorsDisplayed(errorMessages);
    }
    
    
    public static void verifyTCMandatory(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(false);
        cap.pressRegisterAccountButton();

        if (!cap.checkForError("Please check the following", "Please check the following 1 error:")) {
            Assert.fail("The error message did not match");
        }
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("Terms and Conditions: Please accept the Terms and Conditions to continue.");
        cap.numberForErrorsDisplayed(errorMessages);
    }

    
    public static void invalidEmailAddress1(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail("abcdefg");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com");
    }

    
    public static void invalidEmailAddress2(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail("@wally.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com");
    }

    
    public static void invalidEmailAddress3(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail("#@%^@#.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com");
    }

    
    public static void invalidEmailAddress4(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail("example@example@example.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com");
    }

    
    public static void invalidEmailAddress5(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail("Joe Smith <Abc..123@111.222.333.444> (Joe Smith)");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com");
    }


    
}
