/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import SNSWWebPages.CreateAccountPage;
import SNSWWebPages.CreateAccountValidate;
import SNSWWebPages.Yopmail;
import TestHelpers.Environment;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

/**
 *
 * @author Kurt MacNamara
 * @date   12/11/2015
 */
public class CreateAccountTests {
    
    
    
    public static void UC01_AU001_checkForErrorMessages(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.pressRegisterAccountButton();
        if (!cap.checkForError("Please check the following", "Please check the following 4 errors:")) {
            env.takeSnapshot(driver, filepath + "02_ERROR Messages did not match.png");
            Assert.fail("The error message did not match");
        }

        env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("Email Address: Invalid email address. Please enter an email address using the format example@email.com");
        errorMessages.add("Password: Please fill out this field.");
        errorMessages.add("Confirm Password: Please fill out this field.");
        errorMessages.add("Terms and Conditions: Please accept the Terms and Conditions to continue.");
        cap.numberForErrorsDisplayed(errorMessages);
    }
    
    
    public static void UC01_AU002_verifyTCMandatory(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(false);
        cap.pressRegisterAccountButton();

        if (!cap.checkForError("Please check the following", "Please check the following 1 error:")) {
            env.takeSnapshot(driver, filepath + "02_ERROR Messages did not match.png");
            Assert.fail("The error message did not match");
        }
        
        env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("Terms and Conditions: Please accept the Terms and Conditions to continue.");
        cap.numberForErrorsDisplayed(errorMessages);
    }

    
    public static void UC01_AU003_invalidEmailAddress1(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abcdefg");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU004_invalidEmailAddress2(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("@wally.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU005_invalidEmailAddress3(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("#@%^@#.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    // comment for commit
    public static void UC01_AU006_invalidEmailAddress4(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("example@example@example.com");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU007_invalidEmailAddress5(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("Joe Smith <Abc..123@111.222.333.444> (Joe Smith)");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU008_invalidEmailAddress6(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abc@@test");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidEmailCheck("Invalid email address. Please enter an email address using the format example@email.com")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    //
    //  Password less than 7 characters
    //
    public static void UC01_AU009_invalidPassword1(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abc@@test");
        cap.setPassword("Ab12zz");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidPasswordCheck("Use 7 or more characters including at least 1 number and 1 letter. For a stronger password, include uppercase, lowercase and special characters (punctuation or symbols).")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU010_invalidPassword2(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abc@@test");
        cap.setPassword("AbZgDeFWaslkmn");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidPasswordCheck("Use 7 or more characters including at least 1 number and 1 letter. For a stronger password, include uppercase, lowercase and special characters (punctuation or symbols).")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU011_invalidPassword3(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abc@@test");
        cap.setPassword("12345678901234567890");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.invalidPasswordCheck("Use 7 or more characters including at least 1 number and 1 letter. For a stronger password, include uppercase, lowercase and special characters (punctuation or symbols).")) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Email Address error message not what was expected");
        }
    }

    
    public static void UC01_AU012_passwordAndConfirmPasswordNotMatch(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail("abc@@test");
        cap.setPassword("%Preferences10");
        cap.setConfirmPassword("%Preferences20");
        cap.setNews(true);
        cap.pressRegisterAccountButton();
        
        if (cap.confirmPasswordNotMatchMessagePresent()) {
            env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR_Messages Displayed not expected.png");
            Assert.fail("Password not match message is not displayed as expected");
        }
    }
    
    
    public static void UC01_AU013_emailAddressMandatory(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setPassword("%Preferences10");
        cap.setConfirmPassword("%Preferences10");
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();
        if (!cap.checkForError("Please check the following", "Please check the following 1 error:")) {
            env.takeSnapshot(driver, filepath + "02_ERROR MessagesDisplayed not expected.png");
            Assert.fail("The error message did not match");
        }
        env.takeSnapshot(driver, filepath + "02_Messages Displayed.png");
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("Email Address: Invalid email address. Please enter an email address using the format example@email.com");
        cap.numberForErrorsDisplayed(errorMessages);
    }

    
    public static void UC01_AU014_checkCreateAccountPageFieldsExist(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        Assert.assertTrue(cap.existsEmailTitle(), "Email Title not found");
        Assert.assertTrue(cap.existsEmailInput(), "Email Input field not found");
        Assert.assertTrue(cap.existsPasswordTitle(), "Password Title not found");
        Assert.assertTrue(cap.existsPasswordInput(), "Password Input field not found");
        Assert.assertTrue(cap.existsShowPasswordAndConfirmPasswordCheckbox(), "Expecting both the Show Password Checkboxes to be found");
        Assert.assertTrue(cap.existsEmailTitle(), "Confirm password Title not found");
        Assert.assertTrue(cap.existsConfirmPasswordInput(), "Confirm password Input field not found");
        Assert.assertTrue(cap.existsTermsAndConditionsCheckbox(), "Terms and Conditions checkbox not found");
        Assert.assertTrue(cap.existsEmailNotificationCheckbox(), "Email Notification checkbox not found");
        Assert.assertTrue(cap.existsNewsCheckbox(), "News checkbox not found");
        Assert.assertTrue(cap.existsNewsGovernmentCheckbox(), "News Government checkbox not found");
    }

    
    public static void UC01_AU015_checkCreateAccountValidateFieldsExist(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {
        
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();
        
        
        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        cav.isHeadingDisplayed();
        cav.emailAddressDisplayed(emailAddress);
    }

    
    public static void UC01_AU016_existingEmailAccount(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {
        
        driver.get(env.getCreateAccountURL());
        String emailAddress = env.getExistingEmailAddress();
        String emailPwd = env.getExistingEmailAddressPassword();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();
        cap.emailAddressInUseMessage(wdwait, "This email address is already in use. Please enter another email address.");
    }

    
    public static void UC01_AU017_resendEmailPressedOnce(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {
        
        driver.manage().deleteAllCookies();
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();
        
        
        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        cav.isHeadingDisplayed();
        cav.emailAddressDisplayed(emailAddress);
        cav.pressResendEmail();
        
        cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.");
    }

    
    public static void UC01_AU018_resendEmailPressedTwice(WebDriver driver, Wait<WebDriver> wdwait, Environment env) {
        
        driver.manage().deleteAllCookies();
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();


        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        cav.isHeadingDisplayed();
        cav.emailAddressDisplayed(emailAddress);
        cav.pressResendEmail();
        cav.pressResendEmail();

        cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.");
    }

    
    public static void UC01_AU019_resendEmailManyTimes(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        try {
            driver.manage().deleteAllCookies();
            driver.get(env.getCreateAccountURL());
            env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
            
            String emailAddress = Yopmail.getEmailAddress();
            String emailPwd = Yopmail.getEmailPwd();
            CreateAccountPage cap = new CreateAccountPage(driver);
            cap.waitForElements(wdwait);
            cap.setEmail(emailAddress);
            cap.setPassword(emailPwd);
            cap.setConfirmPassword(emailPwd);
            cap.setTermsAndConditions(true);
            env.takeSnapshot(driver, filepath + "02_RegisterFilled.png");
            cap.pressRegisterAccountButton();
            
            
            //
            //  The first time in the Creat Account Validation page
            //
            CreateAccountValidate cav = new CreateAccountValidate(driver);
            cav.waitForElements(wdwait);
            cav.isHeadingDisplayed();
            cav.emailAddressDisplayed(emailAddress);
            cav.pressResendEmail();
            cav.pressResendEmail();
            cav.pressResendEmail();
            
            cav.checkFiveMinuteLockMessage(wdwait);
            cav.getAttributeOfResendEmailMessage("ng-disabled", "locked");
            cav.getAttributeOfResendEmailMessage("disabled", "true");
            
            if (!cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not disabled.");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not active.");
            }
            
            
            //
            //  The second time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //

            cav.pressResendEmail();
            cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.");
            
            cav.checkFiveMinuteLockMessage(wdwait);
            cav.getAttributeOfResendEmailMessage("ng-disabled", "locked");
            cav.getAttributeOfResendEmailMessage("disabled", "true");
            
            if (!cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not disabled.");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not active.");
            }
            
            
            //
            //  The third time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //

            cav.pressResendEmail();
            cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.");
            
            cav.checkFiveMinuteLockMessage(wdwait);
            cav.getAttributeOfResendEmailMessage("ng-disabled", "locked");
            cav.getAttributeOfResendEmailMessage("disabled", "true");
            
            if (!cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not disabled.");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not active.");
            }
            
            
            //
            //  The forth time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //

            cav.pressResendEmail();
            cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.");

            cav.pressResendEmail();
            cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.");
            
            cav.checkFiveMinuteLockMessage(wdwait);
            cav.getAttributeOfResendEmailMessage("ng-disabled", "locked");
            cav.getAttributeOfResendEmailMessage("disabled", "true");
            
            if (!cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not disabled.");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                Assert.fail("The Resend Email Button was not active.");
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateAccountTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
