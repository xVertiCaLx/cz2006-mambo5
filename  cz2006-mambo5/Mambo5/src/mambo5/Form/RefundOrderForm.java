package mambo5.Form;

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
	private int num;

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
		setTitle("CaMS - Refund Order");
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
		
		final JTextField txtOrderId = new JTextField();
		txtOrderId.setBounds(297, 124, 211, 30);
		contentPane.add(txtOrderId);
		txtOrderId.setColumns(10);
		
		JLabel lblOrderId = new JLabel("ORDER ID:");
		lblOrderId.setBounds(223, 132, 64, 22);
		contentPane.add(lblOrderId);
		
		final JButton numPad_1 = new JButton("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_1) {
			        num=1;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_1.setForeground(Color.WHITE);
		numPad_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_1.setBackground(Color.BLACK);
		numPad_1.setBounds(251, 285, 57, 44);
		contentPane.add(numPad_1);
		
		final JButton numPad_2 = new JButton("2");
		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_2) {
			        num=2;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(321, 285, 57, 44);
		contentPane.add(numPad_2);
		
		final JButton numPad_3 = new JButton("3");
		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_3) {
			        num=3;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(391, 285, 57, 44);
		contentPane.add(numPad_3);
		
		final JButton numPad_4 = new JButton("4");
		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_4) {
			        num=4;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setBounds(251, 344, 57, 44);
		contentPane.add(numPad_4);
		
		final JButton numPad_5 = new JButton("5");
		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_5) {
			        num=5;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setBounds(321, 344, 57, 44);
		contentPane.add(numPad_5);
		
		final JButton numPad_6 = new JButton("6");
		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_6) {
			        num=6;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setBounds(391, 344, 57, 44);
		contentPane.add(numPad_6);
		
		final JButton numPad_7 = new JButton("7");
		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_7) {
			        num=7;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setBounds(251, 407, 57, 44);
		contentPane.add(numPad_7);
		
		final JButton numPad_8 = new JButton("8");
		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_8) {
			        num=8;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setBounds(321, 407, 57, 44);
		contentPane.add(numPad_8);
		
		final JButton numPad_9 = new JButton("9");
		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_9) {
			        num=9;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setBounds(391, 407, 57, 44);
		contentPane.add(numPad_9);
		
		JButton btnBackspace = new JButton("DELETE");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtOrderId.getText().equals(""))
				txtOrderId.setText(txtOrderId.getText().substring(0, txtOrderId.getText().length()-1)); 
			}
		});
		btnBackspace.setForeground(Color.WHITE);
		btnBackspace.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBackspace.setBackground(Color.BLACK);
		btnBackspace.setBounds(469, 301, 100, 58);
		contentPane.add(btnBackspace);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setBounds(469, 378, 100, 58);
		contentPane.add(btnEnter);
		
		JButton button_12 = new JButton("Main Page");
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setBackground(Color.RED);
		button_12.setBounds(297, 182, 100, 23);
		contentPane.add(button_12);
	}
}
