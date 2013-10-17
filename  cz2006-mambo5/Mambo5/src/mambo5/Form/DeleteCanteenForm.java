package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import mambo5.Controller.CanteenController;
import mambo5.Entity.Canteen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DeleteCanteenForm extends JFrame {

	private JPanel contentPane;
	private CanteenController cc;
	private JComboBox<String> availableCB;
	private ArrayList<Canteen> retrieveCanteenList;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCanteenForm frame = new DeleteCanteenForm();
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
	public DeleteCanteenForm() {
		setTitle("CaMs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel availableLabel = new JLabel("Available Canteen:");
		availableLabel.setBounds(10, 11, 105, 14);
		contentPane.add(availableLabel);
		
		availableCB = getCanteenList();
		availableCB.setBounds(125, 8, 62, 20);
		contentPane.add(availableCB);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitsDeleteCanteen(e);
			}
		});
		deleteBtn.setBounds(277, 7, 89, 23);
		contentPane.add(deleteBtn);
	}
	
	private JComboBox<String> getCanteenList() {
		JComboBox<String> canteenList = new JComboBox<String>();
		cc = new CanteenController();
		retrieveCanteenList = cc.processRetrieveCanteenList();
		
		if(retrieveCanteenList.size() != 0) {
			
			for(int i = 0; i<retrieveCanteenList.size();i++) 
				canteenList.addItem(retrieveCanteenList.get(i).getCanteenName());
		}
		else
			JOptionPane.showMessageDialog(null, "No Canteen Available");
    	
		return canteenList;
	}
	public void submitsDeleteCanteen(ActionEvent e) {
		int resp = JOptionPane.showConfirmDialog(frame, "Do you want to Delete Canteen? ", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			int index = availableCB.getSelectedIndex();
			if(cc.processDeleteCanteen(retrieveCanteenList.get(index).getCanteenID()) == 1) {
				JOptionPane.showMessageDialog(null, "Canteen successfully updated");
				this.dispose();
				DeleteCanteenForm c = new DeleteCanteenForm();
				c.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error when updating to database");
			}
				
		}
		
	}
}
