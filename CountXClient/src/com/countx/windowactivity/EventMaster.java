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

public class EventMaster implements ActionListener, KeyListener {
	
	WindowActivity windowActivity; 
	
	
	public EventMaster(WindowActivity windowActivity) {
		this.windowActivity = windowActivity;
	}
	
	
	
	/* 
	 * IMPLEMENTED METHODS 
	 */
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

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
				
				windowActivity.newProductP.setVisible(false);
				windowActivity.setBrandP.setVisible(false);
				windowActivity.removeItemP.setVisible(false);
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "DASHBOARD");
				break; 
		
			case "product":
				System.out.println("***Redirecting to New Product Tasks***");
				System.out.println("=== Tasks: New Product ===");
				System.out.println("Component name: " + windowActivity.newProductP.getName());
				
				windowActivity.newProductP.setVisible(true);
				
				windowActivity.dashboardP.setVisible(false);
				windowActivity.setBrandP.setVisible(false);
				windowActivity.removeItemP.setVisible(false);
				
				
//				((CardLayout) windowActivity.contentP.getLayout()).show(windowActivity.contentP, "NEW_PRODUCT");
				break;
			
				
			case "brand":
				
				
				break; 
			
			case "remove":
				
				
				break; 
		}
	}

}
