package mambo5.Form2;

import java.awt.*;
//import java.awt.EventQueue;
//import javax.swing.JComboBox;
//import java.awt.Font;

/*import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;*/
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CamsMainFrame extends JFrame {

	private JPanel contentPane, titlePanel;
	public static JLabel titleLabel = new JLabel("#Canteen");;

	public CamsMainFrame() {
		// the frame
		setResizable(false);
		setVisible(true);
		setTitle("Canteen Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// the background
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setBounds(0, 0, 800, 40);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setBounds(10, 0, 103, 39);
		titlePanel.add(titleLabel);

		JLabel label_1 = new JLabel("#Store Name | #CaMS Page");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(0, 0, 794, 39);
		contentPane.add(new SelectPanel());
	}
	
}
