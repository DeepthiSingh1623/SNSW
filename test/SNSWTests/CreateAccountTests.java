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

    
    public static void UC01_AU014_checkCreateAccountPageFieldsExist(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        driver.get(env.getCreateAccountURL());

        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
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

    
    public static void UC01_AU015_checkCreateAccountValidateFieldsExist(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        boolean success = true;
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        env.takeSnapshot(driver, filepath + "02_Before Press Register Account Button.png");
        cap.pressRegisterAccountButton();
        
        
        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "03_Validate Account Page Displayed.png");
        if (!cav.isHeadingDisplayed()) {
            success = false;
            env.takeSnapshot(driver, filepath + "04_ERROR Header displayed incorrect.png");
        }
        if (!cav.emailAddressDisplayed(emailAddress)) {
            success = false;
            env.takeSnapshot(driver, filepath + "04_ERROR email address not displayed.png");
        }
        
        if (!success) {
            Assert.fail("Check the snapshots and output for what failed.");
        }
    }

    
    public static void UC01_AU016_existingEmailAccount(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        driver.get(env.getCreateAccountURL());
        String emailAddress = env.getExistingEmailAddress();
        String emailPwd = env.getExistingEmailAddressPassword();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        cap.pressRegisterAccountButton();
        if (cap.emailAddressInUseMessage(wdwait, "This email address is already in use. Please enter another email address.")) {
            env.takeSnapshot(driver, filepath + "02_Email Address in use message.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_ERROR Email Address in use message.png");
            Assert.fail("Email Address in use message not as expected");
        }
    }

    
    public static void UC01_AU017_resendEmailPressedOnce(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        boolean success = true;
        driver.manage().deleteAllCookies();
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        env.takeSnapshot(driver, filepath + "02_Before Register Button Pressed.png");
        cap.pressRegisterAccountButton();
        
        
        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "03_Validate Account Page.png");
        cav.isHeadingDisplayed();
        if (!cav.emailAddressDisplayed(emailAddress)) {
            success = false;
            env.takeSnapshot(driver, filepath + "04_ERROR Email Address not displayed.png");
        }
        cav.pressResendEmail();
        if (!cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.")) {
            success = false;
            env.takeSnapshot(driver, filepath + "05_ERROR Resend Message not as expected.png");
        }
        
        if (!success) {
            Assert.fail("One or more errors encountered check snapshots and output.");
        }
    }

    
    public static void UC01_AU018_resendEmailPressedTwice(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        boolean success = true;
        driver.manage().deleteAllCookies();
        driver.get(env.getCreateAccountURL());
        String emailAddress = Yopmail.getEmailAddress();
        String emailPwd = Yopmail.getEmailPwd();
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        cap.setEmail(emailAddress);
        cap.setPassword(emailPwd);
        cap.setConfirmPassword(emailPwd);
        cap.setTermsAndConditions(true);
        env.takeSnapshot(driver, filepath + "02_Before Register email button pressed.png");
        cap.pressRegisterAccountButton();


        CreateAccountValidate cav = new CreateAccountValidate(driver);
        cav.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "03_Validate Account Page.png");
        if (!cav.isHeadingDisplayed()) {
            success = false;
            env.takeSnapshot(driver, filepath + "04_ERROR Heading not displayed.png");
        }
        if (!cav.emailAddressDisplayed(emailAddress)) {
            success = false;
            env.takeSnapshot(driver, filepath + "05_ERROR Email Address not displayed.png");
        }
        cav.pressResendEmail();
        cav.pressResendEmail();

        if (!cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.")) {
            success = false;
            env.takeSnapshot(driver, filepath + "06_ERROR resend message not as expected.png");
        } else {
            env.takeSnapshot(driver, filepath + "05_Resend Message displayed as expected.png");
        }
        
        if (!success) {
            Assert.fail("One or more errors encountered check snapshots and output.");
        }
    }

    
    public static void UC01_AU019_resendEmailManyTimes(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {
        
        try {
            boolean success = true;
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
            if (!cav.emailAddressDisplayed(emailAddress)) {
                success = false;
                env.takeSnapshot(driver, filepath + "03_ERROR Email address not displayed.png");
            } else {
                env.takeSnapshot(driver, filepath + "03_Email address displayed.png");
            }
            cav.pressResendEmail();
            cav.pressResendEmail();
            cav.pressResendEmail();
            
            cav.checkFiveMinuteLockMessage(wdwait);
            if (!cav.getAttributeOfResendEmailMessage("ng-disabled", "locked") || !cav.getAttributeOfResendEmailMessage("disabled", "true")) {
                success = false;
                env.takeSnapshot(driver, filepath + "04_ERROR Email message not displayed.png");
            } else {
                env.takeSnapshot(driver, filepath + "04_Email message displayed.png");
            }
            
            if (!cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "05_ERROR Resend Button not disabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "05_Resend Button disabled.png");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "06_ERROR Resend Button not enabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "06_Resend Button enabled.png");
            }
            
            
            //
            //  The second time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "07_ERROR First resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "07_First resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "08_ERROR Second resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "08_Second resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "09_ERROR Third resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "09_Third resend message.png");
            }
            
            cav.checkFiveMinuteLockMessage(wdwait);
            if (!cav.getAttributeOfResendEmailMessage("ng-disabled", "locked") || !cav.getAttributeOfResendEmailMessage("disabled", "true")) {
                success = false;
                env.takeSnapshot(driver, filepath + "10_ERROR Email message not displayed.png");
            } else {
                env.takeSnapshot(driver, filepath + "10_Email message displayed.png");
            }
            
            if (!cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "11_ERROR Resend Button not disabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "11_Resend Button disabled.png");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "12_ERROR Resend Button not enabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "12_Resend Button enabled.png");
            }
            
            
            //
            //  The third time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //


            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "13_ERROR First resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "13_First resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "14_ERROR Second resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "14_Second resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "15_ERROR Third resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "15_Third resend message.png");
            }
            
            cav.checkFiveMinuteLockMessage(wdwait);
            if (!cav.getAttributeOfResendEmailMessage("ng-disabled", "locked") || !cav.getAttributeOfResendEmailMessage("disabled", "true")) {
                success = false;
                env.takeSnapshot(driver, filepath + "16_ERROR Email message not displayed.png");
            } else {
                env.takeSnapshot(driver, filepath + "16_Email message displayed.png");
            }
            
            if (!cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "17_ERROR Resend Button not disabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "17_Resend Button disabled.png");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "18_ERROR Resend Button not enabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "18_Resend Button enabled.png");
            }
            
            
            //
            //  The forth time in the Creat Account Validation page
            //
            //
            //  After the Resend Email button becomes available
            //

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedFirst(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. It will be active for one hour.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "19_ERROR First resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "19_First resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedOnce(wdwait, "We sent you a verification email. Please finish registering your MyServiceNSW Account by following the link in the activation email. You have 1 attempt left to resend the registration link before it gets locked.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "20_ERROR Second resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "20_Second resend message.png");
            }

            cav.pressResendEmail();
            if (!cav.resendMessageDisplayedTwice(wdwait, "Activation email sent! Please check your inbox. The resend option is locked for 5 minutes.")) {
                success = false;
                env.takeSnapshot(driver, filepath + "21_ERROR Third resend message.png");
            } else {
                env.takeSnapshot(driver, filepath + "21_Third resend message.png");
            }
            
            cav.checkFiveMinuteLockMessage(wdwait);
            if (!cav.getAttributeOfResendEmailMessage("ng-disabled", "locked") || !cav.getAttributeOfResendEmailMessage("disabled", "true")) {
                success = false;
                env.takeSnapshot(driver, filepath + "22_ERROR Email message not displayed.png");
            } else {
                env.takeSnapshot(driver, filepath + "22_Email message displayed.png");
            }
            
            if (!cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "23_ERROR Resend Button not disabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "23_Resend Button disabled.png");
            }
            
            //
            //  Sleep for 5 minutes and 1 second.  See if the ResendButton is now active.
            //
            Thread.sleep(301000);
            if (cav.isResendEmailButtonDisabled()) {
                success = false;
                env.takeSnapshot(driver, filepath + "24_ERROR Resend Button not enabled.png");
            } else {
                env.takeSnapshot(driver, filepath + "24_Resend Button enabled.png");
            }
            
            if (!success) {
                Assert.fail("Check the output and snapshots for the error details");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateAccountTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
