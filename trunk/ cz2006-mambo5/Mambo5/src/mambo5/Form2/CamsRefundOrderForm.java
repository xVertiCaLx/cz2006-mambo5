package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mambo5.Controller.OrderController;
import mambo5.Entity.Order;

public class CamsRefundOrderForm extends JPanel {

	JPanel refundPanel; 
	final JTextField txtOrderId = new JTextField();
	
	private int num;
	private ArrayList<Order> orderIDList;
	private OrderController OrderController;
	
	JButton numPad_1 = new JButton("1");
	JButton numPad_2 = new JButton("2");
	JButton numPad_3 = new JButton("3");
	JButton numPad_4 = new JButton("4");
	JButton numPad_5 = new JButton("5");
	JButton numPad_6 = new JButton("6");
	JButton numPad_7 = new JButton("7");
	JButton numPad_8 = new JButton("8");
	JButton numPad_9 = new JButton("9");
	
	JButton btnEnter = new JButton("ENTER");
	JButton btnDelete = new JButton("DELETE");
	JLabel lblOrderId = new JLabel("ORDER ID:");
	JButton btnRefund = new JButton("REFUND");
	
	public CamsRefundOrderForm(final CamsMainFrame mainFrame) {
	
		orderIDList = new ArrayList<Order>();
		OrderController = new OrderController();
		OrderController.retrieveOrderIDList(orderIDList, 5, "Processing");
		
		for (int i = 0; i < orderIDList.size(); i++) {
			System.out.println("element" + i + ":" + orderIDList.get(i).getOrderID());
		}
		
		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(new Color(240,240,240));
		
		refundPanel = new JPanel();
		refundPanel.setBounds(210,50,400,440);
		refundPanel.setLayout(null);
		refundPanel.setBackground(new Color(250,250,250));
		add(refundPanel);
		
	//	btnRefund.setBounds(210, 100, 90, 25);
	//	refundPanel.add(btnRefund);
		
		txtOrderId.setBounds(90, 80, 211, 30);
		refundPanel.add(txtOrderId);
		txtOrderId.setColumns(10);
		
		lblOrderId.setBounds(20, 80, 64, 22);
		refundPanel.add(lblOrderId);
		
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_1) {
			        num=1;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});		
		numPad_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_1.setForeground(Color.WHITE);
		numPad_1.setBackground(Color.BLACK);
		numPad_1.setBounds(20, 210, 60, 60);
		refundPanel.add(numPad_1);
		
		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_2) {
			        num=2;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(90, 210, 60, 60);
		refundPanel.add(numPad_2);		
		
		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_3) {
			        num=3;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(160, 210, 60, 60);
		refundPanel.add(numPad_3);
		
		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_4) {
			        num=4;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBounds(20, 280, 60, 60);
		refundPanel.add(numPad_4);
		
		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_5) {
			        num=5;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBounds(90, 280, 60, 60);
		refundPanel.add(numPad_5);
		
		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_6) {
			        num=6;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBounds(160, 280, 60, 60);
		refundPanel.add(numPad_6);
		
		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_7) {
			        num=7;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBounds(20, 350, 60, 60);
		refundPanel.add(numPad_7);
		
		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_8) {
			        num=8;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBounds(90, 350, 60, 60);
		refundPanel.add(numPad_8);
		
		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == numPad_9) {
			        num=9;
			        txtOrderId.setText(txtOrderId.getText() + num);
			    }
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBounds(160, 350, 60, 60);
		refundPanel.add(numPad_9);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtOrderId.getText().equals(""))
				txtOrderId.setText(txtOrderId.getText().substring(0, txtOrderId.getText().length()-1)); 
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(250, 230, 100, 58);
		refundPanel.add(btnDelete);
		
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnter.setBackground(Color.GREEN);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitOrderID();
			}
		});
		btnEnter.setBounds(250, 300, 100, 100);
		refundPanel.add(btnEnter);
		
	
	}

	public void submitOrderID() 
	{		
		String message = "Order: " + txtOrderId.getText() + "is not in the system";
		try
		{
			int orderID=Integer.parseInt(txtOrderId.getText());
			txtOrderId.requestFocusInWindow();
			for (int i=0; i<orderIDList.size(); i++)
			{
				
				if(orderIDList.get(i).getOrderID() == orderID)
				{
					OrderController = new OrderController();
					if (OrderController.validateRefundOrder(orderID) == 1)
					{
						message = "Order " + orderID + " successfuly refunded";
						for (int k=0; k<orderIDList.size(); k++) 
						{
							 int val = orderIDList.get(k).getOrderID();
							 if(val==orderID)
								orderIDList.remove(k);
							 	break;
						}			
						break;
					}
					else
					{
						repaint();
						break;
					}
				}//end outer if
			}//end for loop
		}
		catch (Exception z)
		{
			JOptionPane.showMessageDialog(this, "Incorrect Data Type! Numbers Only!",  
	                "Input Error", JOptionPane.ERROR_MESSAGE);   
				 txtOrderId.requestFocusInWindow();  
	             return;  
		} //end catch
		
		txtOrderId.setText("");
		JOptionPane.showMessageDialog(null, message);
	}
}//end JPanel
	
