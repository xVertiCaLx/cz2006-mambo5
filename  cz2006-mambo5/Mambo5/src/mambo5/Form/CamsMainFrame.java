package mambo5.Form;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.EventQueue;
//import javax.swing.JComboBox;
//import java.awt.Font;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/*import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuController;
import mambo5.Controller.MenuItemController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.Menu;
import mambo5.Entity.MenuItem;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;

public class CamsMainFrame extends JFrame implements JInterfaceController {

	private JPanel titlePanel, contentPane, selectPanel, applicationPanel, logoPanel;	
	private JPanel camsLoginForm, camsCreateOrderForm, camsEditMenuItemForm, camsListMenuItemForm, camsMainMenuForm, camsCreateMenuItemForm, camsPendingOrderForm, camsRefundOrderForm;
	
	private JLabel titleLabel = new JLabel("#Title"), mambo5LogoLbl;
	private JButton systemButton, mainMenuButton;
	private int posX = 0, posY = 0, stallID = -1, menuID = -1, accessID = -1;
	
	private ArrayList<Menu> menuList = new ArrayList<Menu>();
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private MenuItemController menuItemController = new MenuItemController();
	private OrderDetailController orderDetailController = new OrderDetailController();
	private OrderController orderController = new OrderController();
	private MenuController menuController = new MenuController();
	private Icon mambo5Logo = new ImageIcon(getClass().getResource("/mambo5/resources/img/MAMBO5.png"));
	
	public CamsMainFrame() {
		// the frame
		setResizable(false);
		setVisible(true);
		setTitle("Canteen Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(POS_WINDOW_X, POS_WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setSize(new Dimension(MAINPANE_WIDTH, MAINPANE_HEIGHT));
		contentPane.setLocation(posX, posY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// the background
		titlePanel = new JPanel();
		titlePanel.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		titlePanel.setSize(new Dimension(TITLEBAR_WIDTH, TITLEBAR_HEIGHT));
		titlePanel.setLocation(posX, posY);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		titlePanel.setBorder(new MatteBorder(0, 0, 1, 0, TITLEBAR_BORDER_COLOUR));

		posX += MARGIN;
		posY += MARGIN;

		mainMenuButton = new JButton("MAIN MENU");
		mainMenuButton.setSize(new Dimension(STANDARDBUTTON_WIDTH,
				STANDARDBUTTON_HEIGHT - 10));
		mainMenuButton.setForeground(FOREGROUND_COLOUR);
		mainMenuButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		mainMenuButton.setBorder(BorderFactory.createEmptyBorder());
		mainMenuButton.setFocusPainted(false);
		mainMenuButton.setLocation(posX, posY);
		mainMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenuButton.setVisible(false);
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replacePanel("CamsMainMenuForm");
			}
		});
		titlePanel.add(mainMenuButton);
		posX += STANDARDBUTTON_WIDTH + MARGIN;

		titleLabel.setForeground(FOREGROUND_COLOUR);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setSize(new Dimension(TITLELABEL_WIDTH, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setLocation(posX, posY);
		titlePanel.add(titleLabel);

		init();
		applicationPanel = selectPanel;
		contentPane.add(applicationPanel);
		
		posX = 0;
		posY = TITLEBAR_HEIGHT + CONTENTPANE_HEIGHT;
		
		logoPanel = new JPanel();
		logoPanel.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		logoPanel.setSize(new Dimension(TITLEBAR_WIDTH, 57));
		logoPanel.setLocation(posX, posY);
		logoPanel.setBorder(new MatteBorder(1, 0, 0, 0, TITLEBAR_BORDER_COLOUR));
		logoPanel.setLayout(null);
		contentPane.add(logoPanel);
		
		posX = MARGIN;
		posY = MARGIN;
		
		systemButton = new JButton("CHOOSE SYSTEM");
		systemButton.setSize(new Dimension(STANDARDBUTTON_WIDTH,
				STANDARDBUTTON_HEIGHT - 10));
		systemButton.setForeground(FOREGROUND_COLOUR);
		systemButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		systemButton.setFocusPainted(false);
		systemButton.setBorder(BorderFactory.createEmptyBorder());
		systemButton.setLocation(posX, posY);
		systemButton.setVisible(false);
		systemButton.setHorizontalAlignment(SwingConstants.LEFT);
		systemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replacePanel(selectPanel);
			}
		});

		logoPanel.add(systemButton);
		
		posX = CONTENTPANE_WIDTH - 150;
		mambo5LogoLbl = new JLabel();
		mambo5LogoLbl.setIcon(mambo5Logo);
		mambo5LogoLbl.setSize(new Dimension(150,38));
		mambo5LogoLbl.setLocation(posX,0);
		logoPanel.add(mambo5LogoLbl);
	}

	public void setTitle(String title) {
		titleLabel.setText(title);
	}

	public void replacePanel(JPanel panel) {
		contentPane.remove(applicationPanel);
		applicationPanel = panel;
		contentPane.add(applicationPanel);
		contentPane.revalidate();
		contentPane.repaint();
		if (this.applicationPanel instanceof SelectPanel){
			setTitle("Canteen Management System V1.0");
			systemButton.setVisible(false);
			mainMenuButton.setVisible(false);
		} else
			systemButton.setVisible(true);
	}
	
	public void setID(int stallID, int accessID) {
		this.stallID = stallID;
		this.accessID = accessID;
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getStallID() == stallID) {
				menuID = menuList.get(i).getMenuID();
				System.out.println("MenuID: "+menuID+"StallID:"+menuList.get(i).getStallID());
				break;
			}
		}		
	}
	
	public void replacePanel(String panelName) {
		if (panelName.equals("CamsCreateOrderForm")) {
			mainMenuButton.setVisible(true);
			camsCreateOrderForm = new CamsCreateOrderForm(this, menuItemList, orderDetailList, stallID, menuID);
			replacePanel(camsCreateOrderForm);
		} else if (panelName.equals("CamsEditMenuItemForm")) {
			mainMenuButton.setVisible(true);
			replacePanel(camsEditMenuItemForm);
		} else if (panelName.equals("CamsListMenuItemForm")) {
			mainMenuButton.setVisible(true);
			camsListMenuItemForm = new CamsListMenuItemForm(this, menuItemList, menuID);
			replacePanel(camsListMenuItemForm);
		} else if (panelName.equals("CamsMainMenuForm")) {
			mainMenuButton.setVisible(false);
			if (menuID== -1)
				replacePanel("CamsCreateMenuItemForm");
			else  {
				camsMainMenuForm = new CamsMainMenuForm(this, accessID);
				replacePanel(camsMainMenuForm);
			}
		} else if (panelName.equals("CamsCreateMenuItemForm")) {
			if (menuID != -1) mainMenuButton.setVisible(true);
			camsCreateMenuItemForm = new CamsCreateMenuItemForm(this, menuList, stallID, accessID);
			replacePanel(camsCreateMenuItemForm);
		} else if (panelName.equals("CamsPendingOrderForm")) {
			mainMenuButton.setVisible(true);
			camsPendingOrderForm = new CamsPendingOrderForm(this, orderDetailList, orderList, menuItemList, stallID, menuID);
			replacePanel(camsPendingOrderForm);
		} else if (panelName.equals("CamsLoginForm")) {
			mainMenuButton.setVisible(false);
			camsLoginForm = new CamsLoginForm(this);
			replacePanel(camsLoginForm);
		} else if (panelName.equals("CamsRefundOrderForm")) {
			mainMenuButton.setVisible(true);
			camsRefundOrderForm = new CamsRefundOrderForm(this,stallID);
			replacePanel(camsRefundOrderForm);
		} else {
			replacePanel(selectPanel);
		}
	}
	
	public void init() {
		if (selectPanel == null) {
			menuController.retrieveMenuList(menuList);
			menuItemController.retrieveMenuItemList(menuItemList);
			orderDetailController.retrieveOrderDetailList(orderDetailList);
			orderController.retrieveOrderList(orderList);
			System.out.println("Initialising Complete. Loading Main Screen." + orderList.size());
			
			selectPanel = new SelectPanel(this);
		} else {
			menuList = new ArrayList<Menu>();
			menuItemList = new ArrayList<MenuItem>();
			orderList = new ArrayList<Order>();
			orderDetailList = new ArrayList<OrderDetail>();
			menuController.retrieveMenuList(menuList);
			menuItemController.retrieveMenuItemList(menuItemList);
			orderDetailController.retrieveOrderDetailList(orderDetailList);
			orderController.retrieveOrderList(orderList);
		}
	}
	
	public void reloadMenuList() {
		menuList = new ArrayList<Menu>();
		menuController.retrieveMenuList(menuList);
	}
	
	public void reloadMenuItemList() {
		menuItemList = new ArrayList<MenuItem>();
		menuItemController.retrieveMenuItemList(menuItemList);
	}

}
