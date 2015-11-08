/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Kurt
 */
public class ActivateAccountPersonalDetailsPage {
    
    private final WebDriver driver;
    
    public ActivateAccountPersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currentTitle\"]/option[1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='details.firstName']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='details.middleInitial']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='details.lastName']")));
    }
    
    public void setTitle() {
        driver.findElement(By.xpath("//*[@id=\"currentTitle\"]/option[1]")).click();
    }
    
    public void setFirstname(String name) {
        driver.findElement(By.cssSelector("input[ng-model='details.firstName']")).sendKeys(name);
    }
    
    public void setMiddlename(String name) {
        driver.findElement(By.cssSelector("input[ng-model='details.middleInitial']")).sendKeys(name);
    }
    
    public void setLastname(String name) {
        driver.findElement(By.cssSelector("input[ng-model='details.lastName']")).sendKeys(name);
    }
    
    public void pressNextButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ng-transclude/div/form/div[5]/div[2]/button")).click();
    }
}
