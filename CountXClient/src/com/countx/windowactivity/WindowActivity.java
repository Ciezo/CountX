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
		JPanel setBrandP; 
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
	JLabel brands; 
	JLabel enlistProd;
	JLabel remProd; 
	JLabel remBrand; 
	JLabel remCat; 
	
	// Text fields
	JTextField getProdName_field;
	JTextField getPrice_field;
	JTextField getCat_field;
	JTextField getProdCode_field;
	JTextField getRemProd_field; 
	JTextField getRemBrand_field; 
	JTextField getRemCat_field; 
	
	// Combo boxes 
	JComboBox getBrands_box; 
	JComboBox getEnlistProd_box; 
	
	// Buttons
	JButton newProduct_btn;
	JButton setBrand_btn;
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
	}
	
	/*
	 * METHOD TO INITIALIZE ALL GLOBAL COMPONENTS
	 * */
	private void initComponents() {

		// Initialize Panels
		contentP = new JPanel(); 
			dashboardP = new JPanel(new GridLayout(4, 1, 5, 5));
			newProductP = new JPanel(new GridLayout(10, 1, 10, 10));
			setBrandP = new JPanel(new GridLayout(5, 1, 10, 10));		
			removeItemP = new JPanel(new GridLayout(6, 2, 10, 10)); 
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
		setBrandP.setOpaque(false);
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
		brands = new JLabel("Brands", JLabel.LEFT);
		enlistProd = new JLabel("Enlist and assign product", JLabel.LEFT); 
		remProd = new JLabel("Remove Product", JLabel.LEFT); 
		remBrand = new JLabel("Remove Brand", JLabel.LEFT); 
		remCat = new JLabel("Remove Category"); 
		
		// Initialize the text fields
		getProdName_field = new JTextField();
		getPrice_field = new JTextField();
		getCat_field = new JTextField(); 
		getProdCode_field = new JTextField();
		getRemProd_field = new JTextField(); 
		getRemBrand_field = new JTextField(); 
		getRemCat_field = new JTextField(); 
		
		// Initialize combo-boxes and its String lists of content 
		String[] brands_ls = {
				
	    };
		
		getBrands_box = new JComboBox<>(brands_ls); 
		getEnlistProd_box = new JComboBox<>(brands_ls); 
		
		// Initialize the buttons
		newProduct_btn = new JButton("New Product");
		setBrand_btn = new JButton("Set up brand");
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
		
		// Set up text field properties
		getProdName_field.setPreferredSize(new Dimension(800, 30));
		getPrice_field.setPreferredSize(new Dimension(800, 30));
		getCat_field.setPreferredSize(new Dimension(800, 30));
		getProdCode_field.setPreferredSize(new Dimension(800, 30));
		getRemProd_field.setPreferredSize(new Dimension(400, 30));
		getRemBrand_field.setPreferredSize(new Dimension(400, 30));
		getRemCat_field.setPreferredSize(new Dimension(300, 30));
		
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
		
		// Set up background color
		newProduct_btn.setBackground(new Color(37, 54, 70 ));
		setBrand_btn.setBackground(new Color(37, 54, 70 ));
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
		setBrand_btn.setFont(seoge);
		setBrand_btn.setForeground(Color.WHITE); 
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
		brands.setFont(calibri);
		brands.setForeground(Color.BLACK);
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
		sidebarP.add(setBrand_btn);
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
		newProductP.add(cat);
		newProductP.add(getCat_field);
		newProductP.add(prodCode);
		newProductP.add(getProdCode_field);
		newProductP.add(genCode);
		newProductP.add(saveChanges);
		
		// Set up brand panel
		setBrandP.setName("BRANDS");
		setBrandP.add(brands);
		setBrandP.add(getBrands_box);
		setBrandP.add(enlistProd); 
		setBrandP.add(getEnlistProd_box);
		setBrandP.add(saveChanges2);
		
		// Set up remove item panel 
		removeItemP.setName("REMOVE");
		removeItemP.add(remProd); 
		removeItemP.add(new JLabel(" ")); 
		removeItemP.add(getRemProd_field); 
		removeItemP.add(ok_btn); 
		removeItemP.add(remBrand);
		removeItemP.add(new JLabel(" ")); 
		removeItemP.add(getRemBrand_field);
		removeItemP.add(ok_btn2); 
		removeItemP.add(remCat);
		removeItemP.add(new JLabel("")); 
		removeItemP.add(getRemCat_field); 
		removeItemP.add(ok_btn3);
		
		
		// Content Panel with Card Layout
		contentP.add("DASHBOARD", dashboardP);
		contentP.add("NEW_PRODUCT", newProductP);
		contentP.add("BRANDS", setBrandP);
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
        setBrand_btn.setActionCommand("brand");
        removeItem_btn.setActionCommand("remove");
		
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
        setBrand_btn.addActionListener(eventhandler);
        removeItem_btn.addActionListener(eventhandler);
		
	} // end of addListeners
	
	
	public static void main(String[] args) {
		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowActivity().setVisible(true);
            }
        });
	}
	
}
