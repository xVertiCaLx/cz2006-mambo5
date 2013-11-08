//DESIGN UNIFIED
//LOGIN TESTED
//JUNIT PENDING 

package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.LoginController;
import mambo5.Entity.Admin;

public class OFSLoginForm extends JPanel implements JInterfaceController {
	private JTextField useridTextField;
	private JPasswordField passwordField;
	private JLabel useridLabel, passwordLabel;
	private JButton loginButton;
	boolean id_select = true, pwd_select = false;
	private int labelWidth = 300, textFieldWidth = 300, totalWidth = 0, totalHeight = 0, posX=0, posY=0;
	private LoginController loginController;
	private Admin admin;
	
	public OFSLoginForm(final CamsMainFrame mainFrame) {
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(0, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		mainFrame.setTitle("Login to OFS Management System");
		loginController = new LoginController();
		
		useridLabel = new JLabel("ACCESS ID");
		useridLabel.setSize(new Dimension(labelWidth, JLABEL_HEIGHT));
		totalHeight += useridLabel.getHeight() + MARGIN;
		
		useridTextField = new JTextField();
		useridTextField.setSize(new Dimension(textFieldWidth, JTEXTFIELD_HEIGHT));
		useridTextField.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		totalHeight += useridTextField.getHeight() + MARGIN;
		
		passwordLabel = new JLabel("ACCESS PIN");
		passwordLabel.setSize(new Dimension(labelWidth, JLABEL_HEIGHT));
		totalHeight += passwordLabel.getHeight() + MARGIN;
		
		passwordField = new JPasswordField();
		passwordField.setSize(new Dimension(textFieldWidth, JTEXTFIELD_HEIGHT));
		passwordField.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		totalHeight += passwordField.getHeight() + MARGIN;
		
		loginButton = new JButton("LOG IN");
		loginButton.setForeground(FOREGROUND_COLOUR);
		loginButton.setFocusPainted(false);
		loginButton.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		loginButton.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		loginButton.setSize(new Dimension(STANDARDBUTTON_WIDTH, STANDARDBUTTON_HEIGHT));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin = loginController.login(useridTextField.getText(), passwordField.getText());
				if(admin != null) {
					if (admin.getAccessID() == 1) {
						mainFrame.replacePanel(new OFSFunction(mainFrame));
					} else JOptionPane.showMessageDialog(mainFrame,"This account is not authorised to access this page.");
				} else {
					JOptionPane.showMessageDialog(mainFrame, "You have entered an incorrect UserID/Password");
				}
			}
		});
		totalHeight += loginButton.getHeight();
		
		posX = (getWidth() - useridTextField.getWidth())/2;
		posY = (CONTENTPANE_HEIGHT - totalHeight)/2;
		
		useridLabel.setLocation(posX, posY);
		posY += useridLabel.getHeight();
		add(useridLabel);
		
		useridTextField.setLocation(posX, posY);
		posY += useridTextField.getHeight()+MARGIN;
		add(useridTextField);
		
		passwordLabel.setLocation(posX, posY);
		posY += passwordLabel.getHeight();
		add(passwordLabel);
		
		passwordField.setLocation(posX, posY);
		posY += passwordField.getHeight()+MARGIN;
		add(passwordField);
		
		loginButton.setLocation(posX, posY);
		add(loginButton);
		
	}
}