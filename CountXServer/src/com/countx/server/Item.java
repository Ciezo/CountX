/*
    Document   : Item.java
    Package	   : com.countx.server;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This java class file is for defining the main "object" to be used and interacted 
    	by the web services and its implementation. 
    	
    	Moreover, Item class needs to have the following attributes 
    		1. Name
    		2. Code 
    		3. Brand
    		4. Unit price
    	
    	Therefore, as we can see, this "Item" class is just like a product in an inventory. 
    	And so, we can at least create an object product with the declaration of 
    		Item product = new Item() 
    	
    	Our main task here is to make this product accessible to the user by means of web-services
    	with JAX-WS binded with SOAP Protocol
    	
    	Lastly, we want to apply encapsulation here as always.

*/

// PACKAGE
package com.countx.server;


public class Item {
	
	private String name; 
	private String code; 
	private String brand;
	private String category;
	private int price;
	
	// Instantiate the CodeGen class so we can get the RGN
	private CodeGen generate = new CodeGen();
	
	public Item(String name, int price, String brand, String category) {
		this.name = name; 
		generate.setRGN();
		this.code = generate.genKEY();
		this.brand = brand;
		this.category = category;
		this.price = price; 		
	}
	
	public Item() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name; 
	}
	
	public void setCode(String code) {
		this.code = code; 				
	}
	
	public String getCode() {
		return code;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setCat(String category) {
		this.category = category; 
	}
	
	public String getCat() {
		return category; 
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
}
