/*
    Document   : WindowActivity.java
    Package	   : com.countx.windowactivity;
    Created on : June 28, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This class is responsible for managing and handling the GUI elements with
    	Java Swing Library
*/

// PACKAGE
package com.countx.windowactivity;


// IMPORT SECTION 
import javax.swing.*;
import java.awt.*;


public class WindowActivity extends JFrame {
	
	// Panels 
	JPanel contentP; 
	JPanel headerP; 
	JPanel sidebarP; 
	JPanel logoP;
	JPanel padding;
	
	// Labels 
	JLabel tasks; 
	JLabel appLogo;
	JLabel appIcon;
	JLabel headerTitle; 
	
	// Buttons
	JButton newProduct_btn;
	JButton setBrand_btn;
	JButton removeItem_btn;
	
	// Font
	Font seoge = new Font("Segoe UI", Font.PLAIN, 12); 
	
	// Icon and Image
	ImageIcon logo = new ImageIcon("assets/icon/logo.png"); 
	
	
	public WindowActivity() {
		
		// Initialize the properties of this Frame	
		setTitle("CountX Inventory Based Application by Cloyd Van S. Secuya"); 		// Set the window title
		setSize(800, 400);															// Set the size of the window
		setPreferredSize(new Dimension(800, 400));									// Set the preferred component size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 							// Exit and kill the process on close of the app
		setLocationRelativeTo(null);  												// Upon launching the window, set it to the center of the screen
		
		
		// Initialize the elements and components
		initComponents(); 
		
		// Add the initialized components
		addComponents();
		
		// Pack up the frame 
		pack();
	}
	
	private void initComponents() {
		// Initialize Panels
		contentP = new JPanel(); 
		headerP = new JPanel(); 
		sidebarP = new JPanel(); 
		logoP = new JPanel();
		padding = new JPanel();
		
		contentP.setPreferredSize(new Dimension(800, 400));
		headerP.setPreferredSize(new Dimension(800, 30));
		sidebarP.setPreferredSize(new Dimension(120, 400));
		logoP.setOpaque(false);
		padding.setOpaque(false);
		
		// Set the background color
		contentP.setBackground(Color.WHITE);
		headerP.setBackground(new Color(37, 54, 70));
		sidebarP.setBackground(new Color(37, 54, 70));
		
		// Initialize labels
		tasks = new JLabel("TASKS", JLabel.CENTER);
		headerTitle = new JLabel("DASHBOARD", JLabel.CENTER);
		
		newProduct_btn = new JButton("New Product");
		setBrand_btn = new JButton("Set up brand");
		removeItem_btn = new JButton("Remove Item");
		
		// Set up background color
		newProduct_btn.setBackground(new Color(37, 54, 70 ));
		setBrand_btn.setBackground(new Color(37, 54, 70 ));
		removeItem_btn.setBackground(new Color(37, 54, 70 ));

		// Set up font and foreground color
		tasks.setFont(seoge);
		tasks.setForeground(Color.WHITE);
		headerTitle.setFont(seoge);
		headerTitle.setForeground(Color.WHITE);
		newProduct_btn.setFont(seoge);
		newProduct_btn.setForeground(Color.WHITE);
		setBrand_btn.setFont(seoge);
		setBrand_btn.setForeground(Color.WHITE); 
		removeItem_btn.setFont(seoge);
		removeItem_btn.setForeground(Color.WHITE);
		
		
		// Set up logo and icon
		appLogo = new JLabel(logo);
		appIcon = new JLabel("AppIcon", JLabel.CENTER);
		padding.setPreferredSize(new Dimension(50, 130));
		padding.setMaximumSize(getMaximumSize().getSize());
		
		/**
		 * @NOTE: ADDING THE COMPONENTS TO THEIR RESPECTIVE PANELS  
		 */
		// Header Panel
		headerP.add(headerTitle);
		
		// Logo Panel
		logoP.add(appLogo);
		
		// Side bar Panel 
		sidebarP.add(tasks);
		sidebarP.add(newProduct_btn);
		sidebarP.add(setBrand_btn);
		sidebarP.add(removeItem_btn);
		sidebarP.add(padding);
		sidebarP.add(logoP);
		
		// Content Panel
		
	}
	
	private void addComponents() {
		/**
		 *  @NOTE: ADDING THE INITIALIZED COMPONENTS TO THE FRAME
		 */
		add(headerP, BorderLayout.NORTH); 
		add(sidebarP, BorderLayout.WEST);
		add(contentP, BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowActivity().setVisible(true);
            }
        });
	}
	
}
