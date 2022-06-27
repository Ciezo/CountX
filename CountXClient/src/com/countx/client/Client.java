/*
    Document   : Client.java
    Package	   : com.countx.client;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is the Client class for accessing the handles of our Server.
    	Client should be able to access all the Item objects. 
    	Client can also access the methods of the Web Service
*/

// PACKAGE
package com.countx.client;


// IMPORT SECTION
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.countx.server.JaxWsServer;
import com.countx.server.Item;


public class Client {
	
	// Declare the product object of Item class type
	static Item product = null; 
	
	public static void main (String[] args) throws MalformedURLException{
		
		// Properties 
		Item[] item_ls; 
		
		/**
		 * SETTING UP THE PATH AND HANDLE FOR BOTH CLIENT-SERVER
		 * @NOTE: This is where we set up to loop-back into the machine 
		 *        as a server to host the SOAP objects
		 */
		// Set up the URL path
		URL url = new URL("http://localhost:8000/countx?wsdl");
		
		// Set the web service coming from the web server
		QName qname = new QName("http://implement.ws.countx.com/", "JaxWsServerImplService");
				
		// Now, assign the web service along with the URL path
		Service service = Service.create(url, qname); 
						
		// Access the web interface
		JaxWsServer handle = service.getPort(JaxWsServer.class);
		
		
		// Try making requests
		product = new Item("Toothpaste", 150, "Colgate"); 
		handle.addItem(product); 
		
		System.out.println("Product 1"); 
		System.out.println("==========================");
		System.out.println("Name: " + product.getName());
		System.out.println("Product code: " + product.getCode());
		System.out.println("Brand: " + product.getBrand());
		System.out.println("Unit Price: " + product.getPrice());
		System.out.println("==========================");
		
		
		product = new Item(); 
		product.setName("Napkin");
		product.setCode("10000"); 
		product.setBrand("Whisper");
		product.setPrice(220); 
		handle.addItem(product);
		
		System.out.println("Product 2"); 
		System.out.println("==========================");
		System.out.println("Name: " + product.getName());
		System.out.println("Product code: " + product.getCode());
		System.out.println("Brand: " + product.getBrand());
		System.out.println("Unit Price: " + product.getPrice());
		System.out.println("==========================");
		
		item_ls = handle.viewItemInventory(); 
		
		System.out.println("Viewing Items in inventory: "); 
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < item_ls.length; i++) {
			System.out.println("Product Name: " + item_ls[i].getName());
			System.out.println("Product Code: " + item_ls[i].getCode());
			System.out.println("Product Brand: " + item_ls[i].getBrand());
			System.out.println("Unit Price: " + item_ls[i].getPrice()); 
			System.out.println("==========================");
			
		}
		
		
	}
}
