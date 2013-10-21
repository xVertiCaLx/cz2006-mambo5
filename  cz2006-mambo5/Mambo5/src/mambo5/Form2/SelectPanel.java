package mambo5.Form2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SelectPanel extends JPanel {
	JTextField idTextField, pwdTextField;
	boolean id_select = true, pwd_select = false;
	private JPasswordField passwordField;

	public SelectPanel() {
		// Pnael Size
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		// things specific to your layout
		

		JButton OFSButton = new JButton("Enter OFS System");
		OFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new DeleteStallForm());
				revalidate();
				repaint();
			}
		});
		OFSButton.setBounds(0, 40, 248, 41);
		add(OFSButton);

		JButton CAMSButton = new JButton("Enter CaMS");
		CAMSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new CamsMainMenuForm());
				revalidate();
				repaint();
			}
		});
		CAMSButton.setBounds(450, 492, 248, 41);
		add(CAMSButton);

	}
}
