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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.OrderController;
import mambo5.Entity.Order;

public class PendingOrderForm extends JPanel implements JInterfaceController {

	private JPanel receiptPanel, keypadPanel, ordersPanel, sidePanel,
			searchPanel;

	JButton numPad_1 = new JButton("1");
	JButton numPad_2 = new JButton("2");
	JButton numPad_3 = new JButton("3");
	JButton numPad_4 = new JButton("4");
	JButton numPad_5 = new JButton("5");
	JButton numPad_6 = new JButton("6");
	JButton numPad_7 = new JButton("7");
	JButton numPad_8 = new JButton("8");
	JButton numPad_9 = new JButton("9");

	private int stallID;
	private int posX = 0, posY = 0;
	private JTextArea receipt;
	private JScrollPane receiptScrollPane;
	private Map<JButton, Order> orderIDButtons;
	private ArrayList<Order> orderIDList;
	private OrderController OrderController;

	JButton btnMainPage = new JButton("MAIN PAGE");
	JButton btnNextPage = new JButton("NEXT PAGE");
	JButton btnPrevPage = new JButton("PREV PAGE");
	JTextField searchIDTextField;

	public PendingOrderForm(final CamsMainFrame mainFrame, int stallID) {

		this.stallID = stallID;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		initPanels();
	}

	public void initPanels() {
		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH,
				RECEIPTPANE_HEIGHT - 260));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		receipt = new JTextArea(18, 26);// check how to use
		receipt.setEditable(false);
		receipt.setBackground(RECEIPT_BACKGROUND_COLOUR);

		receiptScrollPane = new JScrollPane(receipt);

		receiptPanel.add(receiptScrollPane);
		
		posY += receiptPanel.getHeight();
		searchPanel = new JPanel();
		searchPanel.setSize(new Dimension(RECEIPTPANE_WIDTH, 100));
		searchPanel.setLocation(posX, posY);
		searchPanel.setBackground(new Color(255,255,255));

		searchIDTextField = new JTextField();
		searchIDTextField.setSize(new Dimension(250, JTEXTFIELD_HEIGHT));
		searchIDTextField.setLocation(0,0);
		searchPanel.add(searchIDTextField);
		
		posX = RECEIPTPANE_WIDTH;

		ordersPanel = new JPanel();
		ordersPanel.setSize(new Dimension(MENUITEMPANE_WIDTH,
				MENUITEMPANE_HEIGHT));
		ordersPanel.setLocation(posX, posY);
		ordersPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		posY = ordersPanel.getHeight();

		keypadPanel = new JPanel();
		keypadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		keypadPanel.setLocation(posX, posY);
		keypadPanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		posX += keypadPanel.getWidth();

		sidePanel = new JPanel();
		sidePanel.setSize(SIDEPANE_WIDTH, SIDEPANE_HEIGHT);
		sidePanel.setLocation(posX, posY);
		sidePanel.setBackground(JPANEL_BACKGROUND_COLOUR);

		initSearchPanel();

		initOrderIDButtons(stallID);

		add(receiptPanel);
		add(ordersPanel);
		add(keypadPanel);
		add(sidePanel);
		add(searchPanel);

		initKeypad();
		initSidePanelButton();
	}
	
	public void initSearchPanel() {
		
	}

	// initialise order item buttons
	public void initOrderIDButtons(int orderID) {
		orderIDButtons = new HashMap<JButton, Order>();
		orderIDList = new ArrayList<Order>();
		OrderController = new OrderController();

		// OrderController.retrieveMenuItemList(orderIDList, 5);

		/*
		 * for (int i = 0; i < menuItemList.size(); i++) {
		 * addMenuItemButtons(menuItemList.get(i)); }
		 */
	}

	public void initKeypad() {
		posX = MARGIN;
		posY = MARGIN;

		numPad_1.setFont(new Font("Arial", Font.BOLD, 12));
		numPad_1.setForeground(KEYPAD_FOREGROUND_COLOUR);
		numPad_1.setBackground(KEYPAD_BACKGROUND_COLOUR);
		// numPad_1.setBorder(null);
		numPad_1.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		numPad_1.setLocation(posX, posY);
		numPad_1.setText("1");
		numPad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_1.getText());
			}
		});
		keypadPanel.add(numPad_1);

		numPad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_2.getText());
			}
		});
		numPad_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_2.setForeground(Color.WHITE);
		numPad_2.setBackground(Color.BLACK);
		numPad_2.setBounds(80, 10, 60, 60);
		keypadPanel.add(numPad_2);

		numPad_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_3.getText());
			}
		});
		numPad_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_3.setForeground(Color.WHITE);
		numPad_3.setBackground(Color.BLACK);
		numPad_3.setBounds(150, 10, 60, 60);
		keypadPanel.add(numPad_3);

		numPad_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_4.getText());
			}
		});
		numPad_4.setForeground(Color.WHITE);
		numPad_4.setBackground(Color.BLACK);
		numPad_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_4.setBounds(10, 80, 60, 60);
		keypadPanel.add(numPad_4);

		numPad_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_5.getText());
			}
		});
		numPad_5.setForeground(Color.WHITE);
		numPad_5.setBackground(Color.BLACK);
		numPad_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_5.setBounds(80, 80, 60, 60);
		keypadPanel.add(numPad_5);

		numPad_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_6.getText());
			}
		});
		numPad_6.setForeground(Color.WHITE);
		numPad_6.setBackground(Color.BLACK);
		numPad_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_6.setBounds(150, 80, 60, 60);
		keypadPanel.add(numPad_6);

		numPad_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_7.getText());
			}
		});
		numPad_7.setForeground(Color.WHITE);
		numPad_7.setBackground(Color.BLACK);
		numPad_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_7.setBounds(10, 150, 60, 60);
		keypadPanel.add(numPad_7);

		numPad_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_8.getText());
			}
		});
		numPad_8.setForeground(Color.WHITE);
		numPad_8.setBackground(Color.BLACK);
		numPad_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_8.setBounds(80, 150, 60, 60);
		keypadPanel.add(numPad_8);

		numPad_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIDTextField.setText(searchIDTextField.getText()
						+ numPad_9.getText());
			}
		});
		numPad_9.setForeground(Color.WHITE);
		numPad_9.setBackground(Color.BLACK);
		numPad_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPad_9.setBounds(150, 150, 60, 60);
		keypadPanel.add(numPad_9);
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
}
