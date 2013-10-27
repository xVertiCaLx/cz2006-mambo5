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
import mambo5.Controller.MenuItemController;
import mambo5.Controller.OrderController;
import mambo5.Controller.OrderDetailController;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class CamsCreateOrderForm extends JPanel implements JInterfaceController {

	private OrderController oc;
	private OrderDetailController odc;

	private Map<JButton, MenuItem> menuItemButtons;

	// For Order
	private int custID;
	private Timestamp purchaseDate;
	private String orderStatus;

	// For OrderDetails
	private int order, menuID;
	private int stallID;
	private int posX = 0, posY = 0;

	// For MenuItem
	private ArrayList<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
	private ArrayList<MenuItem> menuItemList;

	private JPanel receiptPanel, menuItemPanel, sidePanel;

	private JTextArea receipt;
	private JScrollPane receiptScrollPane;

	private NumPad numpadPanel;

	JButton btnClear = new JButton("CLEAR");
	JButton btnConfirmOrder = new JButton();

	JButton btnMainPage = new JButton("MAIN PAGE");
	JButton btnNextPage = new JButton("NEXT PAGE");
	JButton btnPrevPage = new JButton("PREV PAGE");

	JLabel totalPrice = new JLabel();

	public CamsCreateOrderForm(final CamsMainFrame mainFrame, final ArrayList<MenuItem> menuItemList, int menuID) {
		// default
		this.menuItemList = menuItemList;
		this.menuID = menuID;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		initPanels();
		implementButtons();
	}

	// initialise panels
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
				// action performance
				receipt.append("1    ");
			}
		});

		numpadPanel.num2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("2    ");
			}
		});

		numpadPanel.num3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("3    ");
			}
		});

		numpadPanel.num4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("4    ");
			}
		});

		numpadPanel.num5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("5    ");
			}
		});

		numpadPanel.num6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("6    ");
			}
		});

		numpadPanel.num7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("7    ");
			}
		});

		numpadPanel.num8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("8    ");
			}
		});

		numpadPanel.num9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receipt.append("9    ");
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

	// initialise menuitem buttons
	public void initMenuItemButtons(int menuID) {
		menuItemButtons = new HashMap<JButton, MenuItem>();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getMenuID() == menuID)
				addMenuItemButtons(menuItemList.get(i));
		}
	}

	public void addMenuItemButtons(MenuItem menuItem) {
		JButton menuItemButton = new JButton(menuItem.getMenuItemName());
		menuItemButton.setActionCommand(menuItem.getMenuItemName());
		menuItemButtons.put(menuItemButton, menuItem);
		menuItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				double discount = menuItemButtons.get(e.getSource())
						.getDiscount();
				double actualPrice = menuItemButtons.get(e.getSource())
						.getMenuItemPrice();
				actualPrice = (actualPrice * (100 - discount)) / 100;

				receipt.append("\t"
						+ (menuItemButtons.get(e.getSource()).getMenuItemName())
						+ "\t$"
						+ menuItemButtons.get(e.getSource()).getMenuItemPrice()
						+ "\n");

				orderDetailsList.add(new OrderDetail(menuItemButtons.get(
						e.getSource()).getMenuItemID(), actualPrice));
			}
		});

		menuItemPanel.add(menuItemButton);
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
		for (int i = 0; i < orderDetailsList.size(); i++) {
			odc = new OrderDetailController();
			odc.validateCreateOrderDetail(order, orderDetailsList.get(i)
					.getMenuItemID(), orderDetailsList.get(i).getActualPrice());
			JOptionPane.showMessageDialog(null, (i + 1)
					+ "Order Details Added!");
		}
	}
}