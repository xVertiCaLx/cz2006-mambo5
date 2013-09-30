package mambo5.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CreateOrderForm extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=291,19
	 */
	private final JLabel lblOrderId = new JLabel("NEW ORDER #xxx");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateOrderForm frame = new CreateOrderForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateOrderForm() {
		setTitle("Create Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Chicken Chop");
		btnNewButton.setBounds(336, 26, 120, 52);
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnLambChop = new JButton("Lamb Chop");
		btnLambChop.setBounds(463, 26, 120, 52);
		btnLambChop.setBackground(new Color(105, 105, 105));
		btnLambChop.setForeground(Color.WHITE);
		contentPane.add(btnLambChop);
		
		JButton btnPorkChop = new JButton("Pork Chop");
		btnPorkChop.setBounds(592, 26, 120, 52);
		btnPorkChop.setBackground(new Color(105, 105, 105));
		btnPorkChop.setForeground(Color.WHITE);
		contentPane.add(btnPorkChop);
		
		JButton btnRibeyeSteak = new JButton("Ribeye Steak");
		btnRibeyeSteak.setBounds(336, 97, 120, 52);
		btnRibeyeSteak.setBackground(new Color(105, 105, 105));
		btnRibeyeSteak.setForeground(Color.WHITE);
		contentPane.add(btnRibeyeSteak);
		
		JButton btnLambChop_1 = new JButton("Sirloin Steak");
		btnLambChop_1.setBounds(463, 97, 120, 52);
		btnLambChop_1.setBackground(new Color(105, 105, 105));
		btnLambChop_1.setForeground(Color.WHITE);
		contentPane.add(btnLambChop_1);
		
		JButton btnBeefSteak = new JButton("Beef Steak");
		btnBeefSteak.setBounds(592, 97, 120, 52);
		btnBeefSteak.setBackground(new Color(105, 105, 105));
		btnBeefSteak.setForeground(Color.WHITE);
		contentPane.add(btnBeefSteak);
		
		JButton btnEatIn = new JButton("EAT IN");
		btnEatIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEatIn.setForeground(Color.WHITE);
		btnEatIn.setBackground(new Color(0, 128, 0));
		btnEatIn.setBounds(336, 260, 89, 23);
		contentPane.add(btnEatIn);
		
		JButton btnTakeOut = new JButton("TAKE OUT");
		btnTakeOut.setForeground(Color.WHITE);
		btnTakeOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTakeOut.setBackground(new Color(0, 128, 0));
		btnTakeOut.setBounds(453, 260, 89, 23);
		contentPane.add(btnTakeOut);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 26, 293, 525);
		JTextArea card = new JTextArea(24, 26);
		contentPane.add(textArea);
		contentPane.add(new JScrollPane(card));
		
		JButton button = new JButton("1");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		//               x  , y  , x-size, y-size
		button.setBounds(338, 323, 57, 44);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(408, 323, 57, 44);
		contentPane.add(btnNewButton_1);
		
		JButton button_1 = new JButton("3");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(478, 323, 57, 44);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.BLACK);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBounds(338, 382, 57, 44);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.BLACK);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(408, 382, 57, 44);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(Color.BLACK);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBounds(478, 382, 57, 44);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(Color.BLACK);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBounds(338, 445, 57, 44);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.BLACK);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBounds(408, 445, 57, 44);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(Color.BLACK);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setBounds(478, 445, 57, 44);
		contentPane.add(button_7);
		
		JButton btnChickenCutlet = new JButton("Chicken Cutlet");
		btnChickenCutlet.setBounds(336, 170, 120, 52);
		btnChickenCutlet.setBackground(new Color(105, 105, 105));
		btnChickenCutlet.setForeground(Color.WHITE);
		contentPane.add(btnChickenCutlet);
		
		JButton btnPorkCutlet = new JButton("Pork Cutlet");
		btnPorkCutlet.setBounds(592, 170, 120, 52);
		btnPorkCutlet.setBackground(new Color(105, 105, 105));
		btnPorkCutlet.setForeground(Color.WHITE);
		contentPane.add(btnPorkCutlet);
		
		JButton btnFishCutlet = new JButton("Fish Cutlet");
		btnFishCutlet.setBounds(463, 170, 120, 52);
		btnFishCutlet.setBackground(new Color(105, 105, 105));
		btnFishCutlet.setForeground(Color.WHITE);
		contentPane.add(btnFishCutlet);
		
		JButton btnX = new JButton("Backspace");
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnX.setBackground(Color.BLACK);
		btnX.setBounds(557, 323, 100, 98);
		contentPane.add(btnX);
		
		JButton btnWhitespace = new JButton("whitespace");
		btnWhitespace.setForeground(Color.WHITE);
		btnWhitespace.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWhitespace.setBackground(Color.BLACK);
		btnWhitespace.setBounds(368, 507, 139, 44);
		contentPane.add(btnWhitespace);
		
		JButton btnMainPage = new JButton("Main Page");
		btnMainPage.setForeground(Color.WHITE);
		btnMainPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainPage.setBackground(new Color(255, 0, 0));
		btnMainPage.setBounds(673, 528, 100, 23);
		contentPane.add(btnMainPage);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setForeground(Color.WHITE);
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBackground(new Color(100, 149, 237));
		btnNextPage.setBounds(673, 448, 100, 23);
		contentPane.add(btnNextPage);
		
		JButton btnPrevPage = new JButton("Prev Page");
		btnPrevPage.setForeground(Color.WHITE);
		btnPrevPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrevPage.setBackground(new Color(100, 149, 237));
		btnPrevPage.setBounds(673, 488, 100, 23);
		contentPane.add(btnPrevPage);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setBounds(557, 452, 100, 98);
		contentPane.add(btnEnter);
	}
}
