/*
    Document   : ServicePublisher.java
    Package	   : com.countx.ws.implement;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	It is where we try to publish the server-implementation through an Endpoint.
*/

// PACKAGE
package com.countx.ws.implement;


// IMPORT SECTION
import javax.xml.ws.Endpoint;


public class ServicePublisher {
	/* We run this main method to deploy our server on live state so it can run */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8000/countx", new JaxWsServerImpl()); 
	}
}
