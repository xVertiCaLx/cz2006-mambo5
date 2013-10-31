package mambo5.Form;

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
import mambo5.Controller.OrderController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;

public class CamsPendingOrderForm extends JPanel implements
		JInterfaceController {

	private JPanel receiptPanel, ordersPanel, sidePanel, searchPanel;

	private CamsMainFrame mainFrame;
	private int stallID, posX = 0, posY = 0, orderID, totalHeight = 0,
			totalWidth = 0, currentItem = 0, page = 1;
	private JTextArea receipt;
	private JScrollPane receiptScrollPane;
	private Map<JButton, Order> orderButtons;
	private Map<Order, ArrayList<OrderDetail>> orderDetails;
	private Map<Integer, MenuItem> menuItems;
	private ArrayList<OrderDetail> orderDetailList;
	private ArrayList<Order> orderIDList = new ArrayList<Order>();
	private OrderController OrderController;
	private JButton btnConfirmOrder;
	
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

	private NumPad numpadPanel;
	private JButton btnMainPage = new JButton("MAIN PAGE"),
			btnNextPage = new JButton("NEXT PAGE"), btnPrevPage = new JButton(
					"PREV PAGE"), btnSearch;
	private JTextField searchIDTextField;

	public CamsPendingOrderForm(final CamsMainFrame mainFrame,
			ArrayList<OrderDetail> orderDetailList, ArrayList<Order> orderList,
			ArrayList<MenuItem> menuItemList, int stallID, int menuID)
	{
		this.mainFrame = mainFrame;
		System.out.println("STALL: " + stallID);
		this.stallID = stallID;
		this.menuItemList = menuItemList;
		this.mainFrame = mainFrame;
		orderDetails = new HashMap<Order, ArrayList<OrderDetail>>();
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		initLists(orderList, orderDetailList, menuID);
		initPanels();
		initOrderButtons(stallID, this.orderIDList);
		implementButtons();
		initSidePanelButton();

	}

	public void initPanels() {

		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT / 2));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		receiptPanel.setLayout(null);

		receipt = new JTextArea();
		receipt.setSize(new Dimension(RECEIPT_WIDTH, RECEIPT_HEIGHT / 2 + 140));
		receipt.setBackground(WHITE_BACKGROUND_COLOUR);

		receipt.setEditable(false);

		receiptScrollPane = new JScrollPane();
		receiptScrollPane.setSize(new Dimension(RECEIPT_WIDTH,
				RECEIPT_HEIGHT / 2 + 140));
		receiptScrollPane.setLocation(MARGIN, MARGIN);
		receiptScrollPane.setBackground(WHITE_BACKGROUND_COLOUR);
		receiptScrollPane.add(receipt);
		receiptPanel.add(receiptScrollPane);

		posY += receiptPanel.getHeight();

		searchPanel = new JPanel();
		searchPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT / 2 - 100));
		searchPanel.setLocation(posX, posY);
		searchPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		searchPanel.setLayout(null);

		searchIDTextField = new JTextField();
		searchIDTextField.setSize(new Dimension(RECEIPTPANE_WIDTH / 2
				- (3 * MARGIN), JTEXTFIELD_HEIGHT));
		searchIDTextField.setLocation(MARGIN * 9, MARGIN * 9);

		btnSearch = new JButton("SEARCH");
		btnSearch.setSize(new Dimension(SIDEPANE_WIDTH,
				STANDARDBUTTON_HEIGHT + 20));
		btnSearch.setLocation(75, 120);

		btnConfirmOrder = new JButton("CONFIRM ORDER");
		btnConfirmOrder.setSize(new Dimension(SIDEPANE_WIDTH,
				STANDARDBUTTON_HEIGHT));
		btnConfirmOrder.setLocation(RECEIPT_WIDTH / 2, 0);

		searchPanel.add(searchIDTextField);
		searchPanel.add(btnSearch);
		searchPanel.add(btnConfirmOrder);

		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val =0;
				String message = "Order " + orderID + " was not confirmed!";

				OrderController = new OrderController();
				if (OrderController.validateConfirmOrder(orderID) == 1)
				{
					message = "Order " + orderID + " has completed";
					System.out.println("val is(before): " +val);
					//Iterate through the arraylist and remove the orderID from it
					for (int k = 0; k < orderIDList.size(); k++) {
						val = orderIDList.get(k).getOrderID();
						if (val == orderID) {
							System.out.println("val is(after): " +val);
							System.out.println("CAME INTO val == orderID");
							orderIDList.remove(k);
							break;
						}	
					}
					mainFrame.init();
					mainFrame.replacePanel("CamsPendingOrderForm");
				}
				else		
					JOptionPane.showMessageDialog(null, message);			
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tempTotal = 0.00;
				orderID = Integer.parseInt(searchIDTextField.getText());
				receipt.setText("ORDER: " + orderID + "\n"
						+ "========================================" + "\n");
				receipt.setText(receipt.getText() + "Qty" + "   ItemName"
						+ "\t" + "      " + "TotalAmount\n");
				for (int i = 0; i < orderIDList.size(); i++) {
					if (orderIDList.get(i).getOrderID() == Integer
							.parseInt(searchIDTextField.getText())) {
						for (int j = 0; j < orderDetails.get(orderIDList.get(i))
								.size(); j++) {
							receipt.append(orderDetails.get(orderIDList.get(i)).get(j).getQuantity()
									+ "   "
									+ menuItems.get(
											orderDetails.get(orderIDList.get(i))
													.get(j).getMenuItemID())
											.getMenuItemName()
									+ "  $"
									+ orderDetails.get(orderIDList.get(i)).get(j)
											.getActualPrice()
									+ ""
									+ "\t"
									+ "$"
									+ (orderDetails.get(orderIDList.get(i))
											.get(j).getQuantity() * orderDetails
											.get(orderIDList.get(i)).get(j)
											.getActualPrice()) + "\n");
							tempTotal += (orderDetails.get(orderIDList.get(i))
									.get(j).getQuantity() * orderDetails
									.get(orderIDList.get(i)).get(j)
									.getActualPrice());
						}
					}
				}
				receipt.setText(receipt.getText() + "\n\n"
						+ "========================================\n"
						+ "TOTAL: \t\t" + "$" + tempTotal
						+ "\n========================================");

			}
		});

		posX = receiptPanel.getWidth();
		posY = 0;

		// Orders Panel
		ordersPanel = new JPanel();
		ordersPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,
				MENUITEMPANE_HEIGHT));
		ordersPanel.setLocation(posX, posY);
		ordersPanel.setLayout(null);
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
		sidePanel.setLocation(posX, posY + 50);

		posX = (RECEIPTPANE_WIDTH - btnSearch.getWidth()) / 2;
		posY += searchIDTextField.getAlignmentY()
				+ searchIDTextField.getHeight() + MARGIN;

		add(receiptPanel);
		add(searchPanel);
		add(ordersPanel);
		add(numpadPanel);
		add(sidePanel);

	}

	public void initLists(ArrayList<Order> orderList,
			ArrayList<OrderDetail> orderDetailList, int menuID) {
		boolean write = false;

		menuItems = new HashMap<Integer, MenuItem>();
		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuID);
			if (menuItemList.get(i).getMenuID() == menuID) {
				menuItems.put(menuItemList.get(i).getMenuItemID(),
						menuItemList.get(i));
				System.out.println(menuItemList.get(i).getMenuID()
						+ " item id: " + menuItemList.get(i).getMenuItemID()
						+ " " + menuItemList.get(i).getMenuItemName());
			}
		}

		for (int i = 0; i < orderList.size(); i++) {
			if ((orderList.get(i).getStallID() == stallID)
					&& (orderList.get(i).getOrderStatus().equals("Processing"))) {
				this.orderDetailList = new ArrayList<OrderDetail>();
				this.orderIDList.add(orderList.get(i));
				for (int j = 0; j < orderDetailList.size(); j++) {
					if (orderDetailList.get(j).getOrderID() == orderList.get(i)
							.getOrderID()) {
						this.orderDetailList.add(new OrderDetail(
								orderDetailList.get(j).getMenuItemID(),
								orderDetailList.get(j).getOrderID(),
								orderDetailList.get(j).getActualPrice(),
								orderDetailList.get(j).getQuantity()));
						System.out.println(orderDetailList.get(j).getMenuItemID());
						write = true;
					}
				}
				if (write) {
					System.out.println("add to list");
					orderDetails.put(orderList.get(i), this.orderDetailList);
				}
				write = false;
			}
		}
		
		System.out.println("orderIDList size is after initialization" + orderIDList.size());
	}

	public void initOrderButtons(int stallID, ArrayList<Order> orderList) {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);

		orderButtons = new HashMap<JButton, Order>();
		for (; currentItem < orderList.size(); currentItem++) {
			if (totalWidth >= ordersPanel.getWidth()) {
				if (totalHeight >= ordersPanel.getHeight())
					break;
				else {
					posX = 0;
					totalWidth = 2 * (MENUITEM_BUTTON_WIDTH + MARGIN);
					posY += MENUITEM_BUTTON_HEIGHT + MARGIN;
					totalHeight += MENUITEM_BUTTON_HEIGHT + MARGIN;
				}
			} else {
				totalWidth += MENUITEM_BUTTON_WIDTH + MARGIN;
			}
			addOrderIDButtons(orderList.get(currentItem));
			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
		}
	}

	public void refreshButton() {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);
		for (; currentItem < orderIDList.size(); currentItem++) {
			if (totalWidth >= ordersPanel.getWidth()) {
				if (totalHeight >= ordersPanel.getHeight())
					break;
				else {
					posX = 0;
					totalWidth = 2 * (MENUITEM_BUTTON_WIDTH + MARGIN);
					posY += MENUITEM_BUTTON_HEIGHT + MARGIN;
					totalHeight += MENUITEM_BUTTON_HEIGHT + MARGIN;
				}
			} else {
				totalWidth += MENUITEM_BUTTON_WIDTH + MARGIN;
			}
			addOrderIDButtons(orderIDList.get(currentItem));
			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
		}
	}

	public void addOrderIDButtons(Order order) {
		JButton orderIDButton = new JButton("Order "
				+ Integer.toString(order.getOrderID()));
		orderIDButton.setSize(new Dimension(MENUITEM_BUTTON_WIDTH,
				MENUITEM_BUTTON_HEIGHT));
		orderIDButton.setLocation(posX, posY);
		orderIDButton.setActionCommand(Integer.toString(order.getOrderID()));
		orderButtons.put(orderIDButton, order);
		orderIDButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double tempTotal = 0.00;
				orderID = orderButtons.get(e.getSource()).getOrderID();
				receipt.setText("ORDER: " + orderID + "\n"
						+ "========================================" + "\n");
				receipt.setText(receipt.getText() + "Qty" + "   ItemName"
						+ "\t" + "      " + "TotalAmount\n");
				System.out.println("orderIDList size is " + orderIDList.size());
				System.out.println("orderDetails size is " + orderDetails.size());
				System.out.println("menuItems size is " + menuItems.size());
				for (int j = 0; j < orderIDList.size(); j++) {
					
					if (orderIDList.get(j).getOrderID() == orderButtons.get(
							e.getSource()).getOrderID()) {
						for (int i = 0; i < orderDetails.get(orderIDList.get(j)).size(); i++) {
								System.out.println(orderDetails.get(orderIDList.get(j)).size());
								System.out.println(orderDetails.get(orderIDList.get(j)).get(i).getMenuItemID());
							receipt.append(orderDetails.get(orderIDList.get(j))
									.get(i).getQuantity()
									+ "   "
									+ menuItems.get(
											orderDetails.get(orderIDList.get(j))
													.get(i).getMenuItemID())
											.getMenuItemName()
									+ "  $"
									+ orderDetails.get(orderIDList.get(j)).get(i)
											.getActualPrice()
									+ ""
									+ "\t"
									+ "$"
									+ (orderDetails.get(orderIDList.get(j))
											.get(i).getQuantity() * orderDetails
											.get(orderIDList.get(j)).get(i)
											.getActualPrice()) + "\n");
							tempTotal += (orderDetails.get(orderIDList.get(j))
									.get(i).getQuantity() * orderDetails
									.get(orderIDList.get(j)).get(i)
									.getActualPrice());
						}
					}
				}
				receipt.setText(receipt.getText() + "\n\n"
						+ "========================================\n"
						+ "TOTAL: \t\t" + "$" + tempTotal
						+ "\n========================================");
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
		btnMainPage = new JButton("MAIN PAGE");
		btnNextPage = new JButton("NEXT PAGE");
		btnPrevPage = new JButton("PREV PAGE");

		posX = MARGIN;
		posY = MARGIN;

		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(SIDEPANEL_BUTTON_FONT);
		btnMainPage.setBackground(new Color(255, 0, 0));
		btnMainPage.setBounds(posX, posY, SIDEBUTTON_WIDTH, SIDEBUTTON_HEIGHT);
		btnMainPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.replacePanel("CamsMainMenuForm");
			}

		});
		sidePanel.add(btnMainPage);

		posY += SIDEBUTTON_HEIGHT + MARGIN;

		btnNextPage.setForeground(Color.WHITE);
		btnNextPage.setFont(SIDEPANEL_BUTTON_FONT);
		btnNextPage.setBackground(new Color(100, 149, 237));
		btnNextPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentItem < menuItemList.size()) {
					btnNextPage.setEnabled(true);
					btnPrevPage.setEnabled(true);
					currentItem = (page * 9) + 1;
					page++;
					ordersPanel.removeAll();
					refreshButton();
					revalidate();
					repaint();
					System.out.println("Page: " + page);
				}
			}

		});
		btnNextPage.setBounds(posX, posY, SIDEBUTTON_WIDTH, SIDEBUTTON_HEIGHT);
		sidePanel.add(btnNextPage);

		posY += SIDEBUTTON_HEIGHT + MARGIN;

		btnPrevPage.setForeground(Color.WHITE);
		btnPrevPage.setFont(SIDEPANEL_BUTTON_FONT);
		btnPrevPage.setBackground(new Color(100, 149, 237));
		btnPrevPage.setEnabled(false);
		btnPrevPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (page > 2) {
					btnNextPage.setEnabled(true);
					btnPrevPage.setEnabled(true);
					currentItem = (--page-1) * 9 +1;
					ordersPanel.removeAll();
					refreshButton();
					revalidate();
					repaint();
					System.out.println("Page: " + page);
				} else {
					page = 1;
					btnNextPage.setEnabled(true);
					btnPrevPage.setEnabled(true);
					currentItem = 0;
					ordersPanel.removeAll();
					refreshButton();
					revalidate();
					repaint();
					System.out.println("Page: " + page);
				}
			}

		});
		btnPrevPage.setBounds(posX, posY, SIDEBUTTON_WIDTH, SIDEBUTTON_HEIGHT);
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
				if (!searchIDTextField.getText().isEmpty()) {
					searchIDTextField.setText(searchIDTextField.getText().substring(0,
							searchIDTextField.getText().length() - 1));
				}

			}
		});

		numpadPanel.enter().setVisible(false);
	}
}
