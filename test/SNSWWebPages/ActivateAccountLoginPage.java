/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Kurt
 */
public class ActivateAccountLoginPage {
    
    private final WebDriver driver;
    
    public ActivateAccountLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
    }
    
    public void setUsername(String username) {
        WebElement a = this.driver.findElement(By.id("username"));
        a.sendKeys(username);
    }
    
    public void setPassword(String password) {
        WebElement a = this.driver.findElement(By.id("password"));
        a.sendKeys(password);
    }
    
    public void clickLoginButton() {
        WebElement a = this.driver.findElement(By.id("loginBtn"));
        a.click();
    }
}
