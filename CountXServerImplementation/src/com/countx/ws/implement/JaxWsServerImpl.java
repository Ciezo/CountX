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
		
		return null;
	}

	@Override
	public Item updateItem(Item update_item) {
		
		return null;
	}

	@Override
	public String removeItem(Item remove_item) {
		
		return null;
	}

	@Override
	public Item[] viewItemInventory() {
		
		return null;
	}


}
