package mambo5.Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class Tes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tes frame = new Tes();
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
	public Tes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(50, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tes.class.getResource("/mambo5/resources/img/MAMBO5.png")));
		contentPane.add(lblNewLabel, BorderLayout.WEST);
	}

}
