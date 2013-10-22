package mambo5.Form2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//231 + y 254+x

public class SelectPanel extends JPanel {
	
	private JButton OFSButton, CAMSButton, TixButton;
	
	public SelectPanel(final CamsMainFrame mainFrame) {
		// Panel Size
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		mainFrame.setTitle("Please select a System to demonstrate:");

		OFSButton = new JButton("Enter OFS System");
		OFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new CamsLoginForm(mainFrame));
			}
		});
		OFSButton.setBounds(20, 151, 234, 80);
		add(OFSButton);
		
		CAMSButton = new JButton("Enter Canteen Management System");
		CAMSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new CamsCreateMenuItemForm(mainFrame));
			}
		});
		CAMSButton.setBounds(274, 151, 234, 80);
		add(CAMSButton);
		
		TixButton = new JButton("Enter Ticketing System");
		TixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.replacePanel(new CustomerMainMenu(mainFrame));
			}
		});
		TixButton.setBounds(528, 151, 234, 80);
		add(TixButton);
	}
	
}
