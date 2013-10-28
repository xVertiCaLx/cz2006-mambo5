package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class CamsCreateOrderForm extends JPanel implements JInterfaceController {

	private OrderController oc;
	private OrderDetailController odc;

	private Map<JButton, MenuItem> menuItemButtons;
	private Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
	
	// HashMap<OrderDetail, Integer>();

	// For Order
	private int custID;
	private Timestamp purchaseDate;
	private String orderStatus, receiptDetail, quantity = "";

	private int order, menuID, stallID, posX = 0, posY = 0, totalWidth = 0,
			totalHeight = 0, currentMenuItem = 0;

	// For MenuItem
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	private ArrayList<MenuItem> menuItemList;

	private JPanel receiptPanel, menuItemPanel, sidePanel;

	private JTextArea receipt;
	private JScrollPane receiptScrollPane;

	private NumPad numpadPanel;
	private boolean writeEnable = true;

	JButton btnClear = new JButton("CLEAR");
	JButton btnConfirmOrder = new JButton();

	JButton btnMainPage = new JButton("MAIN PAGE");
	JButton btnNextPage = new JButton("NEXT PAGE");
	JButton btnPrevPage = new JButton("PREV PAGE");

	JLabel totalPrice = new JLabel();

	public CamsCreateOrderForm(final CamsMainFrame mainFrame, ArrayList<MenuItem> menuItemList, final ArrayList<OrderDetail> orderDetailList, int menuID) {
		this.menuItemList = menuItemList;
		this.menuID = menuID;

		
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

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

		initMenuItemButtons(menuID);
		initSidePanelButton();
		add(receiptPanel);
		add(menuItemPanel);
		add(numpadPanel);
		add(sidePanel);
	}

	public void implementButtons() {
		// actual implementation
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
		
		numpadPanel.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText() + "0");
				quantity += "0";
			}
		});

		numpadPanel.delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.setText(receipt.getText().substring(0,
						receipt.getText().length() - 1));
			}
		});

		numpadPanel.enter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Confirm Order?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					submitsOrder();
					submitsOrderDetails();
				}
			}
		});
	}

	public void initMenuItemButtons(int menuID) {
		posX = 0;
		posY = MARGIN;
		totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
		totalHeight = 2 * (MENUITEM_BUTTON_HEIGHT + MARGIN);
		menuItemButtons = new HashMap<JButton, MenuItem>();
		for (; currentMenuItem < menuItemList.size(); currentMenuItem++) {
			if (menuItemList.get(currentMenuItem).getMenuID() == menuID) {
				if (totalWidth >= menuItemPanel.getWidth()) {
					if (totalHeight >= menuItemPanel.getHeight()) {
						totalHeight = 0;
						posX = 0;
						posY = MARGIN;
						break;
					} else {
						posX = 0;
						totalWidth = (MENUITEM_BUTTON_WIDTH + MARGIN);
						posY += MENUITEM_BUTTON_HEIGHT + MARGIN;
						totalHeight += MENUITEM_BUTTON_HEIGHT + MARGIN;
					}
				} else {
					totalWidth += MENUITEM_BUTTON_WIDTH + MARGIN;
				}
				menuItems.put(menuItemList.get(currentMenuItem).getMenuItemID(), menuItemList.get(currentMenuItem));
				addMenuItemButtons(menuItemList.get(currentMenuItem));
			}

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
				receiptDetail = "";
				
				int menuItemID = menuItemButtons.get(e.getSource()).getMenuItemID(), quantityInt;
				
				if (quantity.isEmpty())
					quantityInt = 1;
				else
					quantityInt = Integer.parseInt(quantity);
				double actualPrice = menuItemButtons.get(e.getSource()).getMenuItemPrice() * (1-(menuItemButtons.get(e.getSource()).getDiscount()/100));
				
				for (int i = 0; i < orderDetailList.size(); i++) {
					if ((orderDetailList.get(i).getMenuItemID() == menuItemButtons.get(e.getSource()).getMenuItemID())){
						writeEnable = false;
						orderDetailList.get(i).setQuantity(orderDetailList.get(i).getQuantity() + quantityInt);
					}
					
					receiptDetail += orderDetailList.get(i).getQuantity() + "\t" + menuItems.get(orderDetailList.get(i).getMenuItemID()).getMenuItemName() + "\t $" + orderDetailList.get(i).getActualPrice() + "\n";
					receiptDetail += "\t\t $" + (orderDetailList.get(i).getQuantity() * orderDetailList.get(i).getActualPrice()) + "\n";
				}
				
				if (writeEnable) {
					orderDetailList.add(new OrderDetail(menuItemID, actualPrice, quantityInt));
					receiptDetail += quantityInt + "\t" + menuItemButtons.get(e.getSource()).getMenuItemName()  + "\t $" + actualPrice + "\n";
					receiptDetail += "\t\t $" + (quantityInt * actualPrice) + "\n";
				}
				quantity = "";
				receipt.setText(receiptDetail);
			}
		});

		menuItemPanel.add(menuItemButton);
	};

	public void repaintReceipt() {
		
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

	private Timestamp getTimeStamp() {
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		return timestamp;
	}

	public void submitsOrder() {
		purchaseDate = getTimeStamp();
		orderStatus = "Processing";
		custID = 1; // Need to know how to retrieve custID
		stallID = 2; // Need to know how to retrieve stallID

		oc = new OrderController();
		order = oc.validateCreateOrder(custID, purchaseDate, orderStatus,
				stallID);
		if (custID == 0 || purchaseDate.equals("") || orderStatus.equals("")
				|| stallID == 0)
			JOptionPane.showMessageDialog(null, "Order cannot be created");
		else
			JOptionPane.showMessageDialog(null, "Order ID: " + order);
	}

	public void submitsOrderDetails() {
		for (int i = 0; i < orderDetailList.size(); i++) {
			odc = new OrderDetailController();
			odc.validateCreateOrderDetail(order, orderDetailList.get(i)
					.getMenuItemID(), orderDetailList.get(i).getActualPrice(), orderDetailList.get(i).getQuantity());
			JOptionPane.showMessageDialog(null, (i + 1)
					+ "This part check PAYMENT!");
		}
	}
}