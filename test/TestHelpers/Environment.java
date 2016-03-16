/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHelpers;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Kurt
 */
public class Environment {
    
    private final String LoadTestURLCS5 = "https://lt-snsw.cs5.force.com/";
    private final String LoadTestURLCS6 = "https://loadtest-snsw.cs6.force.com/";
    private final String CreateAccountPath = "MyServiceNSW/index#/createAccount";
    private final String RMSChangeDetailsPath = "MyServiceNSW/index#/rms/changeDetails";
    private final String CheckRegoDetailsPath = "MyServiceNSW/index#/rms/freeRegoCheck/details";
    private final String IT2URL = "https://it2-snsw.cs31.force.com/";
    private final String IT3URL = "https://it3-snsw.cs6.force.com/";
    private final String PSMURL = "https://psm-snsw.cs6.force.com/";
    
    private final String LTCS6CheckDemeritsCsvPath = ".\\data\\LTCS6CheckDemerits.csv";
    private final String LTCS6LoginsCsvPath = ".\\data\\LTCS6CheckDemerits.csv";
    
    public enum Env {
         LTCS5
        ,LTCS6
        ,IT2
        ,IT3
        ,PSM
    }
    
    
    private final Env currentEnvironment;
    
    public Environment(Environment.Env env) {
        this.currentEnvironment = env;
    }
    
    public String getBaseURL() {
        switch(this.currentEnvironment) {
            case LTCS5:
                return LoadTestURLCS5;

            case LTCS6:
                return LoadTestURLCS6;
                
                
            case IT2:
                return IT2URL;
            case IT3:
                return IT3URL;  
                
            case PSM:
                return PSMURL;   
            default:
                return null;
        }
    }
    
    
    public String getCreateAccountURL() {
        switch(this.currentEnvironment) {
            case LTCS5:
                return LoadTestURLCS5 + CreateAccountPath;
                
            case LTCS6:
                return LoadTestURLCS6 + CreateAccountPath;
            
            case IT2:
                return IT2URL + CreateAccountPath;
                
            case IT3:
                return IT3URL + CreateAccountPath;
               
            case PSM:
                return PSMURL + CreateAccountPath;
                
            default:
                return null;
        }
    }
    
    public String getRMSChangeDetailsURL() {
        switch(this.currentEnvironment) {
            case LTCS5:
                return LoadTestURLCS5 + RMSChangeDetailsPath;
                
            case LTCS6:
                return LoadTestURLCS6 + RMSChangeDetailsPath;
            
            case IT2:
                return IT2URL + RMSChangeDetailsPath;
             
            case IT3:
                return IT3URL + RMSChangeDetailsPath;
                
            case PSM:
                return PSMURL + RMSChangeDetailsPath;     
                
            default:
                return null;
        }
    }
    
    public String getCheckRegoURL() {
        switch(this.currentEnvironment) {
            case LTCS5:
                return LoadTestURLCS5 + CheckRegoDetailsPath;
                
            case LTCS6:
                return LoadTestURLCS6 + CheckRegoDetailsPath;
            
            case IT2:
                return IT2URL + CheckRegoDetailsPath;
                
            case IT3:
                return IT3URL + CheckRegoDetailsPath;
                
            case PSM:
                return PSMURL + CheckRegoDetailsPath;
                
            default:
                return null;
        }
    }
    
    
    public String getExistingEmailAddress() {
        switch(this.currentEnvironment) {
            case LTCS6:
                return "John_Peter_Smyth@yopmail.com";
                
            default:
                return null;
        }
    }
    
    
    public String getExistingEmailAddressPassword() {
        switch(this.currentEnvironment) {
            case LTCS6:
                return "%Preferences10";
                
            default:
                return null;
        }
    }
    
    
    public String getLoginsFilePath() {
        switch(this.currentEnvironment) {
            case LTCS6:
                return LTCS6LoginsCsvPath;
                
            default:
                return null;
        }
    }
    
    
    public String getDemeritsFilePath() {
        switch(this.currentEnvironment) {
            case LTCS6:
                return LTCS6CheckDemeritsCsvPath;
                
            default:
                return null;
        }
    }
    
    
    public final static String randomString(final int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            char c = chars[r.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
    
    
    public void takeSnapshot(WebDriver driver, String filename) {
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filename));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
}
