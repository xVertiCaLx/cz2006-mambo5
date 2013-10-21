package mambo5.Form3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class CamsLoginForm extends JPanel implements ActionListener {
	JTextField idTextField;
	JPasswordField pwdTextField;
	boolean id_select = true, pwd_select = false;
	
	public CamsLoginForm() {
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JLabel label = new JLabel("EMPLOYEE ID");
		label.setBounds(400, 5, 0, 0);
		add(label);
		
		JLabel lblNewLabel = new JLabel("Canteen A,Le Cafe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 179, 14);
		add(lblNewLabel);
		
		JTextPane txtpnEmployee = new JTextPane();
		txtpnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnEmployee.setEnabled(false);
		txtpnEmployee.setText("EMPLOYEE ID");
		txtpnEmployee.setBounds(156, 134, 198, 19);
		add(txtpnEmployee);
		
		idTextField = new JTextField();
		idTextField.setBackground(Color.ORANGE);
		idTextField.setBounds(156, 164, 297, 30);
		add(idTextField);
		
		idTextField.addFocusListener(new FocusListener(){
	        @Override
	        public void focusLost(FocusEvent arg0) {}
	        @Override
	        public void focusGained(FocusEvent arg0) {
	        	 id_select = true;
	        }
	    });

		
		pwdTextField = new JPasswordField();
		pwdTextField.setBounds(156, 240, 297, 30);
		add(pwdTextField);
		
		pwdTextField.addFocusListener(new FocusListener(){
	        @Override
	        public void focusLost(FocusEvent arg0) {}
	        @Override
	        public void focusGained(FocusEvent arg0) {
	        	id_select = false;
		         
	        }
	    });
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_2.setText("PASSWORD");
		textPane_2.setEnabled(false);
		textPane_2.setBounds(156, 217, 198, 27);
		add(textPane_2);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(364, 291, 89, 23);
		add(btnLogin);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(109, 374, 52, 41);
		add(btnNewButton);
		
		JButton button = new JButton("2");
		button.setBounds(158, 374, 52, 41);
		add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(206, 374, 52, 41);
		add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(254, 374, 52, 41);
		add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(303, 374, 52, 41);
		add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(354, 374, 52, 41);
		add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(403, 374, 52, 41);
		add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(451, 374, 52, 41);
		add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(498, 374, 52, 41);
		add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.setBounds(546, 374, 52, 41);
		add(button_8);
		
		JButton button_9 = new JButton("q");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id_select)
					idTextField.setText(idTextField.getText() + "q");
				else
					pwdTextField.setText("q");
			}
		});
		button_9.setBounds(109, 414, 52, 41);
		add(button_9);
		
		JButton button_10 = new JButton("e");
		button_10.setBounds(206, 414, 52, 41);
		add(button_10);
		
		JButton button_11 = new JButton("w");
		button_11.setBounds(158, 414, 52, 41);
		add(button_11);
		
		JButton button_12 = new JButton("r");
		button_12.setBounds(254, 414, 52, 41);
		add(button_12);
		
		JButton button_13 = new JButton("t");
		button_13.setBounds(303, 414, 52, 41);
		add(button_13);
		
		JButton button_14 = new JButton("y");
		button_14.setBounds(354, 414, 52, 41);
		add(button_14);
		
		JButton button_15 = new JButton("u");
		button_15.setBounds(403, 414, 52, 41);
		add(button_15);
		
		JButton button_16 = new JButton("i");
		button_16.setBounds(451, 414, 52, 41);
		add(button_16);
		
		JButton button_17 = new JButton("o");
		button_17.setBounds(498, 414, 52, 41);
		add(button_17);
		
		JButton button_18 = new JButton("p");
		button_18.setBounds(546, 414, 52, 41);
		add(button_18);
		
		JButton button_19 = new JButton("a");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_19.setBounds(109, 452, 52, 41);
		add(button_19);
		
		JButton button_20 = new JButton("s");
		button_20.setBounds(158, 452, 52, 41);
		add(button_20);
		
		JButton button_21 = new JButton("d");
		button_21.setBounds(206, 452, 52, 41);
		add(button_21);
		
		JButton button_22 = new JButton("f");
		button_22.setBounds(254, 452, 52, 41);
		add(button_22);
		
		JButton button_23 = new JButton("g");
		button_23.setBounds(303, 452, 52, 41);
		add(button_23);
		
		JButton button_24 = new JButton("h");
		button_24.setBounds(354, 452, 52, 41);
		add(button_24);
		
		JButton button_25 = new JButton("j");
		button_25.setBounds(403, 452, 52, 41);
		add(button_25);
		
		JButton button_26 = new JButton("k");
		button_26.setBounds(451, 452, 52, 41);
		add(button_26);
		
		JButton button_27 = new JButton("l");
		button_27.setBounds(498, 452, 52, 41);
		add(button_27);
		
		JButton button_28 = new JButton("backspace");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_28.setBounds(595, 374, 103, 41);
		add(button_28);
		
		JButton button_29 = new JButton("z");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_29.setBounds(109, 492, 52, 41);
		add(button_29);
		
		JButton button_30 = new JButton("x");
		button_30.setBounds(158, 492, 52, 41);
		add(button_30);
		
		JButton button_31 = new JButton("c");
		button_31.setBounds(206, 492, 52, 41);
		add(button_31);
		
		JButton button_32 = new JButton("v");
		button_32.setBounds(254, 492, 52, 41);
		add(button_32);
		
		JButton button_33 = new JButton("b");
		button_33.setBounds(303, 492, 52, 41);
		add(button_33);
		
		JButton button_34 = new JButton("n");
		button_34.setBounds(354, 492, 52, 41);
		add(button_34);
		
		JButton button_35 = new JButton("m");
		button_35.setBounds(403, 492, 52, 41);
		add(button_35);
		
		JButton button_38 = new JButton("ENTER");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_38.setBounds(450, 492, 248, 41);
		add(button_38);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(546, 452, 152, 41);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(595, 414, 103, 41);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SPACE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(109, 533, 589, 41);
		add(btnNewButton_3);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
