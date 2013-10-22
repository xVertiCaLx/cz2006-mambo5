package mambo5.Form2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mambo5.Controller.JInterfaceConstant;

public class CamsCreateMenuItemForm extends JPanel implements JInterfaceConstant {

	private JLabel menuItemLabel, menuItemPriceLabel, menuItemDiscountLabel;
	private JTextField menuItemTextField, menuItemPriceTextField, menuItemDiscountTextField;
	private int posX = 0, posY = 0, totalHeight = 0, totalWidth = 0;
	
	
	public CamsCreateMenuItemForm(final CamsMainFrame mainFrame) {
		posY = 40;
		mainFrame.setTitle("Create Menu Item");
		setBounds(posX, posY, CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		
		menuItemLabel = new JLabel("Item Name:");
		menuItemLabel.setSize(100, JLABEL_HEIGHT);
		totalHeight += menuItemLabel.getHeight();
		
		menuItemTextField = new JTextField();
		menuItemTextField.setSize(200, JTEXTFIELD_HEIGHT);
		totalHeight += menuItemTextField.getHeight();
		
		menuItemPriceLabel = new JLabel("Item Price: ");
		menuItemPriceLabel.setSize(100, JLABEL_HEIGHT);
		totalHeight += menuItemLabel.getHeight();
		
		menuItemPriceTextField = new JTextField();
		menuItemPriceTextField.setSize(200, JTEXTFIELD_HEIGHT);
		totalHeight += menuItemPriceTextField.getHeight();
		
		menuItemDiscountLabel = new JLabel("Item Price: ");
		menuItemDiscountLabel.setSize(100, JLABEL_HEIGHT);
		totalHeight += menuItemDiscountLabel.getHeight();
		
		menuItemDiscountTextField = new JTextField();
		menuItemDiscountTextField.setSize(200, JTEXTFIELD_HEIGHT);
		totalHeight += menuItemDiscountTextField.getHeight();		
	}

}
