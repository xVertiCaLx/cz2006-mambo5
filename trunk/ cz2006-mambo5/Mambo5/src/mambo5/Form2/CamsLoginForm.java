package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

import mambo5.Controller.JInterfaceConstant;

public class CamsLoginForm extends JPanel implements JInterfaceConstant {
	private JTextField useridTextField;
	private JPasswordField passwordField;
	private JLabel useridLabel, passwordLabel;
	boolean id_select = true, pwd_select = false;
	
	public CamsLoginForm(final CamsMainFrame mainFrame) {
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		//UserID
		useridLabel = new JLabel("Enter your Staff ID:");
		useridLabel.setBounds(((CONTENTPANE_WIDTH-300)/2),50,300,14);
		add(useridLabel);
		
		useridTextField = new JTextField();
		useridTextField.setBounds(((CONTENTPANE_WIDTH-300)/2),50+useridLabel.getHeight(),300,20);
		add(useridTextField);
		
		
	}
}
