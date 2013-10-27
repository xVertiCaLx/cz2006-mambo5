package mambo5.Form2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mambo5.Controller.JInterfaceController;
import mambo5.Controller.MenuItemController;
import mambo5.Entity.MenuItem;

public class CamsSplashScreen extends JPanel implements JInterfaceController {

	private int posX = 0, posY = 40, totalHeight = 0, totalWidth=0;
	private JLabel camsLabel, camsSlogan, loading;
	
	public CamsSplashScreen(final CamsMainFrame mainFrame) {
		mainFrame.setTitle("Canteen Management System");
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(posX,posY);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
		
		camsLabel = new JLabel("CaMS");
		camsSlogan = new JLabel("Canteen Management System");
		loading = new JLabel("Loading... Please Wait...");
		
		camsLabel.setFont(new Font("Arial",Font.BOLD, 50));
		camsLabel.setForeground(SPLASHSCREEN_TITLE_COLOUR);
		camsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		camsLabel.setSize(new Dimension(300, 50));
		totalHeight += camsLabel.getHeight();
		totalWidth += camsLabel.getWidth();
		
		camsSlogan.setFont(new Font("Arial",Font.PLAIN, 10));
		camsSlogan.setForeground(SPLASHSCREEN_TITLE_COLOUR);
		camsSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		camsSlogan.setSize(new Dimension(300, 10));
		totalHeight += camsLabel.getHeight() + MARGIN;
		
		loading.setFont(new Font("Arial",Font.BOLD, 10));
		loading.setForeground(SPLASHSCREEN_TITLE_COLOUR);
		loading.setHorizontalAlignment(SwingConstants.CENTER);
		loading.setSize(new Dimension(300, 10));
		totalHeight += loading.getHeight();
		
		posX += (CONTENTPANE_WIDTH - totalWidth) /2;
		posY = (CONTENTPANE_HEIGHT - totalHeight)/2;
		camsLabel.setLocation(posX, posY);
		posY += camsLabel.getHeight();
		camsSlogan.setLocation(posX, posY);
		posY += camsSlogan.getHeight() + MARGIN;
		loading.setLocation(posX, posY);
		add(camsLabel);
		add(camsSlogan);
		add(loading);
	}

}
