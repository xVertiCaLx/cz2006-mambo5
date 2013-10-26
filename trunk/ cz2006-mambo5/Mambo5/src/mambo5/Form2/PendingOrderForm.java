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
import mambo5.Controller.OrderController;
import mambo5.Entity.Order;

public class PendingOrderForm extends JPanel implements JInterfaceController {

	private JPanel receiptPanel, keypadPanel, ordersPanel, sidePanel,
			searchPanel;

	private JButton numPad_1 = new JButton("1"), numPad_2 = new JButton("2"), numPad_3 = new JButton("3");
	private JButton numPad_4 = new JButton("4"), numPad_5 = new JButton("5"), numPad_6 = new JButton("6");
	private JButton numPad_7 = new JButton("7"), numPad_8 = new JButton("8"), numPad_9 = new JButton("9");

	private int stallID, posX = 0, posY = 0;
	private JTextArea receipt;
	private JScrollPane receiptScrollPane;
	private Map<JButton, Order> orderIDButtons;
	private ArrayList<Order> orderIDList;
	private OrderController OrderController;
	private NumPad numpadPanel;
	private JButton btnMainPage = new JButton("MAIN PAGE"), btnNextPage = new JButton("NEXT PAGE"), btnPrevPage = new JButton("PREV PAGE"), btnSearch;
	private JTextField searchIDTextField;

	public PendingOrderForm(final CamsMainFrame mainFrame, int stallID) {

		this.stallID = stallID;
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX, 40);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);

		initPanels();
		implementButtons();
	}

	public void initPanels() {
		receiptPanel = new JPanel();
		receiptPanel.setSize(new Dimension(RECEIPTPANE_WIDTH, RECEIPTPANE_HEIGHT/2 + 150));
		receiptPanel.setLocation(posX, posY);
		receiptPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		receiptPanel.setLayout(null);
		
		receipt = new JTextArea();
		receipt.setSize(new Dimension(RECEIPT_WIDTH, RECEIPT_HEIGHT/2 + 140));
		receipt.setBackground(WHITE_BACKGROUND_COLOUR);
		receipt.setEditable(false);
		
		receiptScrollPane = new JScrollPane();
		receiptScrollPane.setSize(new Dimension(RECEIPT_WIDTH, RECEIPT_HEIGHT/2 + 140));
		receiptScrollPane.setLocation(MARGIN,MARGIN);
		receiptScrollPane.setBackground(WHITE_BACKGROUND_COLOUR);
		receiptScrollPane.add(receipt);
		
		receiptPanel.add(receiptScrollPane);
		
		posY += receiptPanel.getHeight();
		
		searchPanel = new JPanel();
		searchPanel.setSize(new Dimension(RECEIPTPANE_WIDTH, RECEIPTPANE_HEIGHT/2 - 100));
		searchPanel.setLocation(posX, posY);
		searchPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		searchPanel.setLayout(null);
		
		searchIDTextField = new JTextField();
		searchIDTextField.setSize(new Dimension(RECEIPTPANE_WIDTH - (2*MARGIN), JTEXTFIELD_HEIGHT));
		searchIDTextField.setLocation(MARGIN, MARGIN);
		
		searchPanel.add(searchIDTextField);
		
		posX = receiptPanel.getWidth();
		posY = 0;
		
		ordersPanel = new JPanel();
		ordersPanel.setLayout(null);
		ordersPanel.setSize(new Dimension(MENUITEMPANE_WIDTH, MENUITEMPANE_HEIGHT));
		ordersPanel.setLocation(posX, posY);
		ordersPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		
		posY += ordersPanel.getHeight();
		
		/*keypadPanel = new JPanel();
		//keypadPanel.setLayout(null);
		keypadPanel.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT)); <<< nowonder you cannot see your keys
		keypadPanel.setLocation(posX, posY);
		keypadPanel.setBackground(JPANEL_BACKGROUND_COLOUR);
		initKeypad();*/
		
		numpadPanel = new NumPad();
		numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
		numpadPanel.setLocation(posX, posY);
		posX += numpadPanel.getWidth();
		
		sidePanel = new JPanel();
		sidePanel.setLayout(null);
		sidePanel.setSize(new Dimension(SIDEPANE_WIDTH, SIDEPANE_HEIGHT));
		sidePanel.setLocation(posX, posY);
		
		btnSearch = new JButton("Search");
		btnSearch.setSize(new Dimension(SIDEPANE_WIDTH/2, STANDARDBUTTON_HEIGHT));
		
		posX = (RECEIPTPANE_WIDTH - btnSearch.getWidth())/2;
		posY += searchIDTextField.getAlignmentY() + searchIDTextField.getHeight() + MARGIN;
		
		btnSearch.setLocation(posX,posY);
		
		searchPanel.add(btnSearch);
		
		add(receiptPanel);
		add(searchPanel);
		add(ordersPanel);
		add(numpadPanel);
		add(sidePanel);

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
		//initialise number pad
				numpadPanel = new NumPad();
				numpadPanel.setLayout(null);
				numpadPanel.setSize(new Dimension(KEYPADPANE_WIDTH, KEYPADPANE_HEIGHT));
				numpadPanel.setLocation(posX, posY);
				//implement action listener
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
		//actual implementation
		numpadPanel.num1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action performance
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
		
		
		numpadPanel.enter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Confirm Order?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
				}
			}
		});
	}
}
