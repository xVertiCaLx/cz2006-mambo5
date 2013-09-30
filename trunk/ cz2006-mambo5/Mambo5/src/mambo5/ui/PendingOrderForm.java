package mambo5.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class PendingOrderForm extends JPanel {

	/**
	 * Create the panel.
	 */
	public PendingOrderForm() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pending Order"
				+ "");
		add(lblNewLabel);
		
		JLabel lblPendingOrders = new JLabel("PENDING ORDERS");
		lblPendingOrders.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPendingOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendingOrders.setBounds(353, 0, 107, 24);
		add(lblPendingOrders);
		
		JLabel label = new JLabel("Canteen A,Le Cafe");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 0, 187, 24);
		add(label);
		
		JButton btnNewButton = new JButton("ORDER 001");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(353, 35, 141, 54);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(353, 340, 61, 54);
		add(btnNewButton_1);
		
		JButton button_11 = new JButton("2");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_11.setBounds(424, 340, 61, 54);
		add(button_11);
		
		JButton button_12 = new JButton("3");
		button_12.setBounds(495, 340, 61, 54);
		add(button_12);
		
		JButton button = new JButton("ORDER 002");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(503, 35, 141, 54);
		add(button);
		
		JButton button_1 = new JButton("ORDER 003");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(654, 35, 141, 54);
		add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(353, 405, 61, 54);
		add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(424, 405, 61, 54);
		add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(495, 405, 61, 54);
		add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.setBounds(353, 470, 61, 54);
		add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(424, 470, 61, 54);
		add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(495, 470, 61, 54);
		add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_8.setBounds(353, 535, 132, 54);
		add(button_8);
		
		JButton button_9 = new JButton(".");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_9.setBounds(495, 534, 61, 54);
		add(button_9);
		
		JButton button_10 = new JButton("ORDER 004");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_10.setBounds(353, 100, 141, 54);
		add(button_10);
		
		JButton button_13 = new JButton("ORDER 005");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_13.setBounds(503, 100, 141, 54);
		add(button_13);
		
		JButton button_14 = new JButton("ORDER 006");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_14.setBounds(654, 100, 141, 54);
		add(button_14);
		
		JButton button_15 = new JButton("ORDER 007");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_15.setBounds(353, 165, 141, 54);
		add(button_15);
		
		JButton button_16 = new JButton("ORDER 008");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_16.setBounds(503, 165, 141, 54);
		add(button_16);
		
		JButton button_17 = new JButton("ORDER 009");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_17.setBounds(654, 165, 141, 54);
		add(button_17);
		
		JButton button_18 = new JButton("ORDER 010");
		button_18.setBounds(353, 230, 141, 54);
		add(button_18);
		
		JButton button_19 = new JButton("ORDER 011");
		button_19.setBounds(503, 230, 141, 54);
		add(button_19);
		
		JButton button_20 = new JButton("ORDER 012");
		button_20.setBounds(654, 230, 141, 54);
		add(button_20);
		
		JButton button_21 = new JButton("BACK");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_21.setBounds(566, 338, 132, 58);
		add(button_21);
		
		JButton button_22 = new JButton("ENTER");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_22.setBounds(566, 405, 132, 54);
		add(button_22);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBounds(699, 501, 114, 23);
		add(btnPreviousPage);
		
		JButton button_23 = new JButton("Next Page");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_23.setBounds(699, 535, 114, 23);
		add(button_23);
		
		JButton button_24 = new JButton("Main Page");
		button_24.setBounds(699, 569, 114, 23);
		add(button_24);
		
		JTextPane txtpnSada = new JTextPane();
		txtpnSada.setText("sada");
		txtpnSada.setBounds(10, 37, 309, 214);
		add(txtpnSada);
		
		JButton btnNewButton_2 = new JButton("COMPLETE ORDER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 261, 309, 23);
		add(btnNewButton_2);

	}

}
