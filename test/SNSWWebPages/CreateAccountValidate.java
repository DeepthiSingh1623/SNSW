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
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void isHeadingDisplayed() {
        try {
            String heading = this.driver.findElement(By.xpath(CreateAccountValidate.weHeadingTextXpath)).getText();
            
            if(!heading.equals("Activate your MyServiceNSW Account")) {
                Assert.fail("Heading not as expected");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public void emailAddressDisplayed(String emailAddress) {
        String xpath = "//strong[contains(text(), '" + emailAddress + "')][@class='ng-binding']";
        try {
            this.driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public void resendMessageDisplayedFirst(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//span[@class='ng-binding ng-scope'][@ng-if='attemptsLeft !== 1']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                Assert.fail("Did not find the expected message");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public void resendMessageDisplayedOnce(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//span[@class='ng-binding ng-scope'][@ng-if='attemptsLeft === 1']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                Assert.fail("Did not find the expected message");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public void resendMessageDisplayedTwice(Wait<WebDriver> wait, String messageDisplayed) {
        String xpath = "//div[@class='alert alert-danger ng-binding ng-scope'][@ng-show='error']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = this.driver.findElement(By.xpath(xpath));
            
            if(!element.getText().equals(messageDisplayed)) {
                Assert.fail("Did not find the expected message");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
