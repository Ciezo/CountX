/*
    Document   : TotalProducts_frame.java
    Package	   : com.countx.windowactivity;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This class is responsible for getting and displaying all the products in a table 
*/

// PACKAGE
package com.countx.windowactivity;


// IMPORT SECTION 
import javax.swing.*;
import java.awt.*;
import com.countx.client.Client;
import com.countx.server.Item;


public class TotalProducts_frame extends JFrame {
	
	// Client to access server handle 
	Client client; 
	
	// Table 
	JTable prod_table; 
	
	// Item 
	Item[] item_ls; 
	
	public TotalProducts_frame() {
		
		// Initialize properties for this frame
		setTitle("Viewing Total Products"); 
		setSize(400, 600);
		setPreferredSize(new Dimension (400, 600));
		setLocationRelativeTo(null); 
		
		// Data to be displayed in the JTable
        /**		 [column]        [column]
         *    	 PRODUCT NAME    PRODUCT CODE   
         * [row]     
         */
		String[] name = new String[10000]; 
		String[] code = new String[10000]; 
		String[][] data = new String[1000][1000];  
		
        // Column Names
        String[] columnNames = {"PRODUCT NAME", "PRODUCT CODE"};
        
        // FIll in the data 
        /**
         * FILL IN THE STRING ARRAY OF name from product name
         */
        // Call the server handle to fetch all inventory contents
        item_ls = Client.handle.viewItemInventory(); 
        /* To populate name[] */
        for (int a = 0; a < item_ls.length; a++) {
        	System.out.println("***Filling in values for Product Name"); 
        	String temp = item_ls[a].getName(); 
        	System.out.println("COPY ELEMENT ====>> " + temp); 
        	name[a] = temp;
        	System.out.println("Saved in String Array: " + name[a]); 
        	data[a][0] = name[a]; 
        }
        /* To populate code[] */
        for (int b = 0; b < item_ls.length; b++) {
        	System.out.println("***Filling in values for Product Code"); 
        	String temp = item_ls[b].getCode(); 
        	System.out.println("COPY ELEMENT ====>> " + temp); 
        	code[b] = temp;
        	System.out.println("Saved in String Array: " + name[b]); 
        	data[b][1] = code[b]; 
        }
        
        /**
         * ACCESS THE data[][]    
         */
        System.out.println("VIEWING DATA[][] FROM 2D STRING ARRAY");  
        for (int row = 0; row < item_ls.length; row++) {
        	for (int col = 0; col < item_ls.length; col++) {
        		System.out.print(data[row][col] + "\t ");
        	}
        }
        
        /**
         * PREPARING THE TABLE    
         */
        // Set up and initialize Table 
        prod_table = new JTable(data, columnNames);
        prod_table.setBounds(30, 40, 400, 600);
        
        // Add the table to scroll pane
        JScrollPane sp = new JScrollPane(prod_table);
        /* Add this to the frame */ 
        this.add(sp);
        
        pack(); 
        setVisible(true);
     
	}
	
}