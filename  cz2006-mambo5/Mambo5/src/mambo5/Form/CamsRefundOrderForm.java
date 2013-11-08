//DESIGN UNIFIED
//LOGIN TESTED
//JUNIT PENDING

package mambo5.Form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mambo5.Controller.CustomerController;
import mambo5.Controller.JInterfaceController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;

public class CamsRefundOrderForm extends JPanel implements JInterfaceController {

	JPanel refundPanel;
	final JTextField txtOrderId = new JTextField();

	private NumPad numpad = new NumPad();
	private ArrayList<Order> orderIDList;
	private ArrayList<OrderDetail> orderDetailList;
	private OrderController OrderController;
	private OrderDetailController OrderDetailController;
	private CustomerController cc;

	JLabel lblOrderId = new JLabel("ORDER ID:");
	JButton btnRefund = new JButton("REFUND");
	
	public CamsRefundOrderForm(final CamsMainFrame mainFrame, int stallID) {

		orderIDList = new ArrayList<Order>();
		orderDetailList = new ArrayList<OrderDetail>();
		OrderController = new OrderController();
		OrderController.retrieveOrderIDList(orderIDList, stallID, "Processing");

		setBounds(0, 40, 800, 560);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		refundPanel = new JPanel();
		refundPanel.setBounds(210, 50, 400, 440);
		refundPanel.setLayout(null);
		refundPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		add(refundPanel);

		txtOrderId.setBounds(90, 80, 211, 30);
		txtOrderId.setBorder(new LineBorder(TITLEBAR_BORDER_COLOUR, 1, true));
		refundPanel.add(txtOrderId);
		txtOrderId.setColumns(10);

		lblOrderId.setBounds(20, 85, 64, 22);
		refundPanel.add(lblOrderId);
		
		numpad.setLocation(20,200);
		numpad.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		
		numpad.num1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "1");
			}
		});
		
		numpad.num2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "2");
			}
		});
		
		numpad.num3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "3");
			}
		});
		
		numpad.num4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "4");
			}
		});
		
		numpad.num5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "5");
			}
		});
		
		numpad.num6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "6");
			}
		});
		
		numpad.num7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "7");
			}
		});
		
		numpad.num8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "8");
			}
		});
		
		numpad.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "9");
			}
		});
		
		numpad.num0().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOrderId.setText(txtOrderId.getText() + "0");
			}
		});
		
		numpad.delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtOrderId.getText().equals(""))
					txtOrderId.setText(txtOrderId.getText().substring(0,
							txtOrderId.getText().length() - 1));
			}
		});
		
		numpad.enter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitOrderID();
			}
		});
		
		refundPanel.add(numpad);

	}

	public void submitOrderID() {
		double currentCardValue = 0.0;
		double totalPrice = 0.0;
		int orderID = 0;

		try {
			orderID = Integer.parseInt(txtOrderId.getText());
		} catch (NumberFormatException e) { }

		for (int i = 0; i < orderIDList.size(); i++) {
			if (orderIDList.get(i).getOrderID() == orderID) {
				cc = new CustomerController();

				try {
					int custID = (Integer.parseInt(JOptionPane
							.showInputDialog("Please enter Customer ID: ")));;
					
					if (cc.retrieveCustomerInfo(custID) != null) {
						currentCardValue = cc.retrieveCustomerInfo(custID)
								.getCardBalance();
						OrderController = new OrderController();
						OrderDetailController = new OrderDetailController();
						OrderDetailController.retrieveOrderDetailTotalPrice(
								orderDetailList, orderID);

						for (i = 0; i < orderDetailList.size(); i++)
							totalPrice += (orderDetailList.get(i)
									.getActualPrice() * orderDetailList.get(i)
									.getQuantity());

						if (OrderController.validateRefundOrder(orderID) == 1) {
							JOptionPane.showMessageDialog(null, "Order "
									+ orderID + " successfuly refunded");
							cc.updateCustomerCardBalance(custID,
									(currentCardValue + totalPrice));
							for (int k = 0; k < orderIDList.size(); k++) {
								int val = orderIDList.get(k).getOrderID();
								if (val == orderID) {
									orderIDList.remove(k);
									break;
								}
							}
							break;
						} // end if(OrderController.validateRefundOrder(orderID)
							// == 1

						else {
							JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
							repaint();
							break;
						}
					} else
						JOptionPane.showMessageDialog(null,
								"Invalid Customer ID");
				} // end try
				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null,
							"Please Enter Only Integer Value for Customer ID");
				}
			}// end if(orderIDList.get(i).getOrderID() == orderID)
		}// end for loop
		
		txtOrderId.setText("");
	}
}// end JPanel

