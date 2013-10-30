package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.LoginController;
import mambo5.Entity.Admin;
import mambo5.Entity.Menu;

public class CamsLoginForm extends JPanel implements JInterfaceController {
	private JTextField useridTextField;
	private JPasswordField passwordField;
	private JLabel useridLabel, passwordLabel;
	private JButton loginButton;
	boolean id_select = true, pwd_select = false;
	private int labelWidth = 300, textFieldWidth = 300, totalWidth = 0, totalHeight = 0, posX=0, posY=0, menuID = -1;
	private LoginController loginController;
	private Admin admin;
	
	public CamsLoginForm(final CamsMainFrame mainFrame) {
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(0, POS_CONTENTPANE_OFFSET_Y);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		loginController = new LoginController();
		
		useridLabel = new JLabel("Enter your ID:");
		useridLabel.setSize(new Dimension(labelWidth, JLABEL_HEIGHT));
		totalHeight += useridLabel.getHeight() + MARGIN;
		
		useridTextField = new JTextField();
		useridTextField.setSize(new Dimension(textFieldWidth, JTEXTFIELD_HEIGHT));
		totalHeight += useridTextField.getHeight() + MARGIN;
		
		passwordLabel = new JLabel("Enter your password:");
		passwordLabel.setSize(new Dimension(labelWidth, JLABEL_HEIGHT));
		totalHeight += passwordLabel.getHeight() + MARGIN;
		
		passwordField = new JPasswordField();
		passwordField.setSize(new Dimension(textFieldWidth, JTEXTFIELD_HEIGHT));
		totalHeight += passwordField.getHeight() + MARGIN;
		
		loginButton = new JButton("LOG IN");
		loginButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Login Fired!");
				admin = loginController.login(useridTextField.getText(), passwordField.getText());
				if(admin != null) {
					if (admin.getStallID() != -1) {
						System.out.println("Stall ID is " + admin.getStallID());
						mainFrame.setID(admin.getStallID(), admin.getAccessID());
						mainFrame.replacePanel("CamsMainMenuForm");
					} else {
						JOptionPane.showMessageDialog(mainFrame,"This account is not authorised to access this page.");
					}
				} else {
					JOptionPane.showMessageDialog(mainFrame, "You have entered an incorrect UserID/Password");
				}
			}
		});
		totalHeight += loginButton.getHeight();
		
		posX = (getWidth() - useridTextField.getWidth())/2;
		posY = (getHeight() - totalHeight)/2;
		
		useridLabel.setLocation(posX, posY);
		posY += useridLabel.getHeight()+MARGIN;
		add(useridLabel);
		
		useridTextField.setLocation(posX, posY);
		posY += useridTextField.getHeight()+MARGIN;
		add(useridTextField);
		
		passwordLabel.setLocation(posX, posY);
		posY += passwordLabel.getHeight()+MARGIN;
		add(passwordLabel);
		
		passwordField.setLocation(posX, posY);
		posY += passwordField.getHeight()+MARGIN;
		add(passwordField);
		
		loginButton.setLocation(posX, posY);
		add(loginButton);
		
	}
}
