//DESIGN UNIFIED

package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Entity.MenuItem;

public class CamsEditMenuItemForm extends JPanel implements JInterfaceController {

	private JLabel menuItemLabel, menuItemPriceLabel, menuItemDiscountLabel;
	private JTextField menuItemTextField, menuItemPriceTextField, menuItemDiscountTextField;
	private JButton updateButton, clearAllButton;
	private int posY = 0, posX = 0, totalHeight = 0, TEXTFIELD_WIDTH = 300, TEXTLABEL_WIDTH = 300;

	
	private MenuItemController MenuItemController;
	
	public CamsEditMenuItemForm(final CamsMainFrame mainFrame,final MenuItem menuItem) {

		mainFrame.setTitle("Edit Menu Item (" + menuItem.getMenuItemName() + ")");
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
		menuItemTextField.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		menuItemTextField.setText(menuItem.getMenuItemName());
		totalHeight += (menuItemTextField.getHeight() + MARGIN);
		
		menuItemPriceLabel = new JLabel("Item Price: ");
		menuItemPriceLabel.setSize(TEXTLABEL_WIDTH, JLABEL_HEIGHT);
		totalHeight += (menuItemLabel.getHeight() + MARGIN);
		
		menuItemPriceTextField = new JTextField();
		menuItemPriceTextField.setSize(TEXTFIELD_WIDTH, JTEXTFIELD_HEIGHT);
		menuItemPriceTextField.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		menuItemPriceTextField.setText(Double.toString(menuItem.getMenuItemPrice()));
		totalHeight += (menuItemPriceTextField.getHeight() + MARGIN);
		
		menuItemDiscountLabel = new JLabel("Item Discount Price: ");
		menuItemDiscountLabel.setSize(TEXTLABEL_WIDTH, JLABEL_HEIGHT);
		totalHeight += (menuItemDiscountLabel.getHeight()+MARGIN);
		
		menuItemDiscountTextField = new JTextField();
		menuItemDiscountTextField.setSize(TEXTFIELD_WIDTH, JTEXTFIELD_HEIGHT);
		menuItemDiscountTextField.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		menuItemDiscountTextField.setText(Double.toString(menuItem.getDiscount()));
		totalHeight += (menuItemDiscountTextField.getHeight() + MARGIN);
		
		updateButton = new JButton("UPDATE");
		updateButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		updateButton.setForeground(FOREGROUND_COLOUR);
		updateButton.setFocusPainted(false);
		updateButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		updateButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItemController = new MenuItemController();
				if (!menuItemTextField.getText().isEmpty() || !menuItemPriceTextField.getText().isEmpty() || !menuItemDiscountTextField.getText().isEmpty()) {
					MenuItemController.validateUpdateMenuItem(menuItemTextField.getText(), 
							Double.parseDouble(menuItemPriceTextField.getText()), Double.parseDouble(menuItemDiscountTextField.getText()),menuItem.getMenuItemID());
							mainFrame.reloadMenuItemList();
							mainFrame.replacePanel("CamsListMenuItemForm");
				} else
					JOptionPane.showMessageDialog(null, "Please ensure that all fields are completed.");
			}
		});
		totalHeight += updateButton.getHeight();
		
		clearAllButton = new JButton("CLEAR TEXT");
		clearAllButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		clearAllButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		clearAllButton.setForeground(FOREGROUND_COLOUR);
		clearAllButton.setFocusPainted(false);
		clearAllButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		clearAllButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemTextField.setText("");
				menuItemPriceTextField.setText("");
				menuItemDiscountTextField.setText("");
			}
		});
		
		totalHeight += clearAllButton.getHeight();
		
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
		
		updateButton.setLocation(posX, posY);
		add(updateButton);
		posX += updateButton.getWidth() + MARGIN;
		
		clearAllButton.setLocation(posX, posY);
		add(clearAllButton);
	}

}
