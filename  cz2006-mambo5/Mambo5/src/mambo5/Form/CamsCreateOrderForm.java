package mambo5.Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mambo5.Controller.CustomerController;
import mambo5.Controller.EmailController;
import mambo5.Controller.JInterfaceController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class CamsCreateOrderForm extends JPanel implements JInterfaceController {

	private OrderController oc;
	private OrderDetailController odc;
	private CustomerController cc;
	private EmailController emailController;
	private Map<JButton, MenuItem> menuItemButtons;
	private Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
	private Timestamp purchaseDate;
	private String orderStatus, receiptDetail, quantity = "";
	private int order, menuID, stallID, posX = 0, posY = 0, totalWidth = 0,
			totalHeight = 0, currentMenuItem = 0, page = 1;
	private double totalPrice = 0.0;
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	private ArrayList<MenuItem> menuItemList;

	private JPanel receiptPanel, menuItemPanel, sidePanel;

	private final CamsMainFrame mainFrame;

	private JTextArea receipt;
	private JScrollPane receiptScrollPane;

	private NumPad numpadPanel;
	private boolean writeEnable = true;

	private JButton btnMainPage, btnNextPage, btnPrevPage;
	DecimalFormat df = new DecimalFormat("#.##");

	public CamsCreateOrderForm(final CamsMainFrame mainFrame,
			ArrayList<MenuItem> menuItemList,
			final ArrayList<OrderDetail> orderDetailList, int stallID,
			int menuID) {
		menuItemButtons = new HashMap<JButton, MenuItem>();
		this.menuItemList = new ArrayList<MenuItem>();
		this.menuID = menuID;
		this.stallID = stallID;
		this.mainFrame = mainFrame;

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getMenuID() == menuID) {
				menuItems.put(menuItemList.get(i).getMenuItemID(),
						menuItemList.get(i));
				this.menuItemList.add(menuItemList.get(i));
			}
		}

		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		cc = new CustomerController();
		initPanels();
		implementButtons();
	}

	public void initPanels() {
		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		receipt = new JTextArea(32, 26);
		receipt.setEditable(false);
		receipt.setBackground(RECEIPT_BACKGROUND_COLOUR);
		receiptScrollPane = new JScrollPane(receipt);
		receiptPanel.add(receiptScrollPane);

		posX += receiptPanel.getWidth();

		menuItemPanel = new JPanel();
		menuItemPanel.setLayout(null);
		menuItemPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,
				MENUITEMPANE_HEIGHT));
		menuItemPanel.setLocation(posX, posY);
		menuItemPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		posY += menuItemPanel.getHeight();

		numpadPanel = new NumPad();
		numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		numpadPanel.setLocation(posX, posY);

		posX += numpadPanel.getWidth();

		sidePanel = new JPanel();
		sidePanel.setSize(SIDEPANE_WIDTH, SIDEPANE_HEIGHT);
		sidePanel.setLocation(posX, posY);
		sidePanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		initMenuItemButtons();
		initSidePanelButton();
		add(receiptPanel);
		add(menuItemPanel);
		add(numpadPanel);
		add(sidePanel);
	}

	public void implementButtons() {
		numpadPanel.num1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "1");
				quantity += "1";
			}
		});

		numpadPanel.num2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "2");
				quantity += "2";
			}
		});

		numpadPanel.num3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "3");
				quantity += "3";
			}
		});

		numpadPanel.num4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "4");
				quantity += "4";
			}
		});

		numpadPanel.num5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "5");
				quantity += "5";
			}
		});

		numpadPanel.num6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "6");
				quantity += "6";
			}
		});

		numpadPanel.num7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "7");
				quantity += "7";
			}
		});

		numpadPanel.num8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "8");
				quantity += "8";
			}
		});

		numpadPanel.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "9");
				quantity += "9";
			}
		});

		numpadPanel.num0().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "0");
				quantity += "0";
			}
		});

		numpadPanel.delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText("NEW ORDER \n"
						+ "=======================================\n"
						+ "Quantity" + "\tItemName" + "\t" + "             "
						+ "Amount\n");
				orderDetailList.removeAll(orderDetailList);
				totalPrice = 0;
			}
		});

		numpadPanel.enter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Confirm Order?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					int custID = (Integer.parseInt(JOptionPane
							.showInputDialog("Please enter Customer ID: ")));
					;
					if (cc.retrieveCustomerInfo(custID) != null) {
						if (submitsOrder(custID) == 1){
							submitsOrderDetails();
							mainFrame.init();
							mainFrame.replacePanel("CamsMainMenuForm");
						}
					} else
						JOptionPane.showMessageDialog(null,
								"Invalid Customer ID");

				}
			}
		});
	}

	public void initMenuItemButtons() {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);

		for (; currentMenuItem < menuItemList.size(); currentMenuItem++) {
			// if (menuItemList.get(currentMenuItem).getMenuID() == menuID) {
			if (totalWidth >= menuItemPanel.getWidth()) {
				if (totalHeight >= menuItemPanel.getHeight())
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
			System.out.println(menuItemList.get(currentMenuItem)
					.getMenuItemName()
					+ menuItemList.get(currentMenuItem).getMenuItemID());
			addMenuItemButtons(menuItemList.get(currentMenuItem));
			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
			// }
		}
	}

	public void refreshButton() {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);
		menuItemButtons = new HashMap<JButton, MenuItem>();
		for (; currentMenuItem < menuItemList.size(); currentMenuItem++) {
			if (totalWidth >= menuItemPanel.getWidth()) {
				if (totalHeight >= menuItemPanel.getHeight())
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
			addMenuItemButtons(menuItemList.get(currentMenuItem));
			posX += MENUITEM_BUTTON_WIDTH + MARGIN;
		}
	}

	public void addMenuItemButtons(MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
		menuItemButton.setSize(new Dimension(MENUITEM_BUTTON_WIDTH,
				MENUITEM_BUTTON_HEIGHT));
		menuItemButton.setLocation(posX, posY);
		menuItemButton.setActionCommand(menuItem.getMenuItemName());
		menuItemButtons.put(menuItemButton, menuItem);
		menuItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeEnable = true;
				receiptDetail = "NEW ORDER \n"
						+ "=======================================\n"
						+ "Quantity" + "\tItemName" + "\t" + "             "
						+ "Amount\n";

				int menuItemID = menuItemButtons.get(e.getSource())
						.getMenuItemID(), quantityInt;

				if (quantity.isEmpty())
					quantityInt = 1;
				else
					quantityInt = Integer.parseInt(quantity);
				double actualPrice = menuItemButtons.get(e.getSource())
						.getMenuItemPrice()
						* (1 - (menuItemButtons.get(e.getSource())
								.getDiscount() / 100));

				for (int i = 0; i < orderDetailList.size(); i++) {
					if ((orderDetailList.get(i).getMenuItemID() == menuItemButtons
							.get(e.getSource()).getMenuItemID())) {
						writeEnable = false;
						orderDetailList.get(i).setQuantity(
								orderDetailList.get(i).getQuantity()
										+ quantityInt);
					}

					receiptDetail += orderDetailList.get(i).getQuantity()
							+ "\t"
							+ menuItems.get(
									orderDetailList.get(i).getMenuItemID())
									.getMenuItemName() + "\t "
							+ "               "
							+ orderDetailList.get(i).getActualPrice() + "\n";

					receiptDetail += "\t\t "
							+ "               "
							+ (orderDetailList.get(i).getQuantity() * orderDetailList
									.get(i).getActualPrice()) + "\n";

				}

				if (writeEnable) {
					orderDetailList.add(new OrderDetail(menuItemID,
							actualPrice, quantityInt));
					receiptDetail += quantityInt
							+ "\t"
							+ menuItemButtons.get(e.getSource())
									.getMenuItemName() + "\t "
							+ "               " + actualPrice + "\n";
					receiptDetail += "\t\t " + "               "
							+ (quantityInt * actualPrice) + "\n";
				}

				totalPrice += (quantityInt * actualPrice);
				receiptDetail += "\n\n"
						+ "======================================="
						+ "\nTOTAL PRICE: " + "\t\t " + "               $"
						+ df.format(totalPrice)
						+ "\n=======================================";

				System.out.println("totalPrice is: " + totalPrice);
				quantity = "";
				receipt.setText(receiptDetail);
			}
		});

		menuItemPanel.add(menuItemButton);
	};

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
				if (currentMenuItem < menuItemList.size()) {
					btnNextPage.setEnabled(true);
					btnPrevPage.setEnabled(true);
					currentMenuItem = (page * 9) + 1;
					page++;
					menuItemPanel.removeAll();
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
					currentMenuItem = (--page - 1) * 9 + 1;
					menuItemPanel.removeAll();
					refreshButton();
					revalidate();
					repaint();
					System.out.println("Page: " + page);
				} else {
					page = 1;
					btnNextPage.setEnabled(true);
					btnPrevPage.setEnabled(true);
					currentMenuItem = 0;
					menuItemPanel.removeAll();
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

	private Timestamp getTimeStamp() {
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		return timestamp;
	}

	public int submitsOrder(int custID) {

		double currentCardValue = 0.0;
		int validOrder = 0;

		cc.retrieveCustomerInfo(custID);
		currentCardValue = cc.retrieveCustomerInfo(custID).getCardBalance();

		purchaseDate = getTimeStamp();
		orderStatus = "Processing";

		if (currentCardValue > totalPrice) {
			oc = new OrderController();
			order = oc.validateCreateOrder(custID, purchaseDate, orderStatus,
					stallID);
			if (custID == 0 || purchaseDate.equals("")
					|| orderStatus.equals("") || stallID == 0) {
				JOptionPane.showMessageDialog(null, "Order cannot be created");
			} else {
				JOptionPane.showMessageDialog(null, "Order: " + order + "created");
			}
			validOrder = 1;

			cc.updateCustomerCardBalance(custID,
					(currentCardValue - totalPrice));
			JOptionPane.showMessageDialog(null, "Card balance :" + df.format((currentCardValue - totalPrice)));
			
		} else {
			emailController = new EmailController();
			emailController.sendBalanceAlertEmail(cc.retrieveCustomerInfo(custID).getEmail(), currentCardValue);
			JOptionPane.showMessageDialog(null, "Card has not enough Value");
		}

		return validOrder;
	}

	public void submitsOrderDetails() {
		for (int i = 0; i < orderDetailList.size(); i++) {
			odc = new OrderDetailController();
			odc.validateCreateOrderDetail(order, orderDetailList.get(i)
					.getMenuItemID(), orderDetailList.get(i).getActualPrice(),
					orderDetailList.get(i).getQuantity());
		}
	}
}