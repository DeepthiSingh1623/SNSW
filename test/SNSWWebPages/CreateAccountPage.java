/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class CreateAccountPage {
    
    private static final String weEmailId = "email";
    private static final String wePasswordId = "password";
    private static final String weTermsAndConditionsId = "tnc";
    private static final String weEmailNotificationId = "emailNotification";
    private static final String weNewsId = "news";
    private static final String weNewsGovernmentId = "newGov";
    private static final String weConfirmPasswordId = "confirmPassword";
    private static final String weSubmitButtonId = "submitButton";
    private static final String weEmailTitleXpath = "//span[contains(text(), \"Email address\")][@class='ng-binding ng-scope']";
    private static final String wePasswordTitleXpath = "//span[contains(text(), \"Password\")][@class='ng-binding ng-scope']";
    private static final String weConfirmPasswordTitleXpath = "//span[contains(text(), \"Confirm password\")][@class='ng-binding ng-scope']";
    private static final String weExistsShowPasswordAndConfirmPasswordCheckboxXpath = "//input[@ng-click='togglePasswordVisible($event)']";
    private static final String weComfirmPasswordNotMatchXpath = "//span[contains(text(), \"These passwords do not match. Try again.\")][@class='text-danger ng-binding']";
    
    
    private final WebDriver driver;
    
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weEmailId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.wePasswordId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weConfirmPasswordId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weTermsAndConditionsId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weEmailNotificationId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weNewsId)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CreateAccountPage.weNewsGovernmentId)));
    }
    
    public boolean existsEmailTitle() {
        try {
            this.driver.findElement(By.xpath(CreateAccountPage.weEmailTitleXpath));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean existsEmailInput() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weEmailId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsPasswordTitle() {
        try {
            this.driver.findElement(By.xpath(CreateAccountPage.wePasswordTitleXpath));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean existsPasswordInput() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.wePasswordId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsShowPasswordAndConfirmPasswordCheckbox() {
        try {
            List<WebElement> elements = this.driver.findElements(By.xpath(CreateAccountPage.weExistsShowPasswordAndConfirmPasswordCheckboxXpath));
            return elements.size() == 2;
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public boolean existsConfirmPasswordTitle() {
        try {
            this.driver.findElement(By.xpath(CreateAccountPage.weConfirmPasswordTitleXpath));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }
    
    public boolean existsConfirmPasswordInput() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weConfirmPasswordId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsTermsAndConditionsCheckbox() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weTermsAndConditionsId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsEmailNotificationCheckbox() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weEmailNotificationId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsNewsCheckbox() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weNewsId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean existsNewsGovernmentCheckbox() {
        try {
            this.driver.findElement(By.id(CreateAccountPage.weNewsGovernmentId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    
    
    
    public void setEmail(String email) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weEmailId));
        a.sendKeys(email);
    }
    
    public void setPassword(String password) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.wePasswordId));
        a.sendKeys(password);
    }
    
    public void setConfirmPassword(String confirmPassword) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weConfirmPasswordId));
        a.sendKeys(confirmPassword);
    }
    
    public void setTermsAndConditions(boolean checked) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weTermsAndConditionsId));
        boolean status = a.isSelected();
        
        if (status != checked) {
            a.click();
        }
    }
    
    public void setEmailNotification(boolean checked) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weEmailNotificationId));
        boolean status = a.isSelected();
        
        if (status != checked) {
            a.click();
        }
    }
    
    public void setNews(boolean checked) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weNewsId));
        boolean status = a.isSelected();
        
        if (status != checked) {
            a.click();
        }
    }
    
    public void setNewGovernment(boolean checked) {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weNewsGovernmentId));
        boolean status = a.isSelected();
        
        if (status != checked) {
            a.click();
        }
    }
    
    public void pressRegisterAccountButton() {
        WebElement a = this.driver.findElement(By.id(CreateAccountPage.weSubmitButtonId));
        if(a.isEnabled()) {
            a.click();
        } else {
            System.out.println("Create Account Page - Submit Button not enabled");
        }
    }
    
    //driver.findElement(By.cssSelector("input[ng-model='details.firstName']"));
    //  Please check the following
    public boolean checkForError(String errorText, String expectedMessage) {
        String wantedText =  "//p[contains(text(), \"" + errorText + "\")]";
        try {
            WebElement element = this.driver.findElement(By.xpath(wantedText));
            if (element.isDisplayed() && element.getText().equals(expectedMessage)) {
                return true;
            } else {
                if (!element.isDisplayed()) {
                    System.out.println("[" + errorText + "]: not displayed");
                }
                if (!element.getText().equals(expectedMessage)) {
                    System.out.println("[" + element.getText() + "]: is not the expected value of: [" + expectedMessage + "]");
                }
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void numberForErrorsDisplayed(ArrayList<String> errorMessages) {
        try {
            List<WebElement> elements = this.driver.findElements(By.cssSelector("li[ng-repeat='field in vm.fields']"));
            Assert.assertTrue(elements.size() == errorMessages.size(), "Expected the same number of error elements");
            int minCount = elements.size() > errorMessages.size() ? errorMessages.size() : elements.size();
            for (int i = 0; i < minCount; ++i) {
                Assert.assertEquals(elements.get(i).getText(), errorMessages.get(i), "Expect this to match");
            }
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            Assert.fail("Error finding the WebElements");
        }
    }
    
    public boolean invalidEmailCheck(String errorMessage) {
        try {
            WebElement element = this.driver.findElement(By.cssSelector("span[ng-show='fc[attrs.name].$error.invalidEmail && !fc[attrs.name].$error.invalidEmailLength']"));
            if (element.getText().equals(errorMessage)) {
                return true;
            } else {
                System.out.println("ERROR: CreateAccountPage.invalidEmailCheck: Expected error message not displayed.");
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: CreateAccountPage.invalidEmailCheck: NoSuchElementException");
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
    
    public boolean invalidPasswordCheck(String errorMessage) {
        try {
            WebElement element = this.driver.findElement(By.xpath("//p[@class=\"help-block ng-binding\"]"));
            if (element.getText().equals(errorMessage)) {
                return true;
            } else {
                System.out.println("ERROR: CreateAccountPage.invalidEmailCheck: Expected error message not displayed.");
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: CreateAccountPage.invalidPasswordCheck: NoSuchElementException");
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
    
    public boolean confirmPasswordNotMatchMessagePresent() {
        try {
            WebElement element = this.driver.findElement(By.xpath(CreateAccountPage.weComfirmPasswordNotMatchXpath));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: CreateAccountPage.confirmPasswordNotMatchMessagePresent: NoSuchElementException");
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
    
    public void emailAddressInUseMessage(Wait<WebDriver> wait, String errorMessage) {
        try {
            String xpath = "//div[@class='alert alert-danger ng-binding'][@ng-show='error']";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            WebElement element = this.driver.findElement(By.xpath(xpath));
            Assert.assertEquals(element.getText(), errorMessage, "Expected the error message is not displayed");
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            Assert.fail("Error finding the Invalid Email Message");
        }
    }
}
