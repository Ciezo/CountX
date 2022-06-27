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


//ANNOTATIONS
@WebService (endpointInterface="com.countx.server.JaxWsServer")
public class JaxWsServerImpl implements JaxWsServer {

	// Attributes
	
	
	@Override
	public Item fetchItem() {
		
		return null;
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
