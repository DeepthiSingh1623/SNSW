/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHelpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Kurt
 */
public class DemeritsFile {
    
    private final String filename;
    private String line;
    private String emailAccount;
    private String password;
    
    
    public DemeritsFile(String filename) {
        this.filename = filename;
    }
    
    
    /*
     *  idx is zero based index.
    */
    public boolean readLine(int idx) {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(this.filename);
        
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String l;
            this.line = null;
            this.emailAccount = null;
            this.password = null;
            int count = 0;
            idx++;              //  ignore the first line as a comment
            while ((l = reader.readLine()) != null) {
                if (count == idx) {
                    this.line = l;
                    String[] tokens = l.split(",");
                    
                    if (tokens.length == 2) {
                        this.emailAccount = tokens[0];
                        this.password = tokens[0];
                    }
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return false;
    }
    
    
    public String getEmailAddress() {
        return this.emailAccount;
    }
    
    
    public String getPassword() {
        return this.password;
    }
}
