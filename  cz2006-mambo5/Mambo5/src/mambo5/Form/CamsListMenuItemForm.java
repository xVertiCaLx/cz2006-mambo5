package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;
import mambo5.Entity.MenuItem;

public class CamsListMenuItemForm extends JPanel implements JInterfaceController 
{	
	private ArrayList<MenuItem> menuItemList;
	private JPanel menuItemPanel;
	private Map<JButton, MenuItem> menuItemButtons;
	private int menuID, posX = 0, posY = 0, totalWidth = 0 ,
			totalHeight = 0, currentMenuItem = 0;
	
	private CamsMainFrame mainFrame;
	public CamsListMenuItemForm(final CamsMainFrame mainFrame, final ArrayList<MenuItem> menuItemList, int menuID)
	{
		this.mainFrame = mainFrame;
		this.menuItemList = menuItemList;
		this.menuID = menuID;
		setLayout(null);
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		menuItemButtons = new HashMap<JButton, MenuItem>();
		initPanels();

	}
	
	public void initPanels()
	{
		menuItemPanel = new JPanel();
		menuItemPanel.setLayout(null);
		menuItemPanel.setSize(new Dimension(CONTENTPANE_WIDTH-MARGIN,
				CONTENTPANE_HEIGHT));
		menuItemPanel.setLocation(50, 0);
		menuItemPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		initMenuItemButtons(menuID);
		add(menuItemPanel);
	}
	
	public void initMenuItemButtons(int menuID) {
		posX = 70;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);
		
		for (; currentMenuItem < menuItemList.size(); currentMenuItem++) {
			if (totalWidth >= menuItemPanel.getWidth()) {
				if (totalHeight >= menuItemPanel.getHeight())
					break;
				else {
					posX = 70;
					totalWidth = 2 * (MENUITEM_BUTTON_WIDTH + MARGIN);
					posY += MENUITEM_BUTTON_HEIGHT + MARGIN;
					totalHeight += MENUITEM_BUTTON_HEIGHT + MARGIN;
				}
			} else {
				totalWidth += MENUITEM_BUTTON_WIDTH + MARGIN;
			}
			System.out.println(menuItemList.get(currentMenuItem)
					.getMenuItemName()
					+ menuItemList.get(currentMenuItem).getMenuItemID());
			addMenuItemButtons(menuItemList.get(currentMenuItem));
			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
		}
	}
	
	public void addMenuItemButtons(final MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
		menuItemButton.setSize(new Dimension(MENUITEM_BUTTON_WIDTH,
				MENUITEM_BUTTON_HEIGHT));
		menuItemButton.setLocation(posX, posY);
		menuItemButton.setActionCommand(menuItem.getMenuItemName());
		menuItemButton.setForeground(FOREGROUND_COLOUR);
		menuItemButton.setFocusPainted(false);
		menuItemButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		menuItemButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		menuItemButtons.put(menuItemButton, menuItem);
		menuItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				mainFrame.replacePanel(new CamsEditMenuItemForm(mainFrame, menuItem));
			}
		});
		add(menuItemButton);
	}
}
