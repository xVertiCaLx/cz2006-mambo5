package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CamsCreateOrderForm extends JPanel {
	JPanel receiptPanel, keypadPanel, menuItemPanel;
	
	final JTextArea receipt = new JTextArea();

	JButton numPad_1 = new JButton("1");
	JButton numPad_2 = new JButton("2");
	JButton numPad_3 = new JButton("3");
	JButton numPad_4 = new JButton("4");
	JButton numPad_5 = new JButton("5");
	JButton numPad_6 = new JButton("6");
	JButton numPad_7 = new JButton("7");
	JButton numPad_8 = new JButton("8");
	JButton numPad_9 = new JButton("9");

	
	public CamsCreateOrderForm() {
		//default
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240,240,240));
		
		receipt.setBounds(10, 10, 180, 510);

		receiptPanel = new JPanel();
		receiptPanel.setBounds(0,0,200,560);
		receiptPanel.setLayout(null);
		receiptPanel.setBackground(new Color(250,250,250));
		receiptPanel.add(receipt);
		add(receiptPanel);
		
		keypadPanel = new JPanel();
		keypadPanel.setBounds(200,260,400,300);
		keypadPanel.setLayout(null);
		keypadPanel.setBackground(new Color(250,250,250));
		add(keypadPanel);
		
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_1.getText() + "    ");
			}
		});
		
		numPad_1.setFont(new Font("Arial", Font.BOLD, 12));
		numPad_1.setForeground(Color.WHITE);
		numPad_1.setBackground(Color.BLACK);
		numPad_1.setBounds(10, 10, 50, 50);
		keypadPanel.add(numPad_1);
		
		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_2.getText() + "    ");
			}
		});
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(70, 10, 50, 50);
		keypadPanel.add(numPad_2);		
		
		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_3.getText() + "    ");
			}
		});
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(130, 10, 50, 50);
		keypadPanel.add(numPad_3);
		
		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_4.getText() + "    ");
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBounds(10, 70, 50, 50);
		keypadPanel.add(numPad_4);
		
		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_5.getText() + "    ");
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBounds(10, 130, 50, 50);
		keypadPanel.add(numPad_5);
		
		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_6.getText() + "    ");
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBounds(518, 383, 57, 44);
		//add(numPad_6);
		
		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_7.getText() + "    ");
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBounds(378, 446, 57, 44);
		//add(numPad_7);
		
		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_8.getText() + "    ");
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBounds(448, 446, 57, 44);
		//add(numPad_8);
		
		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append(numPad_9.getText() + "    ");
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBounds(518, 446, 57, 44);
		//add(numPad_9);
	}

}