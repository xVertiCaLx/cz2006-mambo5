package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.EventQueue;
//import javax.swing.JComboBox;
//import java.awt.Font;
import java.awt.Font;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
/*import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class CamsMainFrame extends JFrame implements JInterfaceController {

	private JPanel titlePanel, contentPane, selectPanel, applicationPanel;
	
	private JPanel addValueForm, analyzeCanteenForm;
	
	private JPanel camsLoginForm, camsCreateOrderForm, camsEditMenuItemForm, camsListMenuItemForm, camsMainMenuForm, camsCreateMenuItemForm, camsPendingOrderForm, camsRefundOrderForm;
	
	private JLabel titleLabel = new JLabel("#Canteen");
	private JButton mainMenuButton;
	private int posX = 0, posY = 0, stallID = 5;
	
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private MenuItemController menuItemController = new MenuItemController();
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	private OrderDetailController orderDetailController = new OrderDetailController();

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
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setSize(new Dimension(TITLEBAR_WIDTH, TITLEBAR_HEIGHT));
		titlePanel.setLocation(posX, posY);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		posX += MARGIN;
		posY += MARGIN;

		mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setSize(new Dimension(STANDARDBUTTON_WIDTH,
				STANDARDBUTTON_HEIGHT - 10));
		mainMenuButton.setLocation(posX, posY);
		mainMenuButton.setVisible(false);
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replacePanel(selectPanel);
			}
		});

		titlePanel.add(mainMenuButton);
		posX += mainMenuButton.getWidth() + MARGIN;

		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setSize(new Dimension(TITLELABEL_WIDTH, TITLELABEL_HEIGHT));
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setLocation(posX, posY);
		titlePanel.add(titleLabel);

		init();
		
		applicationPanel = selectPanel;
		contentPane.add(applicationPanel);
	}

	public void setSelectPanel(JPanel applicationPanel) {
		this.applicationPanel = applicationPanel;
	}

	public JPanel getSelectPanel() {
		return applicationPanel;
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
		if (this.applicationPanel instanceof SelectPanel)
			mainMenuButton.setVisible(false);
		else
			mainMenuButton.setVisible(true);
	}
	
	public void replacePanel(String panelName) {
		if (panelName.equals("CamsCreateOrderForm")) {
			camsCreateOrderForm = new CamsCreateOrderForm(this, menuItemList, orderDetailList, stallID);
			replacePanel(camsCreateOrderForm);
		} else if (panelName.equals("CamsEditMenuItemForm")) {
			replacePanel(camsEditMenuItemForm);
		} else if (panelName.equals("CamsListMenuItemForm")) {
			replacePanel(camsListMenuItemForm);
		} else if (panelName.equals("CamsMainMenuForm")) {
			replacePanel(camsMainMenuForm);
		} else if (panelName.equals("CamsCreateMenuItemForm")) {
			replacePanel(camsCreateMenuItemForm);
		} else if (panelName.equals("CamsPendingOrderForm")) {
			replacePanel(camsPendingOrderForm);
		} else if (panelName.equals("CamsLoginForm")) {
			replacePanel(camsLoginForm);
		} else if (panelName.equals("CamsRefundOrderForm")) {
			replacePanel(camsRefundOrderForm);
		} else {
			replacePanel(selectPanel);
		}
	}
	
	public void init() {
		if (selectPanel == null) {
			menuItemController.retrieveMenuItemList(menuItemList);
			orderDetailController.retrieveOrderDetailList(orderDetailList);
			System.out.println("Initialising Complete. Loading Main Screen.");
			
			selectPanel = new SelectPanel(this);
			camsCreateOrderForm = new CamsCreateOrderForm(this, menuItemList, orderDetailList, stallID);
			camsEditMenuItemForm = new CamsEditMenuItemForm(this);
			camsListMenuItemForm = new CamsListMenuItemForm(this, menuItemList, stallID);
			camsMainMenuForm = new CamsMainMenuForm(this);
			camsCreateMenuItemForm = new CamsCreateMenuItemForm(this, stallID);
			//camsPendingOrderForm = new CamsPendingOrderForm(this, stallID);
			camsLoginForm = new CamsLoginForm(this);
			camsRefundOrderForm = new CamsRefundOrderForm(this);
			//camsCreateOrderForm, camsEditMenuItemForm, camsListMenuItemForm, camsMainMenuForm
		}
	}

}
