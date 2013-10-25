package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.EventQueue;
//import javax.swing.JComboBox;
//import java.awt.Font;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/*import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;

public class CamsMainFrame extends JFrame implements JInterfaceController {

	
	private JPanel titlePanel, contentPane, selectPanel, applicationPanel;
	private JLabel titleLabel = new JLabel("#Canteen");
	private JButton mainMenuButton;
	private int posX = 0, posY = 0;

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
		contentPane.setLocation(posX,posY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// the background
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setSize(new Dimension(TITLEBAR_WIDTH, TITLEBAR_HEIGHT));
		titlePanel.setLocation(posX,posY);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		posX += MARGIN;
		posY += MARGIN;
		
		mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT-10));
		mainMenuButton.setLocation(posX, posY);
		mainMenuButton.setVisible(false);
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replacePanel(selectPanel);
			}
		});

		titlePanel.add(mainMenuButton);
		posX += mainMenuButton.getWidth() + MARGIN;
		
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setSize(new Dimension(TITLELABEL_WIDTH, TITLELABEL_HEIGHT));
		titleLabel.setLocation(posX, posY);
		titlePanel.add(titleLabel);

		selectPanel = new SelectPanel(this);
		applicationPanel = selectPanel;
		contentPane.add(applicationPanel);
		
		System.out.println("Window's Width: " + getWidth() + " Height: " + getHeight());
	}
	  
	public void setSelectPanel(JPanel applicationPanel) {
		this.applicationPanel = applicationPanel;
	}

	public JPanel getSelectPanel() {
		return applicationPanel;
	}

	public void setTitle(String title) {
		titleLabel.setText(title);
	}
	
	public void replacePanel(JPanel panel) {
		contentPane.remove(applicationPanel);
		applicationPanel = panel;
		contentPane.add(applicationPanel);
		contentPane.revalidate();
		contentPane.repaint();
		if (this.applicationPanel instanceof SelectPanel) mainMenuButton.setVisible(false);
		else mainMenuButton.setVisible(true);
	}
	
}
