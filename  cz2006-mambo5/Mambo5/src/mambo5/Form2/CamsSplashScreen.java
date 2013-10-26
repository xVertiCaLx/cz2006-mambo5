package mambo5.Form2;

import java.awt.Dimension;

import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;

public class CamsSplashScreen extends JPanel implements JInterfaceController {

	private int posX = 0, posY = 0;
	
	public CamsSplashScreen(final CamsMainFrame mainFrame) {
		mainFrame.setTitle("Create Menu Item");
		setSize(new Dimension(CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT));
		setLocation(0,0);
		setLayout(null);
		setBackground(JPANEL_BACKGROUND_COLOUR);
	}

}
