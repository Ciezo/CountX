/*
    Document   : CodeGen.java
    Package	   : com.countx.server;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is a java file responsible for automating the generation of item code
 */

// PACKAGE
package com.countx.server;


// IMPORT SECTION
import java.util.Random;


public class CodeGen {
	
	private int item_code; 
	
	// Setting the maximum number to generate
	int MAX_THRESHOLD = 1000; 
	
    // Random class for implementing RGN
    private Random random = new Random(); 
    private int rgn = random.nextInt(MAX_THRESHOLD); 
    
    // A method to set the RGN; not more than the MAX_THRESHOLD
    //	then, assign the generated number to our item_code
    public void setRGN() {
        random = new Random(); 				
        rgn = random.nextInt(MAX_THRESHOLD);
        item_code = rgn;
    }
    
    // Return the generated item_code
    public int getRGN() {
    	return item_code;
    }
}
