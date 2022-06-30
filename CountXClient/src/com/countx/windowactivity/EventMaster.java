/*
    Document   : EventMaster.java
    Package	   : com.countx.windowactivity;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is for event handling and event objects
*/

// PACKAGE
package com.countx.windowactivity;


// IMPORT SECTION
import java.awt.event.*;
import java.awt.CardLayout; 
import com.countx.client.Client;
import com.countx.server.Item;

public class EventMaster implements ActionListener{
	
	WindowActivity windowActivity; 
	Client client; 
	Item product; 
	
	TotalProducts_frame tp; 
	
	public EventMaster(WindowActivity windowActivity) {
		this.windowActivity = windowActivity;
	}
	
	
	
	/* 
	 * IMPLEMENTED METHODS 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String commander; 
		e.getSource(); 
		commander = e.getActionCommand(); 
		
		switch(commander) {
			
			case "home":
				System.out.println("***Redirecting to home***");
				System.out.println("=== Dashboard ===");
				System.out.println("Component name: " + windowActivity.dashboardP.getName());
				
				windowActivity.dashboardP.setVisible(true);
				windowActivity.headerTitle.setText("DASHBOARD");
				
				windowActivity.newProductP.setVisible(false);
				windowActivity.updateItemP.setVisible(false);
				windowActivity.removeItemP.setVisible(false);
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "DASHBOARD");
				break; 
		
			case "product":
				System.out.println("***Redirecting to New Product Tasks***");
				System.out.println("=== Tasks: New Product ===");
				System.out.println("Component name: " + windowActivity.newProductP.getName());
				
				windowActivity.newProductP.setVisible(true);
				windowActivity.headerTitle.setText("ADD A NEW PRODUCT");
				
				windowActivity.dashboardP.setVisible(false);
				windowActivity.updateItemP.setVisible(false);
				windowActivity.removeItemP.setVisible(false);
				
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "NEW_PRODUCT");
				break;
			
				
			case "update":
				System.out.println("***Redirecting to Update Item Tasks***");
				System.out.println("=== Tasks: Update Item ===");
				System.out.println("Component name: " + windowActivity.updateItemP.getName());
				
				windowActivity.updateItemP.setVisible(true);
				windowActivity.headerTitle.setText("UPDATE ITEMS IN INVENTORY");
				
				windowActivity.newProductP.setVisible(false);				
				windowActivity.dashboardP.setVisible(false);
				windowActivity.removeItemP.setVisible(false);
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "UPDATE");
				break; 
			
			case "remove":
				System.out.println("***Redirecting to Remove Item Tasks s***");
				System.out.println("=== Tasks: Remove Item ===");
				System.out.println("Component name: " + windowActivity.removeItemP.getName());
				
				windowActivity.removeItemP.setVisible(true);
				windowActivity.headerTitle.setText("REMOVE ANY ITEM FROM INVENTORY");
				
				windowActivity.updateItemP.setVisible(false);
				windowActivity.newProductP.setVisible(false);				
				windowActivity.dashboardP.setVisible(false);
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "REMOVE");
				break; 
			
			case "new_product":
				product = new Item(); 
				
				String set_productName = windowActivity.getProdName_field.getText(); 
				String set_productPrice = windowActivity.getPrice_field.getText(); 
				String set_Brand = windowActivity.getBrand_field.getText(); 
				String set_Cat = windowActivity.getCat_field.getText(); 
				
				 int parse_price = Integer.parseInt(set_productPrice);
				
				product = new Item(set_productName, parse_price, set_Brand, set_Cat); 
				Client.handle.addItem(product);
				
				/** 
				 *  DISPLAY TO CONSOLE THE NEW ITEM OBJECTS
				 */
				System.out.println("Saved changes!");
				System.out.println("New Product"); 
				System.out.println("==========================");
				System.out.println("Name: " + product.getName());
				System.out.println("Product code: " + product.getCode());
				System.out.println("Brand: " + product.getBrand());
				System.out.println("Category: " + product.getCat());
				System.out.println("Unit Price: " + product.getPrice());
				System.out.println("==========================");
				
				break; 
			
			case "update_product":
				product = new Item(); 
				
				String getExisting_prodCode = windowActivity.getUpdate_prodCode_field.getText(); 
				String update_prodName = windowActivity.getUpdate_prodName_field.getText(); 
				String update_prodPrice = windowActivity.getUpdate_prodPrice_field.getText(); 
				String update_prodBrand = windowActivity.getUpdate_prodBrand_field.getText(); 
				String update_prodCat = windowActivity.getUpdate_prodCat_field.getText(); 
				
				int parsed_updatePrice = Integer.parseInt(update_prodPrice);
				
				product.setName(update_prodName);
				product.setPrice(parsed_updatePrice);
				product.setBrand(update_prodBrand);
				product.setCat(update_prodCat);
				
				Client.handle.updateItem(getExisting_prodCode, product); 
				
				/** 
				 *  DISPLAY TO CONSOLE THE UPDATED OBJECTS
				 */
				System.out.println("UPDATED CHANGES APPLIED!");
				System.out.println("New Product"); 
				System.out.println("==========================");
				System.out.println("Name: " + product.getName());
				System.out.println("Entered Product code: " + getExisting_prodCode);
				System.out.println("Brand: " + product.getBrand());
				System.out.println("Category: " + product.getCat());
				System.out.println("Unit Price: " + product.getPrice());
				System.out.println("==========================");
				
				break; 
			
			case "get_product_code":
				/**
				 * @NOTE: WE NOW HAVE IMPLEMENTED THE AUTO GENERATION OF PRODUCT CODE 
				 * 		  INSTEAD OF CLICKING THE genCode: JButton 
				 */
				break; 
			
			case "remove_product":
				product = new Item();
				
				String ID_entryToRemove = windowActivity.getRemProd_field.getText(); 
				
				product.setCode(ID_entryToRemove);
				product.setName(Client.handle.fetchItem(ID_entryToRemove).getName());
				product.setPrice(Client.handle.fetchItem(ID_entryToRemove).getPrice());
				product.setBrand(Client.handle.fetchItem(ID_entryToRemove).getBrand());
				product.setCat(Client.handle.fetchItem(ID_entryToRemove).getCat());
				
				Client.handle.removeItem(product); 
				
				break; 
			
			case "check_db":
				new Records_frame(); 
				
				break; 
			
			case "total_products": 
				new TotalProducts_frame(); 
				
				break; 
				
			case "total_brands":
				new Brands_frame(); 
				
				break; 
			
			case "total_cat":
				new Categories_frame();
				
				break;
			
			case "total_records": 
				new Records_frame(); 
				
				break; 
		}
	}

}
