/*
    Document   : JaxWsServer.java
    Package	   : com.countx.server;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is where we define and construct our interfaces for the web-methods
    	on the server side. 
    	
    	Objectives: 
			1.	To help the user know about different categories of Product in their inventory
			2.	To help the user add items to the inventory 
			3.	To help the user update items to the inventory 
			4.	To help the user remove items from the inventory
			5.	To help the user view items in their whole inventory

 */

// PACKAGE
package com.countx.server;


// IMPORT SECTION
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


//ANNOTATIONS
@WebService
@SOAPBinding (style=Style.RPC)
public interface JaxWsServer {
	/**
	 *  Create interfaces with WebMethod wrapping
	 */
	
	// Interface to fetch items as general to access attributes
	@WebMethod Item fetchItem(String code);
	
	// Interface for adding items to the inventory
	@WebMethod String addItem(Item insert_item);
	
	// Interface for updating items to the inventory
	@WebMethod Item updateItem(String code, Item update_item);
	
	// Interface for removing items from the inventory
	@WebMethod String removeItem(Item remove_item);
	
	// Interface for viewing items from the whole inventory
	@WebMethod Item [] viewItemInventory();
	
}
