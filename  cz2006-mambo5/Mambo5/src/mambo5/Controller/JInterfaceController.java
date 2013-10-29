package mambo5.Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public interface JInterfaceController {
	
	public static final Color WHITE_COLOUR = new Color(255, 255, 255);
	public static final Color BLACK_COLOUR = new Color(0, 0, 0);
	
	public static final Font SIDEPANEL_BUTTON_FONT = new Font("Arial", Font.BOLD, 12);
	
	public static final Color SPLASHSCREEN_TITLE_COLOUR = new Color(110,110,110), WHITE_BACKGROUND_COLOUR = new Color(255,255,255);
	
	public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = (int)SCREENSIZE.getWidth(), SCREEN_HEIGHT = (int) SCREENSIZE.getHeight();
	//public static final int WINDOW_WIDTH = (int)(SCREEN_WIDTH*0.8), WINDOW_HEIGHT = (int)(SCREEN_HEIGHT*0.8);
	public static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
	public static final int POS_WINDOW_X = (SCREEN_WIDTH - WINDOW_WIDTH)/2, POS_WINDOW_Y = (SCREEN_HEIGHT - WINDOW_HEIGHT)/2;
	
	public static final int MENUBUTTON_WIDTH = 250, MENUBUTTON_HEIGHT = 80;
	public static final int STANDARDBUTTON_WIDTH = 120, STANDARDBUTTON_HEIGHT = 30;
	
	public static final int MARGIN = 10;
	public static final int TITLEBAR_WIDTH = WINDOW_WIDTH, TITLEBAR_HEIGHT = 40;
	public static final int TITLELABEL_WIDTH = WINDOW_WIDTH - (3*MARGIN) - STANDARDBUTTON_WIDTH, TITLELABEL_HEIGHT = TITLEBAR_HEIGHT - MARGIN, POS_TITLELABEL_X = MARGIN, POS_TITLELABEL_Y = MARGIN/2;
	public static final int MAINPANE_WIDTH = WINDOW_WIDTH, MAINPANE_HEIGHT = WINDOW_HEIGHT;
	
	public static final int CONTENTPANE_WIDTH = WINDOW_WIDTH, CONTENTPANE_HEIGHT = MAINPANE_HEIGHT - TITLEBAR_HEIGHT;
	public static final int POS_CONTENTPANE_OFFSET_Y = 12;

	public static final int RECEIPTPANE_WIDTH = 300, RECEIPTPANE_HEIGHT = 560, RECEIPT_WIDTH = (RECEIPTPANE_WIDTH-MARGIN-MARGIN), RECEIPT_HEIGHT = (RECEIPTPANE_HEIGHT-MARGIN-MARGIN);
	public static final Color RECEIPT_BACKGROUND_COLOUR = new Color(255,255,255);
	public static final int MENUITEMPANE_WIDTH = CONTENTPANE_WIDTH - RECEIPTPANE_WIDTH, MENUITEMPANE_HEIGHT = 290;
	public static final int KEYPADPANE_WIDTH = 350, KEYPADPANE_HEIGHT = CONTENTPANE_HEIGHT - MENUITEMPANE_HEIGHT;
	public static final int SIDEPANE_WIDTH = CONTENTPANE_WIDTH - RECEIPTPANE_WIDTH - KEYPADPANE_WIDTH, SIDEPANE_HEIGHT = CONTENTPANE_HEIGHT - MENUITEMPANE_HEIGHT; 

	public static final int MENUITEM_BUTTON_WIDTH = (MENUITEMPANE_WIDTH - 30) / 3, MENUITEM_BUTTON_HEIGHT = 80;
	public static final Color KEYPAD_BACKGROUND_COLOUR = new Color(100,100,100);
	public static final Color KEYPAD_FOREGROUND_COLOUR = new Color(255,255,255);
	public static final int KEYPAD_WIDTH = 60, KEYPAD_HEIGHT = 50;
	public static final int KEYPAD_SPECIAL_WIDTH = 100, KEYPAD_SPECIAL_HEIGHT = (3*KEYPAD_WIDTH + 3*MARGIN)/2 - MARGIN;
	
	public static final int KEYBOARD_KEYWIDTH = 60, KEYBOARD_KEYHEIGHT = 60;
	public static final Color JPANEL_BACKGROUND_COLOUR = new Color(240, 240, 240);
	public static final int JLABEL_HEIGHT = 15;
	public static final int JTEXTFIELD_HEIGHT = 25;
	
	public static final int SIDEBUTTON_WIDTH = (SIDEPANE_WIDTH - 2*MARGIN), SIDEBUTTON_HEIGHT = 30;
	
	public static final int STAFF = 1, STALLOWNER = 2, STALLEMPLOYEE = 3;
}
