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
public class ActivateAccountLingGovernmentServicePage {
    
    private final WebDriver driver;
    
    public ActivateAccountLingGovernmentServicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/ng-transclude/div/div[4]/a[2]")));
    }
    
    
    public void pressLogoutButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ng-transclude/div/div[4]/a[2]")).click();
    }
}
