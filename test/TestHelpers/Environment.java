/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHelpers;

import java.util.Random;

/**
 *
 * @author Kurt
 */
public class Environment {
    
    private final String LoadTestURLCS5 = "https://lt-snsw.cs5.force.com/";
    private final String LoadTestURLCS6 = "https://loadtest-snsw.cs6.force.com/";
    private final String CreateAccountPath = "MyServiceNSW/index#/createAccount";
    private final String IT2URL = "";
    private final String IT3URL = "";
    
    public enum Env {
         LTCS5
        ,LTCS6
        ,IT2
        ,IT3
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
}
