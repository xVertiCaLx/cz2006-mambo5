package mambo5.Form2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//231 + y 254+x

public class SelectPanel extends JPanel {
	JTextField idTextField, pwdTextField;
	boolean id_select = true, pwd_select = false;
	private JPasswordField passwordField;

	
	
	public SelectPanel(final CamsMainFrame mainFrame) {
		// Panel Size
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		mainFrame.titleLabel.setText("Please select a button");

		JButton CAMSButton = new JButton("Enter Canteen Management System");
		CAMSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.remove(mainFrame.selectPanel);
				//mainFrame.add(new CamsMainMenuForm());
				//mainFrame.revalidate();
				//mainFrame.repaint();
				/*CamsMainMenuForm mainmenu = new CamsMainMenuForm();
				//setVisible(false);
				removeAll();
				add(mainmenu);
				revalidate();
				repaint();	*/				
			}
		});
		CAMSButton.setBounds(274, 151, 234, 80);
		add(CAMSButton);
		
		JButton OFSButton = new JButton("Enter OFS System");
		OFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.remove(mainFrame.getSelectPanel());
				mainFrame.setSelectPanel(new OFSFunction(mainFrame));
				mainFrame.add(mainFrame.getSelectPanel());
				mainFrame.revalidate();
				mainFrame.repaint();
			}
		});
		OFSButton.setBounds(20, 151, 234, 80);
		add(OFSButton);

		JButton TixButton = new JButton("Enter Ticketing System");
		TixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				//add(new CustomerMainMenu());
				revalidate();
				repaint();
			}
		});
		TixButton.setBounds(274, 151, 234, 80);
		add(CAMSButton);

	}

}
