/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

/**
 *
 * @author Kurt
 */
public class CreateAccountValidate {
    
    
    
    private static final String weResendEmailXpath = "//button[contains(text(), 'Resend email')]";
    private static final String weHeadingTextXpath = "//h2[@class=\"ng-binding ng-isolate-scope\"]";
    private static final String weLockedForFiveMinutesMessage = "//div[@class=\"alert alert-danger ng-binding ng-scope\"][@ng-show=\"error\"]";

    
    
    
    private final WebDriver driver;
    

    public CreateAccountValidate(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElements(Wait<WebDriver> wait) {
        //  Resend Email Button
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/ng-transclude/div/p[4]/button")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateAccountValidate.weResendEmailXpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateAccountValidate.weHeadingTextXpath)));
    }
    
    public void pressResendEmail() {
        this.driver.findElement(By.xpath(CreateAccountValidate.weResendEmailXpath)).click();
    }
    
    public boolean isResendEmailButtonDisabled() {
        try {
            WebElement element = this.driver.findElement(By.xpath(CreateAccountValidate.weResendEmailXpath));
            String value = element.getAttribute("disabled");
            if (value != null && value.equals("true")) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public void checkFiveMinuteLockMessage(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateAccountValidate.weLockedForFiveMinutesMessage)));
    }
    
    public boolean getAttributeOfResendEmailMessage(String attribute, String expectedValue) {
        try {
            WebElement element = this.driver.findElement(By.xpath(CreateAccountValidate.weResendEmailXpath));
            String value = element.getAttribute(attribute);
            if (value.equals(expectedValue)) {
                return true;
            } else {
                System.out.println("Found Resend Email Button Attribute value: " + value);
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public boolean isHeadingDisplayed() {
        try {
            String heading = this.driver.findElement(By.xpath(CreateAccountValidate.weHeadingTextXpath)).getText();
            if (heading.equals("Activate your MyServiceNSW Account")) {
                return true;
            } else {
                System.out.println("CreateAccountValidate.isHeadingDisplayed: ERROR The Header title did not match expected.");
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("CreateAccountValidate.isHeadingDisplayed: ERROR Could not find the element for the Page Header Title");
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean emailAddressDisplayed(String emailAddress) {
        String xpath = "//strong[contains(text(), '" + emailAddress + "')][@class='ng-binding']";
        try {
            this.driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("CreateAccountValidate.emailAddressDisplayed: ERROR Could not find the element for the email address");
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean resendMessageDisplayedFirst(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//span[@class='ng-binding ng-scope'][@ng-if='attemptsLeft !== 1']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                System.out.println("CreateAccountValidate.resendMessageDisplayedFirst: ERROR The message was not as expected.");
                return false;
            } else {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("CreateAccountValidate.resendMessageDisplayedFirst: ERROR Could not find the element");
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean resendMessageDisplayedOnce(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//span[@class='ng-binding ng-scope'][@ng-if='attemptsLeft === 1']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                System.out.println("CreateAccountValidate.resendMessageDisplayedOnce: ERROR The message was not as expected.");
                return false;
            } else {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("CreateAccountValidate.resendMessageDisplayedOnce: ERROR Could not find the element");
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean resendMessageDisplayedTwice(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//div[@class='alert alert-danger ng-binding ng-scope'][@ng-show='error']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                System.out.println("CreateAccountValidate.resendMessageDisplayedTwice: ERROR The message was not as expected.");
                return false;
            } else {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("CreateAccountValidate.resendMessageDisplayedTwice: ERROR Could not find the element");
            System.out.println(e.getStackTrace());
            return false;
        }
    }
}
