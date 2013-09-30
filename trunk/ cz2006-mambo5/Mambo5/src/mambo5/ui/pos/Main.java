package mambo5.ui.pos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.sql.ResultSet;

import mambo5.Controller.*;

public class Main extends JFrame {

	private JPanel contentPane;

	DBController dbController = new DBController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("CaMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel paneTitle = new JPanel();
		paneTitle.setBackground(new Color(0, 51, 102));
		FlowLayout fl_paneTitle = (FlowLayout) paneTitle.getLayout();
		fl_paneTitle.setAlignment(FlowLayout.LEFT);
		contentPane.add(paneTitle, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		ResultSet rset = dbController.executeQuery("Select * from books;");
		 int rowCount = 0;
		 try {
         while(rset.next()) {   // Move the cursor to the next row
            String title = rset.getString("title");
            double price = rset.getDouble("price");
            int    qty   = rset.getInt("qty");
            System.out.println(title + ", " + price + ", " + qty);
            ++rowCount;
         }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
         System.out.println("Total number of records = " + rowCount);
		
	}

	
	
}
