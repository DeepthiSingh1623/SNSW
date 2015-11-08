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
public class ServiceNSWDashboardPage {
    
    private final WebDriver driver;
    
    public ServiceNSWDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[8]/a")));
    }
    
    
    public void pressLogoutButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[3]/ul/li[8]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[1]")).click();
    }
}
