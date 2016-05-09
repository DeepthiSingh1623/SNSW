/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Kurt
 */
public class ActivateAccountSecurityQuestionsPage {
    
    private final WebDriver driver;
    
    public ActivateAccountSecurityQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstsecurityquestion")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secondsecurityquestion")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("thirdsecurityquestion")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstsecurityanswer")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secondsecurityanswer")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("thirdsecurityanswer")));
    }

    public void setFirstSecurityQuestion() {
        WebElement a = this.driver.findElement(By.id("firstsecurityquestion"));
        Select dropdown = new Select(a);
        List<WebElement> values =  dropdown.getOptions();
        System.out.println("First option value: " + values.get(0).getText());
        dropdown.selectByVisibleText("What is the name of your favourite childhood friend?");
    }

    public void setFirstAnswer(String answer) {
        driver.findElement(By.id("firstsecurityanswer")).sendKeys(answer);
    }
    
    public void setSecondSecurityQuestion() {
        WebElement a = this.driver.findElement(By.id("secondsecurityquestion"));
        Select dropdown = new Select(a);
        List<WebElement> values =  dropdown.getOptions();
        System.out.println("First option value: " + values.get(0).getText());
        dropdown.selectByVisibleText("In what city or town was your first job?");
    }

    public void setSecondAnswer(String answer) {
        driver.findElement(By.id("secondsecurityanswer")).sendKeys(answer);
    }

    public void setThirdSecurityQuestion() {
        WebElement a = this.driver.findElement(By.id("thirdsecurityquestion"));
        Select dropdown = new Select(a);
        List<WebElement> values =  dropdown.getOptions();
        System.out.println("First option value: " + values.get(0).getText());
        dropdown.selectByVisibleText("What was your favourite place to visit as a child?");
    }

    public void setThirdAnswer(String answer) {
        driver.findElement(By.id("thirdsecurityanswer")).sendKeys(answer);
    }
    
    public void pressNextButton() {
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }
}
