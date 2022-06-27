/*
    Document   : JaxWsServerImpl.java
    Package	   : com.countx.ws.implement;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is where the implementation of web-services from the 
    	web-method interface of the Server side. 
    	
    	Remember that we need to import all the required packages from other projects.
    	Always take note of configuring the build path and include all project folders required
*/

// PACKAGE
package com.countx.ws.implement;


// IMPORT SECTION
import com.countx.server.JaxWsServer;
import javax.jws.WebService;
import com.countx.server.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

//ANNOTATIONS
@WebService (endpointInterface="com.countx.server.JaxWsServer")
public class JaxWsServerImpl implements JaxWsServer {

	// Attributes
	/**
	 *  We need a Map to create a HashMap because what I want to do here is to store everything
	 *  in a Map just like records in a database.
	 */
	Map <String, Item> product = new HashMap<String, Item>();
	
	@Override
	public Item fetchItem(String code) {
		// Access the specific object through the Item code
		if (product.containsKey(code)) {
			return product.get(code); 
		}
		
		return new Item();
	}
	
	@Override
	public String addItem(Item insert_item) {
		
		try {
			product.put(insert_item.getCode(), insert_item); 
			return "INSERT VALUES ===> SUCCESS";
		} 
		
		catch(Exception err) {
			err.printStackTrace();
			return "FAILED ===> ERROR CODE: 1";
		}
		
	}

	@Override
	public Item updateItem(String code, Item update_item) {
		System.out.println("** Updating records");
		product.replace(code, update_item);
		return update_item;
	}

	@Override
	public String removeItem(Item remove_item) {
		
		System.out.println("** Attempting to remove employee from map");
		
		try {
			product.remove(remove_item.getCode());
			System.out.println("Record has been removed!");
			return "SUCCESS";
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return "ERROR IN REMOVING ===> ERROR CODE: 2";
		} 
	}

	@Override
	public Item[] viewItemInventory() {
		// Declare an array list because we want to return this 
		ArrayList<Item> product_record = new ArrayList<Item>();
		
		// Create an instance of Item to empty
		Item item_ls = null; 
		
		/**
		 * @NOTE: Create a for each loop, then, get the entrySet of the product 
		 * 		  It is where we want to plug the entries which will act as an inventory
		 */
		for (Map.Entry<String, Item> entry : product.entrySet()) {
			item_ls = new Item(); 
			item_ls.setName(entry.getValue().getName());
			item_ls.setCode(entry.getKey());
			item_ls.setBrand(entry.getValue().getBrand());
			item_ls.setPrice(entry.getValue().getPrice());
			product_record.add(item_ls); 
		}
		
		
		return (Item []) product_record.toArray(new Item[product_record.size()]);
	}
}
