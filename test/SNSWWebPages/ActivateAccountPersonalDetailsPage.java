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
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currentTitle\"]/option[1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='formly_1_input_firstName_1']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='formly_1_input_middleName_2']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='formly_1_input_lastName_3']")));
    }
    
    public void setTitle() {
        driver.findElement(By.xpath("//select[@id=\"formly_1_select_salutation_0\"]/option[1]")).click();
    }
    
    public void setFirstname(String name) {
        driver.findElement(By.cssSelector("input[id='formly_1_input_firstName_1']")).sendKeys(name);
    }
    
    public void setMiddlename(String name) {
        driver.findElement(By.cssSelector("input[id='formly_1_input_middleName_2']")).sendKeys(name);
    }
    
    public void setLastname(String name) {
        driver.findElement(By.cssSelector("input[id='formly_1_input_lastName_3']")).sendKeys(name);
    }
    
    public void pressNextButton() {
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }
}
