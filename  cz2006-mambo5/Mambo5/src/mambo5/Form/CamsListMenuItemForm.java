package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;
import mambo5.Entity.MenuItem;

public class CamsListMenuItemForm extends JPanel implements JInterfaceController 
{
	private int posX = 300, posY = 0;
	
	private ArrayList<MenuItem> menuItemList;
	private JPanel menuItemPanel;
	private Map<JButton, MenuItem> menuItemButtons;
	
	public CamsListMenuItemForm(final CamsMainFrame mainFrame, final ArrayList<MenuItem> menuItemList, int menuID)
	{
		//setLayout(null);
		setSize(new Dimension(MAINPANE_WIDTH, MAINPANE_HEIGHT));
		setLocation(posX,posY);
		this.menuItemList = menuItemList;
		
		menuItemPanel = new JPanel();
		menuItemPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,MENUITEMPANE_HEIGHT));
		menuItemPanel.setLocation(posX, posY);
		menuItemPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		initMenuItemButtons(menuID);
		add(menuItemPanel);

	}
	
	public void initMenuItemButtons(int menuID) {
		menuItemButtons = new HashMap<JButton, MenuItem>();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getMenuID() == menuID)
				addMenuItemButtons(menuItemList.get(i));		
		}
	}
	
	public void addMenuItemButtons(MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
		menuItemButton.setActionCommand(menuItem.getMenuItemName());
		menuItemButtons.put(menuItemButton, menuItem);
		menuItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*menuItemList.add(new MenuItem(menuItemButtons.get(e.getSource()).getMenuItemID(), 
						menuItemButtons.get(e.getSource()).getMenuID(),
						menuItemButtons.get(e.getSource()).getMenuItemName(),
						menuItemButtons.get(e.getSource()).getMenuItemPrice(),
						menuItemButtons.get(e.getSource()).getDiscount()));*/
			}
		});

		add(menuItemButton);
	}
}
