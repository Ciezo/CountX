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

import com.countx.server.Item;
import com.countx.server.JaxWsServer;
import com.countx.windowactivity.WindowActivity;
import com.countx.ws.implement.ServicePublisher;


public class Client {
	
	// Declare the product object of Item class type
	public Item product = null; 
	
	// Server handle 
	public static JaxWsServer handle; 
	
	public static void main (String[] args) throws MalformedURLException{
		
		// End point and Service publisher
		ServicePublisher.main(null);
		
		// UI 
		WindowActivity windowActivity = new WindowActivity(); 
		
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
		handle = service.getPort(JaxWsServer.class);
		
		item_ls = handle.viewItemInventory(); 
		
		System.out.println("RETRIEVING ITEMS FROM THE SERVER: "); 
		/*"LOADING" SCREEN */
		System.out.print("[");
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) { e.printStackTrace();} 
				System.out.print("=");
			}
			System.out.print("]");
			System.out.println("\n\n");
			
		for (int i = 0; i < item_ls.length; i++) {
			System.out.println("Product Name: " + item_ls[i].getName());
			System.out.println("Product Code: " + item_ls[i].getCode());
			System.out.println("Product Brand: " + item_ls[i].getBrand());
			System.out.println("Product Category: " + item_ls[i].getCat());
			System.out.println("Unit Price: " + item_ls[i].getPrice()); 
			System.out.println("-----------------------------------------------------");
			
		}
	}
}
