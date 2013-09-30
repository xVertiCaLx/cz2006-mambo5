package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class RefundOrderForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrderId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefundOrderForm frame = new RefundOrderForm();
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
	public RefundOrderForm() {	
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
		
		JLabel label_1 = new JLabel("#Canteen");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(0, 0, 784, 39);
		panel.add(label_1);
		
		JButton btnRefund = new JButton("REFUND");
		btnRefund.setBounds(424, 182, 89, 23);
		contentPane.add(btnRefund);
		
		txtOrderId = new JTextField();
		txtOrderId.setBounds(297, 124, 211, 30);
		contentPane.add(txtOrderId);
		txtOrderId.setColumns(10);
		
		JLabel lblOrderId = new JLabel("ORDER ID:");
		lblOrderId.setBounds(223, 132, 64, 22);
		contentPane.add(lblOrderId);
		
		JButton button = new JButton("1");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(Color.BLACK);
		button.setBounds(250, 249, 57, 44);
		contentPane.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(320, 249, 57, 44);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(390, 249, 57, 44);
		contentPane.add(button_2);
		
		JButton btnBackspace = new JButton("DELETE");
		btnBackspace.setForeground(Color.WHITE);
		btnBackspace.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBackspace.setBackground(Color.BLACK);
		btnBackspace.setBounds(469, 249, 100, 98);
		contentPane.add(btnBackspace);
		
		JButton button_4 = new JButton("6");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(390, 308, 57, 44);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(320, 308, 57, 44);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("4");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(250, 308, 57, 44);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setBackground(Color.BLACK);
		button_7.setBounds(250, 371, 57, 44);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8.setBackground(Color.BLACK);
		button_8.setBounds(320, 371, 57, 44);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9.setBackground(Color.BLACK);
		button_9.setBounds(390, 371, 57, 44);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setBackground(Color.BLACK);
		button_10.setBounds(250, 433, 197, 44);
		contentPane.add(button_10);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setBounds(469, 378, 100, 98);
		contentPane.add(btnEnter);
		
		JButton button_12 = new JButton("Main Page");
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setBackground(Color.RED);
		button_12.setBounds(297, 182, 100, 23);
		contentPane.add(button_12);
	}
}
