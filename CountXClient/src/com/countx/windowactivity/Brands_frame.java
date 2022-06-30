/*
    Document   : Brands_frame.java
    Package	   : com.countx.windowactivity;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is how we can retrieve and view the list of brands from the inventory
*/

// PACKAGE
package com.countx.windowactivity;


// IMPORT SECTION 
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import com.countx.client.Client;
import com.countx.server.Item;


public class Brands_frame extends JFrame {
	
	// Client to access server handle 
	Client client;
	
	// Item 
	Item[] item_ls; 
	
	// Table 
	JTable brand_table; 
	
	// Table model
	DefaultTableModel tableModel;
	
	public Brands_frame() {
		// Initialize properties for this frame
		setTitle("Viewing Brands of Products"); 
		setSize(400, 600);
		setPreferredSize(new Dimension (400, 600));
		setLocationRelativeTo(null); 
		
		// Call the server handle to fetch all inventory contents
		item_ls = Client.handle.viewItemInventory(); 
		/* To populate brand_arr */
		String[] brand_arr = new String[10000]; 
		for (int i = 0; i < item_ls.length; i++) {
			System.out.println("***Filling in values for Brands"); 
			brand_arr[i] = item_ls[i].getBrand(); 
			System.out.println("Saved in String Array: " + brand_arr[i]); 
		}
		
		/**
		 * SETTING UP THE TABLE MODEL AND ITS OBJECTS 
		 */
		tableModel = new DefaultTableModel(); 
		brand_table = new JTable(tableModel); 
		// Add Column 
		tableModel.addColumn("List of Product Brands"); 
		
		/**
		 * ACCESS THE brand_arr[]
		 */
		System.out.println("VIEWING BRAND_ARR[] FROM STRING ARRAY");  
		for (int j = 0; j < item_ls.length; j++) {
			System.out.println(brand_arr[j]); 
			/* Create a temp data to allow single entry*/ 
			String temp = brand_arr[j]; 
			// Then, insert that temp data with Object wrapping
			tableModel.insertRow(tableModel.getRowCount(), new Object[] {temp});
		}
		
		// Insert and create entries 
		/**
		 * @NOTE: THIS DOES NOT WORK BECAUSE IT ONLY INSERTS THE FIRST ELEMENT OF BRAND_ARR[]
		 */
//		tableModel.insertRow(tableModel.getRowCount(), brand_arr);
//		tableModel.insertRow(0, brand_arr);
		
		// Add the table to scroll pane
        JScrollPane sp = new JScrollPane(brand_table);
        /* Add this to the frame */ 
        this.add(sp);
		
        pack(); 
        setVisible(true);
	}
}