package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;

public class CamsPendingOrderForm extends JPanel implements JInterfaceController {

	private JPanel receiptPanel, ordersPanel, sidePanel, searchPanel;

	private int stallID, posX = 0, posY = 0, orderID;
	private JTextArea receipt;
	private JScrollPane receiptScrollPane;
	private Map<JButton, Order> orderButtons;
	private Map<Order, ArrayList<OrderDetail>> orderDetails;
	private Map<Integer, MenuItem> menuItems;
	private ArrayList<Order> orderIDList = new ArrayList<Order>();
	private OrderController OrderController;
	private JButton btnConfirmOrder;
	
	//guohao testing
	private ArrayList<OrderDetail> orderDetailList;// = new ArrayList<OrderDetail>();
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private OrderDetailController OrderDetailController = new OrderDetailController();;
	private MenuItemController menuItemController = new MenuItemController();

	private NumPad numpadPanel;
	private JButton btnMainPage = new JButton("MAIN PAGE"),
			btnNextPage = new JButton("NEXT PAGE"), btnPrevPage = new JButton(
					"PREV PAGE"), btnSearch;
	private JTextField searchIDTextField;

	public CamsPendingOrderForm(final CamsMainFrame mainFrame, int stallID) {

		this.stallID = stallID;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		
		initPanels();
		initOrderIDButtons(stallID);
		implementButtons();
		initSidePanelButton();
		
		menuItems = new HashMap<Integer, MenuItem>();
		menuItemList = new ArrayList<MenuItem>();
		menuItemList = menuItemController.retrieveMenuItemList(menuItemList);
		
		for (int i = 0; i < menuItemList.size(); i++) {
			menuItems.put(menuItemList.get(i).getMenuItemID(), menuItemList.get(i));
		}
		
		//init time
		orderDetails = new HashMap<Order, ArrayList<OrderDetail>>();
		
		for (int i =0; i< orderIDList.size(); i++)
		{
			orderDetailList = new ArrayList<OrderDetail>();
			//OrderDetailController.retrieveOrderDetailList(orderDetailList, orderIDList.get(i).getOrderID());	
			orderDetails.put(orderIDList.get(i), orderDetailList);
			System.out.println((orderDetails.get(orderIDList.get(i))).get(0).getMenuItemID());
		
		}
		
		receipt.setText(receipt.getText() + "ORDER ID: " + orderDetails.get(orderIDList.get(0)).get(0).getOrderID() + "\n");
		
		for (int i =0; i < orderDetails.get(orderIDList.get(0)).size(); i++)
		{

		receipt.setText(receipt.getText() 
				+ menuItems.get(orderDetails.get(orderIDList.get(0)).get(i).getMenuItemID()).getMenuItemName() + "\t\t\t"
				+ orderDetails.get(orderIDList.get(0)).get(i).getActualPrice() + "\n");
		}
		
	}

	public void initPanels() {

		// Receipt Panel
		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT / 2));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		receiptPanel.setLayout(null);

		// receipt
		receipt = new JTextArea();
		receipt.setSize(new Dimension(RECEIPT_WIDTH, RECEIPT_HEIGHT / 2 + 140));
		receipt.setBackground(WHITE_BACKGROUND_COLOUR);

		receipt.setEditable(false);

		// enable scroll
		receiptScrollPane = new JScrollPane();
		receiptScrollPane.setSize(new Dimension(RECEIPT_WIDTH,
				RECEIPT_HEIGHT / 2 + 140));
		receiptScrollPane.setLocation(MARGIN, MARGIN);
		receiptScrollPane.setBackground(WHITE_BACKGROUND_COLOUR);
		receiptScrollPane.add(receipt);
		receiptPanel.add(receiptScrollPane);

		posY += receiptPanel.getHeight();

		// Search Panel
		searchPanel = new JPanel();
		searchPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT / 2 - 100));
		searchPanel.setLocation(posX, posY);
		searchPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		searchPanel.setLayout(null);

		// JTextField
		searchIDTextField = new JTextField();
		searchIDTextField.setSize(new Dimension(RECEIPTPANE_WIDTH / 2
				- (3 * MARGIN), JTEXTFIELD_HEIGHT));
		searchIDTextField.setLocation(MARGIN * 9, MARGIN * 9);

		// Search Button
		btnSearch = new JButton("SEARCH");
		btnSearch.setSize(new Dimension(SIDEPANE_WIDTH,
				STANDARDBUTTON_HEIGHT + 20));
		btnSearch.setLocation(75, 120);
		
		//ConfirmOrder Button
		btnConfirmOrder = new JButton("CONFIRM ORDER");
		btnConfirmOrder.setSize(new Dimension(SIDEPANE_WIDTH,
				STANDARDBUTTON_HEIGHT));
		btnConfirmOrder.setLocation(RECEIPT_WIDTH/2, 0);
		
		//adding sub component to searchPanel
		searchPanel.add(searchIDTextField);
		searchPanel.add(btnSearch);
		searchPanel.add(btnConfirmOrder);
		
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				String message = "Order " + orderID + " was not confirmed!";
				
				OrderController = new OrderController();
				if (OrderController.validateConfirmOrder(orderID) == 1)
					message = "Order " + orderID + " has completed";
				else
					repaint();
				
				searchIDTextField.setText("");
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tempTotal = 0.00;
				orderID = Integer.parseInt(searchIDTextField.getText());
				receipt.setText("ORDER: " + orderID + "\n"
						+ "========================================" + "\n");
				receipt.setText(receipt.getText() + "Qty"+"   ItemName"+ "\t" +"UnitPrice"+ "      " +"TotalAmount\n");
				for (int j = 0; j < orderIDList.size(); j++) {		
					if (orderIDList.get(j).getOrderID() == Integer.parseInt(searchIDTextField.getText())) {
						for (int i = 0; i < orderDetails.get(orderIDList.get(j)).size(); i++) {
							receipt.append(orderDetails.get(orderIDList.get(j)).get(i).getQuantity() + "   " +
						menuItems.get(orderDetails.get(orderIDList.get(j)).get(i).getMenuItemID()).getMenuItemName() 
						+ "  $" +orderDetails.get(orderIDList.get(j)).get(i).getActualPrice() + "" +
						"\t" + "$" +(orderDetails.get(orderIDList.get(j)).get(i).getQuantity() * orderDetails.get(orderIDList.get(j)).get(i).getActualPrice())
						+ "\n");
							tempTotal += (orderDetails.get(orderIDList.get(j)).get(i).getQuantity() * orderDetails.get(orderIDList.get(j)).get(i).getActualPrice());
						}
					}
				}
				receipt.setText(receipt.getText() + "\n\n" + "========================================\n"
				+ "TOTAL: \t\t" + "$" +tempTotal+ "\n========================================");

	
			}
		});

		posX = receiptPanel.getWidth();
		posY = 0;

		// Orders Panel
		ordersPanel = new JPanel();
		ordersPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,
				MENUITEMPANE_HEIGHT));
		ordersPanel.setLocation(posX, posY);
		ordersPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		posY += ordersPanel.getHeight();

		// NumPad Panel
		numpadPanel = new NumPad();
		numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		numpadPanel.setLocation(posX, posY);
		posX += numpadPanel.getWidth();

		// Side Panel
		sidePanel = new JPanel();
		sidePanel.setLayout(null);
		sidePanel.setSize(new Dimension(SIDEPANE_WIDTH, SIDEPANE_HEIGHT));
		sidePanel.setLocation(posX, posY+50);

		posX = (RECEIPTPANE_WIDTH - btnSearch.getWidth()) / 2;
		posY += searchIDTextField.getAlignmentY()
				+ searchIDTextField.getHeight() + MARGIN;


		
		add(receiptPanel);
		add(searchPanel);
		add(ordersPanel);
		add(numpadPanel);
		add(sidePanel);

	}

	
	
	// initialise order item buttons
	public void initOrderIDButtons(int stallID) {
		orderButtons = new HashMap<JButton, Order>();
		orderIDList = new ArrayList<Order>();
		OrderController = new OrderController();
		OrderController.retrieveOrderIDList(orderIDList, stallID, "Processing");
		
		for (int i = 0; i < orderIDList.size(); i++) {
			addOrderIDButtons(orderIDList.get(i));
		}

	}

	public void addOrderIDButtons(Order order) {
		JButton orderIDButton = new JButton("Order "
				+ Integer.toString(order.getOrderID()));
		orderIDButton.setActionCommand(Integer.toString(order.getOrderID()));
		orderButtons.put(orderIDButton, order);
		orderIDButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double tempTotal = 0.00;
				orderID = orderDetails.get(orderButtons.get(e.getSource())).get(0).getOrderID();
				receipt.setText("ORDER: " + orderID + "\n"
						+ "========================================" + "\n");
				receipt.setText(receipt.getText() + "Qty"+"   ItemName"+ "\t" +"UnitPrice"+ "      " +"TotalAmount\n");
				for (int j = 0; j < orderIDList.size(); j++) {		
					if (orderIDList.get(j).getOrderID() == orderDetails.get(orderButtons.get(e.getSource())).get(0).getOrderID()) {
						for (int i = 0; i < orderDetails.get(orderIDList.get(j)).size(); i++) {
							receipt.append(orderDetails.get(orderIDList.get(j)).get(i).getQuantity() + "   " +
						menuItems.get(orderDetails.get(orderIDList.get(j)).get(i).getMenuItemID()).getMenuItemName() 
						+ "  $" +orderDetails.get(orderIDList.get(j)).get(i).getActualPrice() + "" +
						"\t" + "$" +(orderDetails.get(orderIDList.get(j)).get(i).getQuantity() * orderDetails.get(orderIDList.get(j)).get(i).getActualPrice())
						+ "\n");
							tempTotal += (orderDetails.get(orderIDList.get(j)).get(i).getQuantity() * orderDetails.get(orderIDList.get(j)).get(i).getActualPrice());
						}
					}
				}
				receipt.setText(receipt.getText() + "\n\n" + "========================================\n"
				+ "TOTAL: \t\t" + "$" +tempTotal+ "\n========================================");
			}
		});
		
		ordersPanel.add(orderIDButton);	
}

	public void initKeypad() {
		// initialise number pad
		numpadPanel = new NumPad();
		numpadPanel.setLayout(null);
		numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		numpadPanel.setLocation(posX, posY);
		// implement action listener
		implementButtons();
	}

	public void initSidePanelButton() {
		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainPage.setBackground(new Color(255, 0, 0));
		btnMainPage.setBounds(10, 10, 110, 70);
		sidePanel.add(btnMainPage);

		btnNextPage.setForeground(Color.WHITE);
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBackground(new Color(100, 149, 237));
		btnNextPage.setBounds(10, 90, 110, 50);
		sidePanel.add(btnNextPage);

		btnPrevPage.setForeground(Color.WHITE);
		btnPrevPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrevPage.setBackground(new Color(100, 149, 237));
		btnPrevPage.setBounds(10, 150, 110, 50);
		sidePanel.add(btnPrevPage);
	}

	public void implementButtons() {
		// actual implementation
		numpadPanel.num1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "1");
			}
		});

		numpadPanel.num2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "2");
			}
		});

		numpadPanel.num3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "3");
			}
		});

		numpadPanel.num4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "4");
			}
		});

		numpadPanel.num5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "5");
			}
		});

		numpadPanel.num6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "6");
			}
		});

		numpadPanel.num7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "7");
			}
		});

		numpadPanel.num8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "8");
			}
		});

		numpadPanel.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText() + "9");
			}
		});

		numpadPanel.delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField
						.setText(searchIDTextField.getText().substring(0,
								searchIDTextField.getText().length() - 1));
			}
		});
		
		numpadPanel.enter().setVisible(false);
	}
}
