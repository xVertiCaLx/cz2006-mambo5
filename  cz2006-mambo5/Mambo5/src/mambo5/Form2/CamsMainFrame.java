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

	private JPanel titlePanel, contentPane, selectPanel;
	private JLabel titleLabel = new JLabel("#Canteen");;

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
		titleLabel.setBounds(10, 1, 780, 38);
		titlePanel.add(titleLabel);

		selectPanel = new SelectPanel(this);
		contentPane.add(selectPanel);
	}
	
	public void setSelectPanel(JPanel selectPanel) {
		this.selectPanel = selectPanel;
	}

	public JPanel getSelectPanel() {
		return selectPanel;
	}

	public void setTitle(String title) {
		titleLabel.setText(title);
	}
	
	public void replacePanel(JPanel panel) {
		contentPane.remove(selectPanel);
		selectPanel = panel;
		contentPane.add(selectPanel);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}
