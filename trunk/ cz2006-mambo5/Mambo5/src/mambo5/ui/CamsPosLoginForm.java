package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CamsPosLoginForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CamsPosLoginForm frame = new CamsPosLoginForm();
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
	public CamsPosLoginForm() {
		setTitle("CaMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 784, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("#Canteen");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(10, 0, 103, 39);
		panel.add(label);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(new Color(105, 105, 105));
		btnLogin.setBounds(20, 151, 234, 80);
		contentPane.add(btnLogin);
		
		JButton btnNewOrder = new JButton("NEW ORDER");
		btnNewOrder.setForeground(Color.WHITE);
		btnNewOrder.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewOrder.setBackground(SystemColor.controlDkShadow);
		btnNewOrder.setBounds(274, 151, 234, 80);
		contentPane.add(btnNewOrder);
		
		JButton btnLock = new JButton("LOCK");
		btnLock.setForeground(Color.WHITE);
		btnLock.setFont(new Font("Arial", Font.BOLD, 16));
		btnLock.setBackground(SystemColor.controlDkShadow);
		btnLock.setBounds(528, 151, 234, 80);
		contentPane.add(btnLock);
		
		JButton btnPending = new JButton("Pending Order");
		btnPending.setForeground(Color.WHITE);
		btnPending.setFont(new Font("Arial", Font.BOLD, 16));
		btnPending.setBackground(SystemColor.controlDkShadow);
		btnPending.setBounds(20, 251, 234, 80);
		contentPane.add(btnPending);

		JButton btnRefund = new JButton("REFUND");
		btnRefund.setForeground(Color.WHITE);
		btnRefund.setFont(new Font("Arial", Font.BOLD, 16));
		btnRefund.setBackground(SystemColor.controlDkShadow);
		btnRefund.setBounds(274, 251, 234, 80);
		contentPane.add(btnRefund);
	}

}
