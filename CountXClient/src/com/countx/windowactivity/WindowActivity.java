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
	
	// Layout Manager
	CardLayout card; 
	
	// Panels 
	JPanel contentP; 
		JPanel dashboardP; 
		JPanel newProductP; 
		JPanel updateItemP; 
		JPanel removeItemP; 
	JPanel headerP; 
	JPanel sidebarP; 
	JPanel logoP;
	JPanel padding;
	
	// Labels 
	JLabel tasks; 
	JLabel appLogo;
	JLabel appIcon;
	JLabel headerTitle; 
	JLabel prodName; 
	JLabel price; 
	JLabel cat; 
	JLabel prodCode; 
	JLabel update_prodCode; 
	JLabel update_prodName; 
	JLabel update_prodPrice; 
	JLabel update_prodBrand; 
	JLabel update_prodCat; 
	JLabel brands2; 
	JLabel enlistProd;
	JLabel remProd; 
	JLabel remBrand; 
	JLabel remCat; 
	JLabel remHint;
	
	// Text fields
	JTextField getProdName_field;
	JTextField getPrice_field;
	JTextField getCat_field;
	JTextField getBrand_field; 
	JTextField getProdCode_field;
	JTextField getRemProd_field; 
	JTextField getRemBrand_field; 
	JTextField getRemCat_field; 
	JTextField getUpdate_prodCode_field;
	JTextField getUpdate_prodName_field;
	JTextField getUpdate_prodPrice_field;
	JTextField getUpdate_prodBrand_field;
	JTextField getUpdate_prodCat_field;
	
	// Combo boxes 
	JComboBox getBrands_box; 
	JComboBox getEnlistProd_box; 
	
	// Buttons
	JButton newProduct_btn;
	JButton updateItem_btn;
	JButton removeItem_btn;
	JButton home_btn; 
	JButton totalProducts_dash_btn; 
	JButton brands_dash_btn; 
	JButton categories_dash_btn; 
	JButton records_dash_btn; 
	JButton genCode;
	JButton saveChanges;
	JButton saveChanges2;
	JButton ok_btn; 
	JButton ok_btn2; 
	JButton ok_btn3; 
	JButton remHint_btn;
	
	// Font
	Font seoge = new Font("Segoe UI", Font.PLAIN, 12); 
	Font seoge2 = new Font("Segoe UI", Font.PLAIN, 36); 
	Font calibri = new Font("Calibri", Font.PLAIN, 18);
	
	// Icon and Image
	ImageIcon logo = new ImageIcon("assets/icon/logo.png"); 
	ImageIcon home = new ImageIcon("assets/icon/home.png");
	
	/*
	 *  EVENT MASTER for registering components, adding listeners, 
	 *  and setting up action commands
	 */
	// Event handling
	EventMaster eventhandler = new EventMaster(WindowActivity.this); 
	
	public WindowActivity() {
		
		// Initialize the properties of this Frame	
		setTitle("CountX Inventory Based Application by Cloyd Van S. Secuya"); 		// Set the window title
		setSize(960, 720);															// Set the size of the window
		setResizable(false);														// No window resizing
		setPreferredSize(new Dimension(960, 720));									// Set the preferred component size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 							// Exit and kill the process on close of the app
		setLocationRelativeTo(null);  												// Upon launching the window, set it to the center of the screen
		
		
		// Initialize the elements and components
		initComponents(); 
		
		// Add the initialized components
		addComponents();
		
		// Add action commands
		actionCommander();
		
		// Add Listeners 
		addListeners(); 
		
		// Pack up the frame 
		pack();
		
		// Display the frame
		setVisible(true);
	}
	
	/*
	 * METHOD TO INITIALIZE ALL GLOBAL COMPONENTS
	 * */
	private void initComponents() {

		// Initialize Panels
		contentP = new JPanel(); 
			dashboardP = new JPanel(new GridLayout(4, 1, 5, 5));
			newProductP = new JPanel(new GridLayout(12, 1, 10, 10));
			updateItemP = new JPanel(new GridLayout(11, 1, 10, 10));		
			removeItemP = new JPanel(new GridLayout(7, 2, 10, 10)); 
		headerP = new JPanel(new BorderLayout()); 
		sidebarP = new JPanel(); 
		logoP = new JPanel();
		padding = new JPanel();
		
		// Panel Sizing
		contentP.setPreferredSize(new Dimension(960, 720));
		headerP.setPreferredSize(new Dimension(800, 50));
		sidebarP.setPreferredSize(new Dimension(120, 400));
		
		// Panel Set Transparency
		logoP.setOpaque(false);
		padding.setOpaque(false);
		dashboardP.setOpaque(false);
		newProductP.setOpaque(false);
		updateItemP.setOpaque(false);
		removeItemP.setOpaque(false);
		
		// Set the background color
		contentP.setBackground(Color.WHITE);
		headerP.setBackground(new Color(37, 54, 70));
		sidebarP.setBackground(new Color(37, 54, 70));
		
		// Initialize labels
		tasks = new JLabel("TASKS", JLabel.CENTER);
		headerTitle = new JLabel("DASHBOARD", JLabel.CENTER);
		prodName = new JLabel("Product Name", JLabel.LEFT);
		price = new JLabel("Price", JLabel.LEFT); 
		cat = new JLabel("Category", JLabel.LEFT);
		prodCode = new JLabel("Product Code", JLabel.LEFT);
		update_prodCode = new JLabel("Enter Product Code", JLabel.LEFT);
		update_prodName = new JLabel("Update Product Name", JLabel.LEFT); 
		update_prodPrice = new JLabel("Update Product Price", JLabel.LEFT); 
		update_prodBrand = new JLabel("Update Product Brand", JLabel.LEFT); 
		update_prodCat = new JLabel("Update Product Category", JLabel.LEFT); 
		brands2 = new JLabel("Brands", JLabel.LEFT);
		enlistProd = new JLabel("Enlist and assign product", JLabel.LEFT); 
		remProd = new JLabel("Remove Product", JLabel.LEFT); 
		remBrand = new JLabel("Remove Brand", JLabel.LEFT); 
		remCat = new JLabel("Remove Category"); 
		remHint = new JLabel("Remember that you are deleting an entire entry from the database! Please, enter the product code"); 
		
		// Initialize the text fields
		getProdName_field = new JTextField();
		getPrice_field = new JTextField();
		getCat_field = new JTextField(); 
		getBrand_field = new JTextField(); 
		getProdCode_field = new JTextField();
		getRemProd_field = new JTextField(); 
		getRemBrand_field = new JTextField(); 
		getRemCat_field = new JTextField(); 
		getUpdate_prodCode_field = new JTextField(); 
		getUpdate_prodName_field = new JTextField(); 
		getUpdate_prodPrice_field = new JTextField(); 
		getUpdate_prodBrand_field = new JTextField(); 
		getUpdate_prodCat_field = new JTextField(); 
		
		// Initialize combo-boxes and its String lists of content 
		String[] brands_ls = {
				
	    };
		
		getBrands_box = new JComboBox<>(brands_ls); 
		getEnlistProd_box = new JComboBox<>(brands_ls); 
		
		// Initialize the buttons
		newProduct_btn = new JButton("New Product");
		updateItem_btn = new JButton("Update Item");
		removeItem_btn = new JButton("Remove Item");
		home_btn = new JButton(home);		
		totalProducts_dash_btn = new JButton("Total Products");
		brands_dash_btn = new JButton("Brands");
		categories_dash_btn = new JButton("Categories");
		records_dash_btn = new JButton("Records"); 
		genCode = new JButton("Generate Code");
		saveChanges = new JButton("Save Changes"); 
		saveChanges2 = new JButton("Save Changes"); 
		ok_btn = new JButton("OK"); 
		ok_btn2 = new JButton("OK"); 
		ok_btn3 = new JButton("OK"); 
		remHint_btn = new JButton("Check Global Records!"); 
		
		// Set up text field properties
		getProdName_field.setPreferredSize(new Dimension(800, 30));
		getPrice_field.setPreferredSize(new Dimension(800, 30));
		getCat_field.setPreferredSize(new Dimension(800, 30));
		getBrand_field.setPreferredSize(new Dimension(800, 30));
		getProdCode_field.setPreferredSize(new Dimension(800, 30));
		getRemProd_field.setPreferredSize(new Dimension(800, 30));
		getRemBrand_field.setPreferredSize(new Dimension(800, 30));
		getRemCat_field.setPreferredSize(new Dimension(800, 30));
		getUpdate_prodCode_field.setPreferredSize(new Dimension(800, 30)); 
		getUpdate_prodName_field.setPreferredSize(new Dimension(800, 30)); 
		getUpdate_prodPrice_field.setPreferredSize(new Dimension(800, 30)); 
		getUpdate_prodBrand_field.setPreferredSize(new Dimension(800, 30)); 
		getUpdate_prodCat_field.setPreferredSize(new Dimension(800, 30)); 
		
		// Set up combo-boxes
		getBrands_box.setPreferredSize(new Dimension(800, 30));
		getEnlistProd_box.setPreferredSize(new Dimension(800, 30)); 
		
		// Set up button properties
		/* Home Button*/
		home_btn.setOpaque(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setBorderPainted(false);
		
		/* Dash board buttons */
		totalProducts_dash_btn.setHorizontalAlignment(SwingConstants.RIGHT);
		brands_dash_btn.setHorizontalAlignment(SwingConstants.RIGHT);
		categories_dash_btn.setHorizontalAlignment(SwingConstants.RIGHT);
		records_dash_btn.setHorizontalAlignment(SwingConstants.RIGHT);
		genCode.setHorizontalAlignment(SwingConstants.LEFT);
		
		totalProducts_dash_btn.setPreferredSize(new Dimension(800, 150));
		brands_dash_btn.setPreferredSize(new Dimension(800, 100));
		categories_dash_btn.setPreferredSize(new Dimension(800, 100));
		records_dash_btn.setPreferredSize(new Dimension(800, 100));
		
		/* Generate Code  */
		genCode.setPreferredSize(new Dimension(50, 30));
		
		/* Save Changes */
		saveChanges.setHorizontalAlignment(SwingConstants.LEFT);
		saveChanges2.setHorizontalAlignment(SwingConstants.LEFT);
		
		/* OK button */
		ok_btn.setPreferredSize(new Dimension(60, 30));
		ok_btn2.setPreferredSize(new Dimension(60, 30));
		ok_btn3.setPreferredSize(new Dimension(60, 30));
		
		/* Remove Hint Button */
		remHint_btn.setOpaque(false);
		remHint_btn.setBackground(Color.WHITE);
		remHint_btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		remHint_btn.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Set up background color
		newProduct_btn.setBackground(new Color(37, 54, 70 ));
		updateItem_btn.setBackground(new Color(37, 54, 70 ));
		removeItem_btn.setBackground(new Color(37, 54, 70 ));
		totalProducts_dash_btn.setBackground(Color.WHITE);
		brands_dash_btn.setBackground(Color.WHITE);
		categories_dash_btn.setBackground(Color.WHITE);
		records_dash_btn.setBackground(Color.WHITE);
		genCode.setBackground(Color.RED);
		
		// Set up font and foreground color
		tasks.setFont(seoge);
		tasks.setForeground(Color.WHITE);
		headerTitle.setFont(seoge);
		headerTitle.setForeground(Color.WHITE);
		newProduct_btn.setFont(seoge);
		newProduct_btn.setForeground(Color.WHITE);
		updateItem_btn.setFont(seoge);
		updateItem_btn.setForeground(Color.WHITE); 
		removeItem_btn.setFont(seoge);
		removeItem_btn.setForeground(Color.WHITE);
		totalProducts_dash_btn.setFont(seoge2);
		totalProducts_dash_btn.setForeground(Color.BLACK);
		brands_dash_btn.setFont(seoge2);
		brands_dash_btn.setForeground(Color.BLACK);
		categories_dash_btn.setFont(seoge2);
		categories_dash_btn.setForeground(Color.BLACK);
		records_dash_btn.setFont(seoge2);
		records_dash_btn.setForeground(Color.BLACK);
		prodName.setFont(calibri);
		prodName.setForeground(Color.BLACK);
		price.setFont(calibri);
		price.setForeground(Color.BLACK);
		cat.setFont(calibri);
		cat.setForeground(Color.BLACK);
		prodCode.setFont(calibri);
		prodCode.setForeground(Color.BLACK);
		genCode.setForeground(Color.WHITE);
		update_prodCode.setFont(calibri);
		update_prodCode.setForeground(Color.BLACK);
		update_prodName.setFont(calibri);
		update_prodName.setForeground(Color.BLACK);
		update_prodPrice.setFont(calibri);
		update_prodPrice.setForeground(Color.BLACK);
		update_prodBrand.setFont(calibri);
		update_prodBrand.setForeground(Color.BLACK);
		update_prodCat.setFont(calibri);
		update_prodCat.setForeground(Color.BLACK);		
		brands2.setFont(calibri);
		brands2.setForeground(Color.BLACK);
		enlistProd.setFont(calibri);
		enlistProd.setForeground(Color.BLACK);

		// Set up logo and icon
		appLogo = new JLabel(logo);
		appIcon = new JLabel("AppIcon", JLabel.CENTER);
		padding.setPreferredSize(new Dimension(50, this.getHeight()));
		padding.setMaximumSize(getMaximumSize().getSize());
		
		/**
		 * @NOTE: ADDING THE COMPONENTS TO THEIR RESPECTIVE PANELS  
		 */	
		// Header Panel
		headerP.add(home_btn, BorderLayout.EAST);
		headerP.add(headerTitle, BorderLayout.CENTER);
		
		// Logo Panel
		logoP.add(appLogo);
		
		// Side bar Panel 
		sidebarP.add(tasks);
		sidebarP.add(newProduct_btn);
		sidebarP.add(updateItem_btn);
		sidebarP.add(removeItem_btn);
		sidebarP.add(padding);
		sidebarP.add(logoP);
		
		// Dash board Panel 
		dashboardP.setName("DASHBOARD");
		dashboardP.add(totalProducts_dash_btn);
		dashboardP.add(brands_dash_btn);
		dashboardP.add(categories_dash_btn);
		dashboardP.add(records_dash_btn);
		
		// New Product Panel
		newProductP.setName("NEW_PRODUCT");
		newProductP.add(prodName);
		newProductP.add(getProdName_field);
		newProductP.add(price);
		newProductP.add(getPrice_field);
		newProductP.add(brands2);
		newProductP.add(getBrand_field);
		newProductP.add(cat);
		newProductP.add(getCat_field);
//		newProductP.add(prodCode);
//		newProductP.add(getProdCode_field);
//		newProductP.add(genCode);
		newProductP.add(saveChanges);
		
		// Set up update item  panel
		updateItemP.setName("UPDATE");
		updateItemP.add(update_prodCode); 
		updateItemP.add(getUpdate_prodCode_field); 
		updateItemP.add(update_prodName);
		updateItemP.add(getUpdate_prodName_field); 
		updateItemP.add(update_prodPrice);
		updateItemP.add(getUpdate_prodPrice_field); 
		updateItemP.add(update_prodBrand); 
		updateItemP.add(getUpdate_prodBrand_field); 
		updateItemP.add(update_prodCat); 
		updateItemP.add(getUpdate_prodCat_field); 		
//		updateItemP.add(getBrands_box);
//		updateItemP.add(enlistProd); 
//		updateItemP.add(getEnlistProd_box);
		updateItemP.add(saveChanges2);
		
		// Set up remove item panel 
		removeItemP.setName("REMOVE");
		removeItemP.add(remProd); 
		removeItemP.add(getRemProd_field); 
		removeItemP.add(ok_btn); 
		removeItemP.add(remHint); 
		removeItemP.add(remHint_btn);
		
//		removeItemP.add(new JLabel(" ")); 
//		removeItemP.add(remBrand);
//		removeItemP.add(new JLabel(" ")); 
//		removeItemP.add(getRemBrand_field);
//		removeItemP.add(ok_btn2); 
//		removeItemP.add(remCat);
//		removeItemP.add(new JLabel("")); 
//		removeItemP.add(getRemCat_field); 
//		removeItemP.add(ok_btn3);
		
		
		// Content Panel with Card Layout
		contentP.add("DASHBOARD", dashboardP);
		contentP.add("NEW_PRODUCT", newProductP);
		contentP.add("UPDATE", updateItemP);
		contentP.add("REMOVE", removeItemP); 
		
	
		/**
		 * CARD LAYOUT SET UP
		 */
		// Initialize card layout
//		card = new CardLayout(10, 10); 
//		contentP.setLayout(card);
	
	} // end of initComponents 
	
	/*
	 * ADDING INITIALIZED COMPONENTS RESPECTIVELY TO THIS CLASS AS JFRAME
	 */
	private void addComponents() {
	
		/**
		 *  @NOTE: ADDING THE INITIALIZED COMPONENTS TO THE FRAME
		 */
		add(headerP, BorderLayout.NORTH); 
		add(sidebarP, BorderLayout.WEST);
		add(contentP, BorderLayout.CENTER);
	
	} // end of addComponents
	
	/*
	 * METHOD TO SET UP ACTION COMMANDS FOR ACTION LISTENER
	 */
	private void actionCommander() {
		
		// Log to console
        System.out.println("Setting up action commands!!!");
        
        /// Home Button
        home_btn.setActionCommand("home");
        
        // Side bar events 
        newProduct_btn.setActionCommand("product");
        updateItem_btn.setActionCommand("update");
        removeItem_btn.setActionCommand("remove");
        
        // New Product Panel input events 
        saveChanges.setActionCommand("new_product");
        genCode.setActionCommand("get_product_code");
        
        // Update Item Panel input events
        saveChanges2.setActionCommand("update_product");
        
        // Remove Item Panel input events
        ok_btn.setActionCommand("remove_product");
        remHint_btn.setActionCommand("check_db");
        
        // Dash Board events 
        totalProducts_dash_btn.setActionCommand("total_products"); 
        brands_dash_btn.setActionCommand("total_brands");
        categories_dash_btn.setActionCommand("total_cat");
        records_dash_btn.setActionCommand("total_records");
		
	} // end of actionCommander
	
	/*
	 * ADDING AND REGISTERING EVENT LISTENERS 
	 */
	private void addListeners() {
		
		// Log to console
        System.out.println("Adding event listeners!!!"); 
        
        // Home button object
        home_btn.addActionListener(eventhandler); 
        
        // Side bar listeners objects 
        newProduct_btn.addActionListener(eventhandler);
        updateItem_btn.addActionListener(eventhandler);
        removeItem_btn.addActionListener(eventhandler);
		
        // New Product Panel listeners 
        saveChanges.addActionListener(eventhandler);
        genCode.addActionListener(eventhandler);
        
        // Update Item Panel Listeners
        saveChanges2.addActionListener(eventhandler);
        
        // Remove Item Panel input events
        ok_btn.addActionListener(eventhandler);
        remHint_btn.addActionListener(eventhandler);
        
        // Dash board listeners 
        totalProducts_dash_btn.addActionListener(eventhandler);
        brands_dash_btn.addActionListener(eventhandler);
        categories_dash_btn.addActionListener(eventhandler);
        records_dash_btn.addActionListener(eventhandler);
        
	} // end of addListeners
	
	
	
	
	
	/** 
	 * @NOTE: RUN THIS MAIN METHOD WHEN UI TESTS ARE NEEDED 
	 * 		  THIS IS DONE SO THAT WE CAN HAVE COMPLETE CHANGES AND MODIFICATION 
	 * 		  TO THE GUI APP WITHOUT AFFECTING THE CLIENT CLASS. 
	 * 	Please, uncomment when needed.	
	 */ 
//	public static void main(String[] args) {
//		/* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WindowActivity().setVisible(true);
//            }
//        });
//	}
	
}
