package mambo5.Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public interface JInterfaceConstant {
	public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = (int)SCREENSIZE.getWidth(), SCREEN_HEIGHT = (int) SCREENSIZE.getHeight();
	//public static final int WINDOW_WIDTH = (int)(SCREEN_WIDTH*0.8), WINDOW_HEIGHT = (int)(SCREEN_HEIGHT*0.8);
	public static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
	public static final int POS_WINDOW_X = (SCREEN_WIDTH - WINDOW_WIDTH)/2, POS_WINDOW_Y = (SCREEN_HEIGHT - WINDOW_HEIGHT)/2;
	
	public static final int MARGIN = 10;
	public static final int TITLEBAR_WIDTH = WINDOW_WIDTH, TITLEBAR_HEIGHT = 40;
	public static final int TITLELABEL_WIDTH = WINDOW_WIDTH - (2*MARGIN), TITLELABEL_HEIGHT = TITLEBAR_HEIGHT - MARGIN, POS_TITLELABEL_X = MARGIN, POS_TITLELABEL_Y = MARGIN/2;
	public static final int MAINPANE_WIDTH = WINDOW_WIDTH, MAINPANE_HEIGHT = WINDOW_HEIGHT-30;
	
	public static final int CONTENTPANE_WIDTH = WINDOW_WIDTH, CONTENTPANE_HEIGHT = MAINPANE_HEIGHT - TITLEBAR_HEIGHT;
	
	public static final int MENUBUTTON_WIDTH = 250, MENUBUTTON_HEIGHT = 80;
	public static final int STANDARDBUTTON_WIDTH = 120, STANDARDBUTTON_HEIGHT = 30;
	
	public static final int NUMPAD_KEYWIDTH = 60, NUMPAD_KEYHEIGHT = 60;
	public static final int KEYBOARD_KEYWIDTH = 60, KEYBOARD_KEYHEIGHT = 60;
	public static final Color JPANEL_BACKGROUND_COLOUR = new Color(240, 240, 240);
	public static final int JLABEL_HEIGHT = 15;
	public static final int JTEXTFIELD_HEIGHT = 25;
}
