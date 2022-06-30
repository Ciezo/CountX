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

import com.countx.client.Client;
import com.countx.server.Item;

import java.awt.*;


public class Records_frame extends JFrame {
	
	// Client to access server handle 
	Client client;
			
	// Item 
	Item[] item_ls; 
		
	// Table 
	JTable records_table; 
			
	// Table model
	DefaultTableModel tableModel;
	
	public Records_frame() {
		// Initialize properties for this frame
		setTitle("Total Inventory Records"); 
		setSize(800, 600);
		setPreferredSize(new Dimension (800, 600));
		setLocationRelativeTo(null); 
		
		// Call the server handle to fetch all inventory contents
		item_ls = Client.handle.viewItemInventory();
		/**
		 * @NOTE: I NEED TO RETRIEVE ALL THE INDIVIDUAL ITEMS
		 */
		String[] prod_arr = new String[10000];
		String[] code_arr = new String[10000]; 
		String[] price_arr = new String[10000]; 
		String[] brand_arr = new String[10000]; 
		String[] cat_arr = new String[10000]; 
		/* To populate prod_arr */
		for (int i = 0; i < item_ls.length; i++) { prod_arr[i] = item_ls[i].getName(); }
		/* To populate code_arr */ 
		for (int j = 0; j < item_ls.length; j++) { code_arr[j] = item_ls[j].getCode(); }
		/* To populate price_arr */ 
		for (int j = 0; j < item_ls.length; j++) { 
			int temp = item_ls[j].getPrice(); 
			price_arr[j] = String.valueOf(temp); 
		}
		/* To populate brand_arr */ 
		for (int k = 0; k < item_ls.length; k++) { brand_arr[k] = item_ls[k].getBrand(); }
		/* To populate cat_arr */ 
		for (int l = 0; l < item_ls.length; l++) { cat_arr[l] = item_ls[l].getCat(); }
		
		/**
		 * SETTING UP THE TABLE MODEL AND ITS OBJECTS 
		 */
		tableModel = new DefaultTableModel(); 
		records_table = new JTable(tableModel); 
		// Add columns
		tableModel.addColumn("Product Name");
		tableModel.addColumn("Product Code");
		tableModel.addColumn("Price");
		tableModel.addColumn("Brand");
		tableModel.addColumn("Category");
		
		for (int m = 0; m < item_ls.length; m++) {
			String temp1, temp2, temp3, temp4, temp5;
				temp1 = prod_arr[m]; 
				temp2 = code_arr[m]; 
				temp3 = price_arr[m]; 
				temp4 = brand_arr[m]; 
				temp5 = cat_arr[m]; 
			// Insert and try to make entry to the table
			tableModel.insertRow(tableModel.getRowCount(), new Object[] {temp1, temp2, temp3, temp4, temp5});
		}
		
		// Add the table to scroll pane
        JScrollPane sp = new JScrollPane(records_table);
        /* Add this to the frame */ 
        this.add(sp);
		
        pack(); 
        setVisible(true);
	}
}
