package mambo5.Form2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Entity.Admin;

public class CamsCreateMenuItemForm extends JPanel implements JInterfaceController {

	private JLabel menuItemLabel, menuItemPriceLabel, menuItemDiscountLabel;
	private JTextField menuItemTextField, menuItemPriceTextField, menuItemDiscountTextField;
	private JButton addButton, clearAllButton;
	private int posY = 0, posX = 0, totalHeight = 0, TEXTFIELD_WIDTH = 300, TEXTLABEL_WIDTH = 300, menuID;
	private double price, discount;
	private MenuItemController mic;
	private CamsMainFrame mainFrame;
	private Admin admin;
	
	public CamsCreateMenuItemForm(final CamsMainFrame mainFrame, final Admin admin, int menuID) {
		this.mainFrame = mainFrame;
		this.menuID = menuID;
		this.admin = admin;
		posX = 40;
		mainFrame.setTitle("Create Menu Item");
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(0,12);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
				
		posX = ((CONTENTPANE_WIDTH - TEXTFIELD_WIDTH)/2);
		
		menuItemLabel = new JLabel("Item Name:");
		menuItemLabel.setSize(TEXTLABEL_WIDTH, JLABEL_HEIGHT);
		totalHeight += menuItemLabel.getHeight();
		
		menuItemTextField = new JTextField();
		menuItemTextField.setSize(TEXTFIELD_WIDTH, JTEXTFIELD_HEIGHT);
		totalHeight += (menuItemTextField.getHeight() + MARGIN);
		
		menuItemPriceLabel = new JLabel("Item Price: ");
		menuItemPriceLabel.setSize(TEXTLABEL_WIDTH, JLABEL_HEIGHT);
		totalHeight += (menuItemLabel.getHeight() + MARGIN);
		
		menuItemPriceTextField = new JTextField();
		menuItemPriceTextField.setSize(TEXTFIELD_WIDTH, JTEXTFIELD_HEIGHT);
		totalHeight += (menuItemPriceTextField.getHeight() + MARGIN);
		
		menuItemDiscountLabel = new JLabel("Item Discount Price: ");
		menuItemDiscountLabel.setSize(TEXTLABEL_WIDTH, JLABEL_HEIGHT);
		totalHeight += (menuItemDiscountLabel.getHeight()+MARGIN);
		
		menuItemDiscountTextField = new JTextField();
		menuItemDiscountTextField.setSize(TEXTFIELD_WIDTH, JTEXTFIELD_HEIGHT);
		totalHeight += (menuItemDiscountTextField.getHeight() + MARGIN);
		
		addButton = new JButton("Add to Menu");
		addButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitMenuItem(e);
			}
		});
		totalHeight += addButton.getHeight();
		
		clearAllButton = new JButton("Clear All");
		clearAllButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemTextField.setText("");
				menuItemPriceTextField.setText("");
				menuItemDiscountTextField.setText("");
			}
		});
		
		posX = (CONTENTPANE_WIDTH - menuItemTextField.getWidth())/2;
		posY = (CONTENTPANE_HEIGHT - totalHeight)/2;
		menuItemLabel.setLocation(posX, posY);
		add(menuItemLabel);
		
		posY += menuItemLabel.getHeight() + MARGIN;
		menuItemTextField.setLocation(posX, posY);
		add(menuItemTextField);
				
		posY += menuItemTextField.getHeight() + MARGIN;
		menuItemPriceLabel.setLocation(posX, posY);
		add(menuItemPriceLabel);
		
		posY += menuItemPriceLabel.getHeight() + MARGIN;
		menuItemPriceTextField.setLocation(posX, posY);
		add(menuItemPriceTextField);
		
		posY += menuItemPriceTextField.getHeight() + MARGIN;
		menuItemDiscountLabel.setLocation(posX, posY);
		add(menuItemDiscountLabel);
		
		posY += menuItemDiscountLabel.getHeight() + MARGIN;
		
		menuItemDiscountTextField.setLocation(posX, posY);
		add(menuItemDiscountTextField);
		
		posY += menuItemDiscountTextField.getHeight() + MARGIN;
		
		addButton.setLocation(posX, posY);
		add(addButton);
		posX += addButton.getWidth() + MARGIN;
		
		clearAllButton.setLocation(posX, posY);
		add(clearAllButton);
	}

	public void submitMenuItem(ActionEvent e) {
		if(menuItemTextField.getText().isEmpty() || menuItemPriceTextField.getText().isEmpty() || menuItemDiscountTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error! Please ensure that all fields contains information.\nNo fields should be empty.");
		} else {
			try {
				price = Double.parseDouble(menuItemPriceTextField.getText());
				mic = new MenuItemController();
				if(mic.validateMenuItemDetail(menuID, menuItemTextField.getText(), price, discount)==0)
					JOptionPane.showMessageDialog(null, "Canteen cannot be created");
				else {
					JOptionPane.showMessageDialog(null, "Canteen successfully created");
					mainFrame.replacePanel(new CamsMainMenuForm(mainFrame, admin));
				}
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Please Enter Only Integer Value for Price and Discount");
			}
		}
	}
	
}
