package mambo5.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(353, 35, 141, 54);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(348, 341, 61, 54);
		add(btnNewButton_1);
		
		JButton button_11 = new JButton("1");
		button_11.setBounds(419, 341, 61, 54);
		add(button_11);
		
		JButton button_12 = new JButton("1");
		button_12.setBounds(490, 341, 61, 54);
		add(button_12);
		
		JButton button = new JButton("New button");
		button.setBounds(503, 35, 141, 54);
		add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(654, 35, 141, 54);
		add(button_1);
		
		JButton button_2 = new JButton("1");
		button_2.setBounds(348, 406, 61, 54);
		add(button_2);
		
		JButton button_3 = new JButton("1");
		button_3.setBounds(419, 406, 61, 54);
		add(button_3);
		
		JButton button_4 = new JButton("1");
		button_4.setBounds(490, 406, 61, 54);
		add(button_4);
		
		JButton button_5 = new JButton("1");
		button_5.setBounds(348, 471, 61, 54);
		add(button_5);
		
		JButton button_6 = new JButton("1");
		button_6.setBounds(419, 471, 61, 54);
		add(button_6);
		
		JButton button_7 = new JButton("1");
		button_7.setBounds(490, 471, 61, 54);
		add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_8.setBounds(348, 536, 132, 54);
		add(button_8);
		
		JButton button_9 = new JButton(".");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_9.setBounds(490, 535, 61, 54);
		add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(353, 100, 141, 54);
		add(button_10);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(503, 100, 141, 54);
		add(button_13);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(654, 100, 141, 54);
		add(button_14);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(353, 165, 141, 54);
		add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(503, 165, 141, 54);
		add(button_16);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(654, 165, 141, 54);
		add(button_17);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(353, 230, 141, 54);
		add(button_18);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(503, 230, 141, 54);
		add(button_19);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(654, 230, 141, 54);
		add(button_20);
		
		JButton button_21 = new JButton("BACK");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_21.setBounds(564, 345, 132, 54);
		add(button_21);
		
		JButton button_22 = new JButton("ENTER");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_22.setBounds(564, 410, 132, 50);
		add(button_22);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBounds(700, 502, 114, 23);
		add(btnPreviousPage);
		
		JButton button_23 = new JButton("Next Page");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_23.setBounds(700, 536, 114, 23);
		add(button_23);
		
		JButton button_24 = new JButton("Main Page");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_24.setBounds(700, 570, 114, 23);
		add(button_24);

	}

}
