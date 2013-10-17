package mambo5.Form2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CamsMainMenuFrame extends JFrame {

	JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CamsMainMenuFrame frame = new CamsMainMenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CamsMainMenuFrame() {
		//the frame
				setResizable(false);
				setTitle("Canteen Management System");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 800, 600);
				contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				//the background
				JPanel titlePanel = new JPanel();
				titlePanel.setBackground(new Color(0, 0, 102));
				titlePanel.setBounds(0, 0, 800, 40);
				contentPane.add(titlePanel);
				titlePanel.setLayout(null);
				
				JLabel label = new JLabel("#Canteen");
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Arial", Font.BOLD, 12));
				label.setBounds(10, 0, 103, 39);
				titlePanel.add(label);
				
				JLabel label_1 = new JLabel("#Store Name | #CaMS Page");
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Arial", Font.BOLD, 12));
				label_1.setBounds(0, 0, 794, 39);
				contentPane.add(new CamsMainMenuForm());
	}
}
