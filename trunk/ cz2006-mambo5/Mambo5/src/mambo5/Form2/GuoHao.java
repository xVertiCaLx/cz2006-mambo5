/*
 * 
 * 
 * This page is for me to link to CaMsCreateOrderForm
I will delete it once the relevant functions are working
*
*
*/

package mambo5.Form2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class GuoHao extends JFrame {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GuoHao();
			}
		});
	}
	
	private JPanel titlePanel, contentPane, selectPanel;
	public JLabel titleLabel = new JLabel("#Canteen");;

	public void setSelectPanel(JPanel selectPanel) {
		this.selectPanel = selectPanel;
	}

	public JPanel getSelectPanel() {
		return selectPanel;
	}

	public GuoHao() {
		// the frame
		setResizable(false);
		setVisible(true);
		setTitle("Canteen Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// the background
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 102));
		titlePanel.setBounds(0, 0, 800, 40);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
		titleLabel.setBounds(10, 0, 400, 39);
		titlePanel.add(titleLabel);

		
		//selectPanel = new CamsCreateOrderForm(/*new CamsMainFrame()*/);
		JLabel label_1 = new JLabel("#Store Name | #CaMS Page");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(0, 0, 794, 39);
		//contentPane.add(new CamsCreateOrderForm(/*new CamsMainFrame()*/));
		contentPane.add(new RefundOrderForm(/*new CamsMainFrame()*/));
	}
	
}
