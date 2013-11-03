//DESIGN UNIFIED
//LOGIN TESTED
//JUNIT PENDING

package mambo5.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;

public class SelectPanel extends JPanel implements JInterfaceController {
	private int posX = 0, posY = 40, totalHeight = 0, totalWidth = 0;
	private JButton OFSButton, CAMSButton, TixButton;
	
	public SelectPanel(final CamsMainFrame mainFrame) {
		// Panel Size
		setBounds(posX, posY, CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		mainFrame.setTitle("Select a System to Begin");

		System.out.println("Initialising CaMS, Please Wait...");
		
		OFSButton = new JButton("Enter OFS System");
		OFSButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		OFSButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		OFSButton.setFocusPainted(false);
		OFSButton.setForeground(FOREGROUND_COLOUR);
		OFSButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		OFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new OFSLoginForm(mainFrame));
			}
		});

		totalHeight += OFSButton.getHeight();
		totalWidth += OFSButton.getWidth() + MARGIN;
		
		CAMSButton = new JButton("Enter Canteen Management System");
		CAMSButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		CAMSButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		CAMSButton.setFocusPainted(false);
		CAMSButton.setForeground(FOREGROUND_COLOUR);
		CAMSButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		CAMSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel("CamsLoginForm");
			}
		});
		
		totalWidth += CAMSButton.getWidth() + MARGIN;
		
		TixButton = new JButton("Enter Ticketing System");
		TixButton.setSize(MENUBUTTON_WIDTH, MENUBUTTON_HEIGHT);
		TixButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		TixButton.setFocusPainted(false);
		TixButton.setForeground(FOREGROUND_COLOUR);
		TixButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
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
