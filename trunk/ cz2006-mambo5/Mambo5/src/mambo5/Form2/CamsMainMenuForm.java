package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;
import mambo5.Entity.Admin;

public class CamsMainMenuForm extends JPanel implements JInterfaceController {

	public CamsMainMenuForm(final CamsMainFrame mainFrame, final Admin admin) {
		setBounds(0, 0, 800, 560);
		setLayout(null);
		setBackground(new Color(0, 0, 255));
		mainFrame.setTitle("Canteen Management System");
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new CamsLoginForm(mainFrame));
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
				add(new CamsCreateOrderForm(mainFrame, 5));
				revalidate();
				repaint();
			}
		});
		btnNewOrder.setForeground(Color.WHITE);
		btnNewOrder.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewOrder.setBackground(SystemColor.controlDkShadow);
		btnNewOrder.setBounds(274, 151, 234, 80);
		add(btnNewOrder);
		
		JButton btnAddMenuItem = new JButton("ADD NEW ITEM");
		btnAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new CamsCreateMenuItemForm(mainFrame, admin, 5));
			}
		});
		btnAddMenuItem.setForeground(Color.WHITE);
		btnAddMenuItem.setFont(new Font("Arial", Font.BOLD, 16));
		btnAddMenuItem.setBackground(SystemColor.controlDkShadow);
		btnAddMenuItem.setBounds(528, 151, 234, 80);
		add(btnAddMenuItem);
		
		JButton btnPending = new JButton("PENDING ORDERS");
		btnPending.setForeground(Color.WHITE);
		btnPending.setFont(new Font("Arial", Font.BOLD, 16));
		btnPending.setBackground(SystemColor.controlDkShadow);
		btnPending.setBounds(20, 251, 234, 80);
		btnPending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new PendingOrderForm(mainFrame, 5));
			}
		});
		add(btnPending);

		JButton btnRefund = new JButton("REFUND");
		//btnRefund.setEnabled(false);
		btnRefund.setForeground(Color.WHITE);
		btnRefund.setFont(new Font("Arial", Font.BOLD, 16));
		btnRefund.setBackground(SystemColor.controlDkShadow);
		btnRefund.setBounds(274, 251, 234, 80);
		btnRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel(new RefundOrderForm(mainFrame));
			}
		});
		add(btnRefund);
	}
}
