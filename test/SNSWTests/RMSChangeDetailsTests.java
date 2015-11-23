/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SNSWTests;

import SNSWWebPages.RMSChangeDetailsPage;
import TestHelpers.Environment;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

/**
 *
 * @author Kurt
 */
public class RMSChangeDetailsTests {
    
    
    
    public static void UC20_AU001_checkRMSChangeDetailsElements(WebDriver driver, Wait<WebDriver> wdwait, Environment env, String filepath) {

        boolean success = true;
        driver.get(env.getRMSChangeDetailsURL());
        
        RMSChangeDetailsPage rcdp = new RMSChangeDetailsPage(driver);
        rcdp.waitForElements(wdwait);
        env.takeSnapshot(driver, filepath + "01_InitialLoad.png");
        
        if (!rcdp.findHeading()) {
            success = false;
            env.takeSnapshot(driver, filepath + "02_ERROR Header not found or text different.png");
        } else {
            env.takeSnapshot(driver, filepath + "02_Elements and Fields found.png");
        }
        
        if (!rcdp.findStep1Element()) {
            success = false;
            env.takeSnapshot(driver, filepath + "03_ERROR Step 1_5.png");
        } else {
            env.takeSnapshot(driver, filepath + "03_Step 1_5.png");
        }
        
        List<String> expected = new ArrayList<String>();
        expected.add("Change NSW Driver Licence, NSW Photo Card and vehicle registration contact details");
        expected.add("Change vehicle garaging details");
        expected.add("Change NSW Boat Licence, vessel registration or other maritime product contact details");
        expected.add("Change E-Toll contact details");
        expected.add("Change contact details with other NSW government agencies");
        if (!rcdp.findOptionElemnts(expected)) {
            success = false;
            env.takeSnapshot(driver, filepath + "04_ERROR Missing fields or elements.png");
        } else {
            env.takeSnapshot(driver, filepath + "04_Elements and Fields found.png");
        }
        
        if (!rcdp.findNextButton()) {
            success = false;
            env.takeSnapshot(driver, filepath + "05_ERROR Next Button.png");
        } else {
            env.takeSnapshot(driver, filepath + "05_Next Button.png");
        }


        if (!success) {
            Assert.fail("Errors found check snapshots and output");
        }
    }
}
