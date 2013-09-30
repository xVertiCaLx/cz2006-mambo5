package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;

import mambo5.Controller.LoginController;
import mambo5.Entity.Customer;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;

//sup
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("CaMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		panel.setBackground(new Color(47, 79, 79));
		contentPane.add(panel, BorderLayout.NORTH);
		
		Label label = new Label("Canteen A");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setForeground(new Color(240, 255, 255));
		panel.add(label);
		
		Label label_1 = new Label("Date Time Information");
		label_1.setForeground(new Color(240, 255, 255));
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(label_1);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginController login = new LoginController();
				Customer c;			
				c = login.validateLoginDetail(1, 2);
				if(c != null) {
					System.out.println(c.getCustID() + " " + c.getCardBalance() + " " + c.getFullName() + " ");
				}
				else
					System.out.println("ERROR");
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(btnLogin);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}
}
