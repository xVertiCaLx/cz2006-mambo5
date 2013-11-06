//DESIGN UNIFIED
//FUNCTION TESTED
//JUNIT PENDING

package mambo5.Form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mambo5.Controller.JInterfaceController;

public class CamsMainMenuForm extends JPanel implements JInterfaceController {

	int posX = 0, posY = 40, totalWidth = 0, totalHeight = 0;

	public CamsMainMenuForm(final CamsMainFrame mainFrame, int accessID) {
		setBounds(posX, posY, CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		mainFrame.setTitle("CaMS POS V1.0");

		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.logout();
				mainFrame.replacePanel("CamsLoginForm");
			}
		});
		btnLogin.setForeground(FOREGROUND_COLOUR);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnLogin.setBounds(20, 151, 234, 80);
		add(btnLogin);

		JButton btnNewOrder = new JButton("NEW ORDER");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsCreateOrderForm");
			}
		});
		btnNewOrder.setForeground(FOREGROUND_COLOUR);
		btnNewOrder.setFocusPainted(false);
		btnNewOrder.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnNewOrder.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewOrder.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnNewOrder.setBounds(274, 151, 234, 80);
		add(btnNewOrder);

		JButton btnAddMenuItem = new JButton("ADD NEW ITEM");
		btnAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsCreateMenuItemForm");
			}
		});
		btnAddMenuItem.setForeground(FOREGROUND_COLOUR);
		btnAddMenuItem.setFocusPainted(false);
		btnAddMenuItem.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnAddMenuItem.setFont(new Font("Arial", Font.BOLD, 16));
		btnAddMenuItem.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnAddMenuItem.setBounds(528, 151, 234, 80);
		add(btnAddMenuItem);

		JButton btnPending = new JButton("PENDING ORDERS");
		btnPending.setForeground(FOREGROUND_COLOUR);
		btnPending.setFocusPainted(false);
		btnPending.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnPending.setFont(new Font("Arial", Font.BOLD, 16));
		btnPending.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnPending.setBounds(20, 251, 234, 80);
		btnPending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsPendingOrderForm");
			}
		});
		add(btnPending);

		JButton btnRefund = new JButton("REFUND");
		btnRefund.setForeground(FOREGROUND_COLOUR);
		btnRefund.setFocusPainted(false);
		btnRefund.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnRefund.setFont(new Font("Arial", Font.BOLD, 16));
		btnRefund.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnRefund.setBounds(274, 251, 234, 80);
		btnRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsRefundOrderForm");
			}
		});
		add(btnRefund);

		JButton btnEditMenu = new JButton("EDIT MENU");
		btnEditMenu.setForeground(FOREGROUND_COLOUR);
		btnEditMenu.setFocusPainted(false);
		btnEditMenu.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		btnEditMenu.setFont(new Font("Arial", Font.BOLD, 16));
		btnEditMenu.setBackground(TITLEBAR_BACKGROUND_COLOUR);
		btnEditMenu.setBounds(528, 251, 234, 80);
		btnEditMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsListMenuItemForm");
			}
		});
		add(btnEditMenu);

		if (accessID != 2) {
			btnEditMenu.setEnabled(false);
			btnAddMenuItem.setEnabled(false);
		}

	}

}
