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
	private ArrayList<MenuItem> menuItemList;
	private JPanel menuItemPanel;
	private Map<JButton, MenuItem> menuItemButtons;
	private Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
	private int menuID, posX = 0, posY = 0, totalWidth = 0 ,
			totalHeight = 0, currentMenuItem = 0;
	
	public CamsListMenuItemForm(final CamsMainFrame mainFrame, final ArrayList<MenuItem> menuItemList, int menuID)
	{
		//setLayout(null);
		this.menuID = menuID;
		this.menuItemList = menuItemList;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		
		initPanels();
		
	}
	
	public void initPanels()
	{
		menuItemPanel = new JPanel();
		menuItemPanel.setLayout(null);
		menuItemPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,
				MENUITEMPANE_HEIGHT));
		menuItemPanel.setLocation(300, 0); //reference from createorderform
		menuItemPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		initMenuItemButtons(menuID);
		add(menuItemPanel);
	}
	
	public void initMenuItemButtons(int menuID) {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);
		menuItemButtons = new HashMap<JButton, MenuItem>();
		for (; currentMenuItem < menuItemList.size(); currentMenuItem++) {
			if (menuItemList.get(currentMenuItem).getMenuID() == menuID) {
				if (totalWidth >= menuItemPanel.getWidth()) {
					if (totalHeight >= menuItemPanel.getHeight()) {
						totalHeight = 0;
						posX = 0;
						posY = MARGIN;
						break;
					} else {
						posX = 0;
						totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
						posY += MENUITEM_BUTTON_HEIGHT + MARGIN;
						totalHeight += MENUITEM_BUTTON_HEIGHT + MARGIN;
					}
				} else {
					totalWidth += MENUITEM_BUTTON_WIDTH + MARGIN;
				}
				menuItems.put(menuItemList.get(currentMenuItem).getMenuItemID(), menuItemList.get(currentMenuItem));
				addMenuItemButtons(menuItemList.get(currentMenuItem));
			}

			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
		}
	}
	
	public void addMenuItemButtons(MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
		menuItemButton.setSize(new Dimension(MENUITEM_BUTTON_WIDTH,
				MENUITEM_BUTTON_HEIGHT));
		menuItemButton.setLocation(posX, posY);
		menuItemButton.setActionCommand(menuItem.getMenuItemName());
		menuItemButtons.put(menuItemButton, menuItem);
		menuItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					//do something
			}
		});

		add(menuItemButton);
	}
}
