package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CamsMainMenuForm extends JPanel {

	public CamsMainMenuForm() {
		setBounds(0, 40, 800, 560);
		setLayout(null);	
		setBackground(new Color(255, 255, 255));
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new CamsLoginForm());
				revalidate();
				repaint();
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(new Color(105, 105, 105));
		btnLogin.setBounds(20, 151, 234, 80);
		add(btnLogin);
		
		JButton btnNewOrder = new JButton("NEW ORDER");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new CamsCreateOrderForm());
				revalidate();
				repaint();
			}
		});
		btnNewOrder.setForeground(Color.WHITE);
		btnNewOrder.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewOrder.setBackground(SystemColor.controlDkShadow);
		btnNewOrder.setBounds(274, 151, 234, 80);
		add(btnNewOrder);
		
		JButton btnLock = new JButton("LOCK");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CamsLoginForm loginPanel = new CamsLoginForm();
				removeAll();
				add(new CamsLoginForm());
				revalidate();
				repaint();
			}
		});
		btnLock.setForeground(Color.WHITE);
		btnLock.setFont(new Font("Arial", Font.BOLD, 16));
		btnLock.setBackground(SystemColor.controlDkShadow);
		btnLock.setBounds(528, 151, 234, 80);
		add(btnLock);
		
		JButton btnPending = new JButton("Pending Order");
		btnPending.setForeground(Color.WHITE);
		btnPending.setFont(new Font("Arial", Font.BOLD, 16));
		btnPending.setBackground(SystemColor.controlDkShadow);
		btnPending.setBounds(20, 251, 234, 80);
		add(btnPending);

		JButton btnRefund = new JButton("REFUND");
		btnRefund.setEnabled(false);
		btnRefund.setForeground(Color.WHITE);
		btnRefund.setFont(new Font("Arial", Font.BOLD, 16));
		btnRefund.setBackground(SystemColor.controlDkShadow);
		btnRefund.setBounds(274, 251, 234, 80);
		add(btnRefund);
	}
}
