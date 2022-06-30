/*
    Document   : Categories_frame.java
    Package	   : com.countx.windowactivity;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is how we can retrieve and view all the different categories of the whole inventory
*/

// PACKAGE
package com.countx.windowactivity;


// IMPORT SECTION
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import com.countx.client.Client;
import com.countx.server.Item;


public class Categories_frame extends JFrame {

	// Client to access server handle 
	Client client;
		
	// Item 
	Item[] item_ls; 
	
	// Table 
	JTable cat_table; 
		
	// Table model
	DefaultTableModel tableModel;
	
	public Categories_frame() {
		// Initialize properties for this frame
		setTitle("Viewing Categories"); 
		setSize(400, 600);
		setPreferredSize(new Dimension (400, 600));
		setLocationRelativeTo(null); 
		
		// Call the server handle to fetch all inventory contents
		item_ls = Client.handle.viewItemInventory();		
		String[] cat_arr = new String[10000]; 
		String[] prod_arr = new String[10000];
		/* To populate cat_arr */ 
		for (int i = 0; i < item_ls.length; i++) {
			System.out.println("***Filling in values for Categories"); 
			cat_arr[i] = item_ls[i].getCat();
			System.out.println("Saved in String Array: " + cat_arr[i]); 
		}
		/* To populate prod_arr */ 
		for (int j = 0; j < item_ls.length; j++) {
			System.out.println("***Filling in values for Product Names"); 
			prod_arr[j] = item_ls[j].getName(); 
			System.out.println("Saved in String Array: " + prod_arr[j]); 
		}
		
		/**
		 * SETTING UP THE TABLE MODEL AND ITS OBJECTS 
		 */
		tableModel = new DefaultTableModel(); 
		cat_table = new JTable(tableModel); 
		// Add columns 
		tableModel.addColumn("Category");
		tableModel.addColumn("Product Lists");
		
		/**
		 * ACCESS THE the string arrays: cat_arr and prod_arr
		 */
		System.out.println("VIEWING CATEGORY AND PRODUCT LISTS ARRAYS");  
		for (int k = 0; k < item_ls.length; k++) {
			System.out.println(cat_arr[k]); 
			System.out.println(prod_arr[k]); 			
			/* Create a temp data to allow single entry*/ 
			String temp1 = cat_arr[k]; 
			String temp2 = prod_arr[k]; 			
			// Then, insert that temp data with Object wrapping
			tableModel.insertRow(tableModel.getRowCount(), new Object[] {temp1, temp2});
		}
		
		// Add the table to scroll pane
        JScrollPane sp = new JScrollPane(cat_table);
        /* Add this to the frame */ 
        this.add(sp);
		
        pack(); 
        setVisible(true);
	}
}
