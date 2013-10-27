package mambo5.Form2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Entity.MenuItem;

public class SelectPanel extends JPanel implements JInterfaceController {
	private int posX = 0, posY = 40, totalHeight = 0, totalWidth = 0;
	private JButton OFSButton, CAMSButton, TixButton;
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private MenuItemController menuItemController = new MenuItemController();
	
	public SelectPanel(final CamsMainFrame mainFrame) {
		// Panel Size
		setBounds(posX, posY, CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		mainFrame.setTitle("Please select a System to demonstrate:");

		System.out.println("Initialising CaMS, Please Wait...");
				
		menuItemController.retrieveMenuItemList(menuItemList);
		System.out.println("Initialising Complete. Loading Main Screen.");
		
		OFSButton = new JButton("Enter OFS System");
		OFSButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		OFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new OFSLoginForm(mainFrame));
			}
		});

		totalHeight += OFSButton.getHeight();
		totalWidth += OFSButton.getWidth() + MARGIN;
		
		CAMSButton = new JButton("Enter Canteen Management System");
		CAMSButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		CAMSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.replacePanel(new RefundOrderForm(mainFrame));
				mainFrame.replacePanel(new PendingOrderForm(mainFrame, 5));
				//mainFrame.replacePanel(new CamsCreateOrderForm(mainFrame, menuItemList, 5));
				//mainFrame.replacePanel(new CamsListMenuItemForm(mainFrame, menuItemList, 5));
			}
		});
		
		totalWidth += CAMSButton.getWidth() + MARGIN;
		
		TixButton = new JButton("Enter Ticketing System");
		TixButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		TixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new MainMenuForm(mainFrame));
			}
		});
		
		totalWidth += TixButton.getWidth();
		
		posX = (CONTENTPANE_WIDTH - totalWidth)/2;
		posY = (getHeight() - totalHeight)/2;
		
		OFSButton.setLocation(posX, posY);
		add(OFSButton);
		
		posX += OFSButton.getWidth() + MARGIN;
		
		CAMSButton.setLocation(posX, posY);
		add(CAMSButton);
		
		posX += CAMSButton.getWidth() + MARGIN;
		
		TixButton.setLocation(posX, posY);
		add(TixButton);
	}
	
}
