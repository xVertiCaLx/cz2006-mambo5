package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.EventQueue;
//import javax.swing.JComboBox;
//import java.awt.Font;
import java.awt.Font;

/*import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;

public class CamsMainFrame extends JFrame implements JInterfaceController {

	
	private JPanel titlePanel, contentPane, selectPanel;
	private JLabel titleLabel = new JLabel("#Canteen");;

	public CamsMainFrame() {
		// the frame
		setResizable(false);
		setVisible(true);
		setTitle("Canteen Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(POS_WINDOW_X, POS_WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setSize(new Dimension(MAINPANE_WIDTH, MAINPANE_HEIGHT));
		contentPane.setLocation(0,0);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// the background
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setSize(new Dimension(TITLEBAR_WIDTH, TITLEBAR_HEIGHT));
		titlePanel.setLocation(0,0);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setBounds(POS_TITLELABEL_X, POS_TITLELABEL_Y, TITLELABEL_WIDTH, TITLELABEL_HEIGHT);
		titlePanel.add(titleLabel);

		selectPanel = new SelectPanel(this);
		contentPane.add(selectPanel);
		System.out.println("Window's Width: " + getWidth() + " Height: " + getHeight());
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
