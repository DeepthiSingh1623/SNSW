/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWWebPages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Kurt
 */
public class Yopmail {
    
    private final WebDriver driver;
    
    private final static String emailAddr = "@yopmail.com";
    private final static String emailPwd = "%Preferences10";
    private final static String serverAddr = "http://yopmail.com";
    
    

    public final static String getEmailAddress() {
        return randomString(15) + emailAddr;
    }
    
    public final static String getEmailPwd() {
        return emailPwd;
    }
    
    private static String randomString(final int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            char c = chars[r.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    
    public Yopmail(WebDriver driver) {
        this.driver = driver;
    }
    
    public void get() {
        this.driver.get(emailAddr);
    }
    
    public void waitForElements(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"sbut\"]")));
    }

    public void setEmail(String email) {
        WebElement a = this.driver.findElement(By.id("login"));
        a.sendKeys(email);
    }
    
    public void submit() {
        WebElement a = this.driver.findElement(By.xpath("//input[@class=\"sbut\"]"));
        a.click();
    }
    
    public boolean checkEmailHasArrived() {
        try {
            this.driver.switchTo().frame("ifinbox");
            this.driver.findElement(By.xpath("//span[@class=\"lmf\"]"));
        } catch (NoSuchElementException e) {
            System.out.println("Did not find the element");
            this.driver.switchTo().defaultContent();
            return false;
        }
        this.driver.switchTo().defaultContent();
        return true;
    }
    
    public void checkAgainForEmail() {
        this.driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/form/table/tbody/tr[1]/td[3]/a/span/span")).click();
    }
    
    public String firstEmailInList(Wait<WebDriver> wait) {
        this.driver.switchTo().frame("ifinbox");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"lmf\"]")));
        String subject = this.driver.findElement(By.xpath("//span[@class=\"lmf\"]")).getText();
        this.driver.switchTo().defaultContent();
        return subject;

    }
    
    public void clickFirstEmailInList(Wait<WebDriver> wait) {
        this.driver.switchTo().frame("ifinbox");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"lmf\"]")));
        this.driver.findElement(By.xpath("//span[@class=\"lmf\"]")).click();
        this.driver.switchTo().defaultContent();
    }
    
    public void clickFinishRegistering(Wait<WebDriver> wait) {
        this.driver.switchTo().frame("ifmail");
        WebElement finishBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Finish registering")));
        String url=finishBtn.getAttribute("href");
        //finishBtn.click();
        this.driver.get(url);
        this.driver.switchTo().defaultContent();
    }
}
